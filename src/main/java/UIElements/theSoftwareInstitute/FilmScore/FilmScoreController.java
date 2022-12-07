package UIElements.theSoftwareInstitute.FilmScore;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/rating")
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

    @GetMapping("/film/{filmId}")
    public @ResponseBody Double getFilmRating(@PathVariable(value = "filmId") Integer filmId) {
        return repo.getFilmRating(filmId);
    }

    @GetMapping("/user/{userId}")
    public @ResponseBody Iterable<FilmScore> findUserRatings(@PathVariable(value = "userId") Integer userId) {
        return repo.findUserRatings(userId);
    }



}
