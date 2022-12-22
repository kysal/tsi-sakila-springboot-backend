package UIElements.theSoftwareInstitute.FilmScore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FilmScoreRepository extends JpaRepository<FilmScore, Integer> {

    @Query(value = "SELECT AVG(fs.score) FROM FilmScore fs WHERE fs.film.filmId = ?1")
    Double getFilmRating(Integer filmId);

    @Query(value = "SELECT fs FROM FilmScore fs WHERE fs.user.userId = ?1")
    Iterable<FilmScore> findUserRatings(Integer userId);

    @Query(value = "SELECT fs.score FROM FilmScore fs WHERE fs.film.filmId = ?1 AND fs.user.userId = ?2")
    Integer getSingleUserRating(Integer filmId, Integer userId);

    @Modifying
    @Query(value = "DELETE FROM FilmScore fs WHERE fs.film.filmId = ?1 AND fs.user.userId = ?2")
    void deleteUserRating(Integer filmId, Integer userId);

    @Modifying
    @Query(value = "UPDATE FilmScore fs SET fs.score = ?1 WHERE fs.film.filmId = ?2 AND fs.user.userId = ?3")
    void updateUserRating(Integer newScore, Integer filmId, Integer userId);

}
