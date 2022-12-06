package UIElements.theSoftwareInstitute.Film;

import UIElements.theSoftwareInstitute.Actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT f FROM Film f WHERE f.rating = ?1", nativeQuery = false)
    Iterable<Film> findByRating(String rating);

    @Query(value = "SELECT f FROM Film f INNER JOIN FilmCategory fc ON fc.filmId = f.filmId WHERE fc.categoryId = ?1", nativeQuery = false)
    Iterable<Film> findByCategoryId(int categoryId);

    @Query(value = "SELECT f FROM Film f INNER JOIN FilmCategory fc ON fc.filmId = f.filmId INNER JOIN Category c ON c.categoryId = fc.categoryId WHERE c.name = ?1")
    Iterable<Film> findByCategoryName(String category);

    @Query(value = "SELECT f FROM Film f WHERE f.description LIKE %?1%")
    Iterable<Film> findByDescriptionKeyword(String keyword);

    @Query(value = "SELECT a FROM Actor a INNER JOIN FilmActor fa ON fa.actorId = a.actorId WHERE fa.filmId = ?1")
    Iterable<Actor> findActorsInFilm(int filmId);

}
