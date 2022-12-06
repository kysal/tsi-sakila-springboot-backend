package UIElements.theSoftwareInstitute.Film;

import UIElements.theSoftwareInstitute.Actor.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;

@RequestMapping("/film")
@RestController
public class FilmController {

    private final FilmRepository repo;

    FilmController(FilmRepository filmRepository) {
        this.repo = filmRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Film> getAllFilms() {
        return repo.findAll();
    }

    @GetMapping("/{filmId}")
    public Film getFilmById(@PathVariable(value = "filmId") Integer filmId) {
        return repo.findById(filmId).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist"));
    }

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Film> createFilm(@RequestBody Film newFilm) throws ServerException {
        Film film = repo.save(newFilm);
        if (film == null) throw new ServerException("Server failed");
        else return new ResponseEntity<>(film, HttpStatus.CREATED);
    }

    @GetMapping("/byRating/{rating}")
    public @ResponseBody Iterable<Film> getFilmsByRating(@PathVariable(value = "rating") String rating) {
        return repo.findByRating(rating);
    }

    @GetMapping("/byCategory/{categoryId}")
    public @ResponseBody Iterable<Film> getFilmsByCategoryId(@PathVariable(value = "categoryId") Integer catId) {
        return repo.findByCategoryId(catId);
    }

    @GetMapping("/byCategoryName/{category}")
    public @ResponseBody Iterable<Film> getFilmsByCategoryName(@PathVariable(value = "category") String category) {
        return repo.findByCategoryName(category);
    }

    @GetMapping("/byDescription/{keyword}")
    public @ResponseBody Iterable<Film> getFilmsByKeyword(@PathVariable(value = "keyword") String keyword) {
        return repo.findByDescriptionKeyword(keyword);
    }

    @GetMapping("/{filmId}/actors")
    public @ResponseBody Iterable<Actor> getActorsInFilm(@PathVariable(value = "filmId") Integer filmId) {
        return repo.findActorsInFilm(filmId);
    }

    @GetMapping("/count")
    public @ResponseBody Long getFilmCount() {
        return repo.count();
    }

}
