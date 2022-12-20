package UIElements.theSoftwareInstitute.FilmScore;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rating")
@CrossOrigin(origins = "*")
@RestController
public class FilmScoreController {

    private final FilmScoreRepository repo;

    FilmScoreController(FilmScoreRepository filmScoreRepository) {
        this.repo = filmScoreRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<FilmScore> getAllRatings() {
        return repo.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/film/{filmId}")
    public @ResponseBody ResponseEntity<Double> getFilmRating(@PathVariable(value = "filmId") Integer filmId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");
        Double score = repo.getFilmRating(filmId);
        return ResponseEntity.ok().headers(headers).body(score == null ? 0d : score);
    }

    @GetMapping("/user/{userId}")
    public @ResponseBody Iterable<FilmScore> findUserRatings(@PathVariable(value = "userId") Integer userId) {
        return repo.findUserRatings(userId);
    }
}
