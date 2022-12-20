package UIElements.theSoftwareInstitute.Film;

import UIElements.theSoftwareInstitute.Actor.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT f FROM Film f WHERE f.rating = ?1", nativeQuery = false)
    Iterable<Film> findByRating(String rating);

    @Query(value = "SELECT f FROM Film f INNER JOIN FilmCategory fc ON fc.film = f WHERE fc.category.categoryId = ?1", nativeQuery = false)
    Iterable<Film> findByCategoryId(int categoryId);


//    @Query(value = "SELECT f FROM Film f WHERE f.filmCategoryList = ?1", nativeQuery = false)
//    Iterable<Film> findByCategoryId(int categoryId);

    @Query(value = "SELECT f FROM Film f INNER JOIN FilmCategory fc ON fc.film = f INNER JOIN Category c ON c = fc.category WHERE c.name = ?1")
    Iterable<Film> findByCategoryName(String category);

    @Query(value = "SELECT f FROM Film f WHERE f.description LIKE %?1%")
    Iterable<Film> findByDescriptionKeyword(String keyword);

    @Query(value = "SELECT a FROM Actor a INNER JOIN FilmActor fa ON fa.actor = a WHERE fa.film.filmId = ?1")
    Iterable<Actor> findActorsInFilm(int filmId);

    @Query(value = "SELECT f FROM Film f WHERE f.title LIKE %?1%")
    Iterable<Film> findAllWithTitleLike(String searchTerm);

    @Query(value = "SELECT f FROM Film f WHERE f.title LIKE %?1%")
    Page<Film> findAllWithTitleLike(String searchTerm, Pageable pageable);

}
