package UIElements.theSoftwareInstitute.Film;

import UIElements.theSoftwareInstitute.Actor.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;
import java.util.List;

@RequestMapping("/film")
@CrossOrigin(origins = "*")
@RestController
public class FilmController {

    private final FilmRepository repo;

    FilmController(FilmRepository filmRepository) {
        this.repo = filmRepository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public @ResponseBody ResponseEntity<List<Film>> getAllFilms() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Request-Method", "*");
        return ResponseEntity.ok().headers(headers).body(repo.findAll());
    }

    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity<Page<Film>> getFilms(@PathVariable(value = "page") Integer page) {
        Pageable pageable = PageRequest.of(page, 20);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Request-Method", "*");
        return ResponseEntity.ok().headers(headers).body(repo.findAll(pageable));
    }

    @GetMapping("/page/{page}/search/{term}")
    public @ResponseBody ResponseEntity<Page<Film>> getFilms(@PathVariable(value = "term") String searchTerm, @PathVariable(value = "page") Integer page) {
        Pageable pageable = PageRequest.of(page, 20);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Request-Method", "*");
        return ResponseEntity.ok().headers(headers).body(repo.findAllWithTitleLike(searchTerm, pageable));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/search/{term}")
    public @ResponseBody ResponseEntity<Iterable<Film>> getFilmsBySearch(@PathVariable(value = "term") String searchTerm) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Request-Method", "*");
        return ResponseEntity.ok().headers(headers).body(repo.findAllWithTitleLike(searchTerm));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{filmId}")
    public @ResponseBody ResponseEntity<Film> getFilmById(@PathVariable(value = "filmId") Integer filmId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Request-Method", "*");
        return ResponseEntity.ok().headers(headers).body(repo.findById(filmId).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist")));
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
    public @ResponseBody ResponseEntity<Iterable<Actor>> getActorsInFilm(@PathVariable(value = "filmId") Integer filmId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");
        return ResponseEntity.ok().headers(headers).body(repo.findActorsInFilm(filmId));
    }

    @GetMapping("/count")
    public @ResponseBody Long getFilmCount() {
        return repo.count();
    }

}
