package UIElements.theSoftwareInstitute.FilmScore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmScoreRepository extends JpaRepository<FilmScore, Integer> {

    @Query(value = "SELECT AVG(fs.score) FROM FilmScore fs WHERE fs.film.filmId = ?1")
    Double getFilmRating(Integer filmId);

    @Query(value = "SELECT fs FROM FilmScore fs WHERE fs.user.userId = ?1")
    Iterable<FilmScore> findUserRatings(Integer userId);

}
