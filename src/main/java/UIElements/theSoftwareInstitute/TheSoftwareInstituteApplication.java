package UIElements.theSoftwareInstitute;

import UIElements.theSoftwareInstitute.Actor.*;
import UIElements.theSoftwareInstitute.Address.*;
import UIElements.theSoftwareInstitute.Category.*;
import UIElements.theSoftwareInstitute.Film.*;
import UIElements.theSoftwareInstitute.FilmCategory.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;


@RestController
@RequestMapping("/home")
@CrossOrigin
@SpringBootApplication
public class TheSoftwareInstituteApplication {

	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private FilmCategoryRepository filmCategoryRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private AddressRepository addressRepo;


	public TheSoftwareInstituteApplication() {

	}

	@GetMapping("/all-actors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepo.findAll();
	}

	@GetMapping("/get-actor/{actorId}")
	public Actor getActorByID(@PathVariable(value = "actorId") int actorId) {
		return actorRepo.findById(actorId).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist"));
	}

	@PutMapping("/actor/{actorId}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "actorId") int actorId, @RequestBody Actor actorDetails) {
		Actor actor = actorRepo.findById(actorId).orElseThrow(() -> new ResourceAccessException("Actor not found"));
		actor.setFirstName(actorDetails.getFirstName());
		actor.setLastName(actorDetails.getLastName());

		final Actor updatedActor = actorRepo.save(actor);
		return ResponseEntity.ok(updatedActor);
	}

	@PostMapping(value = "/actor",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Actor> createActor(@RequestBody Actor newActor) throws ServerException {
		Actor actor = actorRepo.save(newActor);
		if (actor == null) throw new ServerException("Server failed");
		else return new ResponseEntity<>(actor, HttpStatus.CREATED);
	}

	public static void main(String[] args) {
		SpringApplication.run(TheSoftwareInstituteApplication.class, args);
	}

	@GetMapping("/film")
	public @ResponseBody Iterable<Film> getAllFilms() {
		return filmRepo.findAll();
	}

	@GetMapping("/film/{filmId}")
	public Film getFilmById(@PathVariable(value = "filmId") int filmId) {
		return filmRepo.findById(filmId).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist"));
	}

	@PostMapping(value = "/film",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> createFilm(@RequestBody Film newFilm) throws ServerException {
		Film film = filmRepo.save(newFilm);
		if (film == null) throw new ServerException("Server failed");
		else return new ResponseEntity<>(film, HttpStatus.CREATED);
	}

	@GetMapping("/film/byRating/{rating}")
	public @ResponseBody Iterable<Film> getFilmsByRating(@PathVariable(value = "rating") String rating) {
		return filmRepo.findByRating(rating);
	}

	@GetMapping("/film/byCategory/{categoryId}")
	public @ResponseBody Iterable<Film> getFilmsByCategoryId(@PathVariable(value = "categoryId") int catId) {
		return filmRepo.findByCategoryId(catId);
	}

	@GetMapping("/film-category")
	public @ResponseBody Iterable<FilmCategory> getFilmCategories() {
		return filmCategoryRepo.findAll();
	}

	@GetMapping("/categories")
	public @ResponseBody Iterable<Category> getCategories() {
		return categoryRepo.findAll();
	}

	@GetMapping("/film/byCategoryName/{category}")
	public @ResponseBody Iterable<Film> getFilmsByCategoryName(@PathVariable(value = "category") String category) {
		return filmRepo.findByCategoryName(category);
	}

	@GetMapping("/address")
	public @ResponseBody Iterable<Address> getAddresses() {
		return addressRepo.findAll();
	}

	@GetMapping("/film/description/{keyword}")
	public @ResponseBody Iterable<Film> getFilmsByKeyword(@PathVariable(value = "keyword") String keyword) {
		return filmRepo.findByDescriptionKeyword(keyword);
	}

	@GetMapping("/film/{filmId}/actors")
	public @ResponseBody Iterable<Actor> getActorsInFilm(@PathVariable(value = "filmId") int filmId) {
		return filmRepo.findActorsInFilm(filmId);
	}
}
