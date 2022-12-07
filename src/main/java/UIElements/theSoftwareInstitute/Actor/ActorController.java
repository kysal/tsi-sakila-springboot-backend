package UIElements.theSoftwareInstitute.Actor;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.Film.FilmRepository;
import UIElements.theSoftwareInstitute.FilmActor.FilmActor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;
import java.util.*;

@RequestMapping("/actor")
@RestController
public class ActorController {

    private final ActorRepository repo;
    private final FilmRepository filmRepository;

    ActorController(ActorRepository actorRepository,
                    FilmRepository filmRepository) {
        this.repo = actorRepository;
        this.filmRepository = filmRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Actor> getAllActors() {
        return repo.findAll();
    }

    @GetMapping("/{actorId}")
    public Actor getActorByID(@PathVariable(value = "actorId") int actorId) {
        return repo.findById(actorId).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist"));
    }

    @PutMapping("/{actorId}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "actorId") int actorId, @RequestBody Actor actorDetails) {
        Actor actor = repo.findById(actorId).orElseThrow(() -> new ResourceAccessException("Actor not found"));
        actor.setFirstName(actorDetails.getFirstName());
        actor.setLastName(actorDetails.getLastName());

        final Actor updatedActor = repo.save(actor);
        return ResponseEntity.ok(updatedActor);
    }

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> createActor(@RequestBody Actor newActor) throws ServerException {
        Actor actor = repo.save(newActor);
        if (actor == null) throw new ServerException("Server failed");
        else return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }

    @GetMapping("/{actorId}/films")
    public @ResponseBody Iterable<Film> getFilmsWithActor(@PathVariable(value = "actorId") Integer actorId) {
        return repo.findFilmsWithActor(actorId);
    }

    @GetMapping("/{actorId}/costars")
    public @ResponseBody Collection<Actor> getActorCostars(@PathVariable(value = "actorId") Integer actorId) {
        Iterable<Film> films = getFilmsWithActor(actorId);

        Iterable<FilmActor> filmActors = repo.findActorsInFilms(films);

        HashMap<Integer, Actor> costars = new HashMap<>();

        for (FilmActor filmActor : filmActors) {
            Actor actor = filmActor.getActor();
            if (Objects.equals(actor.getActorId(), actorId)) continue;

            if (costars.containsKey(actor.getActorId())) {
                Actor newActor = costars.get(actor.getActorId());
                newActor.incrementRelations();
                costars.put(actor.getActorId(), newActor);
            } else {
                filmActor.getActor().setRelations(1);
                costars.put(actor.getActorId(), actor);
            }
        }

        return costars.values();
    }

}
