package UIElements.theSoftwareInstitute.Actor;

import UIElements.theSoftwareInstitute.Film.Film;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;

@RequestMapping("/actor")
@RestController
public class ActorController {

    private final ActorRepository repo;

    ActorController(ActorRepository actorRepository) {
        this.repo = actorRepository;
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

}
