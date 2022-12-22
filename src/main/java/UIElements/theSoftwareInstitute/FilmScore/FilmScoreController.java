package UIElements.theSoftwareInstitute.FilmScore;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.User.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;

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

    @GetMapping("/film/{filmId}/user/{userId}")
    public @ResponseBody ResponseEntity<FilmScore> getSingleFilmScore(@PathVariable(value = "filmId") Integer filmId, @PathVariable(value = "userId") Integer userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");
        FilmScore score = repo.getSingleUserRating(filmId, userId);
        return ResponseEntity.ok().headers(headers).body(score);
    }

    @GetMapping("/film/{filmId}/user/{userId}/score")
    public @ResponseBody ResponseEntity<Integer> getSingleFilmScoreNumber(@PathVariable(value = "filmId") Integer filmId, @PathVariable(value = "userId") Integer userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");
        Integer score = repo.getSingleUserRatingScore(filmId, userId);
        return ResponseEntity.ok().headers(headers).body(score);
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmScore> addNewFilmScore(@RequestBody FilmScore filmScore) throws ServerException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");

        System.out.println(filmScore);

        FilmScore fs = repo.save(filmScore);
        if (fs == null) throw new ServerException("Server failed");
        else return ResponseEntity.ok().headers(headers).body(fs);
    }

    @PutMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateFilmScore(@RequestBody FilmScore filmScore) throws ServerException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");

        FilmScore fs = repo.getSingleUserRating(filmScore.getFilm().getFilmId(), filmScore.getUser().getUserId());
        System.out.println(fs);
        if (fs == null) throw new ServerException("Not found");
        fs.setScore(filmScore.getScore());
        repo.save(fs);

        //repo.updateUserRating(filmScore.getScore(), filmScore.getFilm().getFilmId(), filmScore.getUser().getUserId());
        return ResponseEntity.ok().headers(headers).body(true);
    }

    @DeleteMapping(value = "/film/{filmId}/user/{userId}")
    public ResponseEntity<Boolean> deleteFilmScore(@PathVariable(value = "filmId") Integer filmId, @PathVariable(value = "userId") Integer userId) throws ServerException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Request-Method", "*");
        //repo.deleteUserRating(filmId, userId);
        FilmScore fs = repo.getSingleUserRating(filmId, userId);
        if (fs == null) throw new ServerException("Not found");
        repo.delete(fs);

        return ResponseEntity.ok().headers(headers).body(true);
    }

    @GetMapping("/user/{userId}")
    public @ResponseBody Iterable<FilmScore> findUserRatings(@PathVariable(value = "userId") Integer userId) {
        return repo.findUserRatings(userId);
    }
}
