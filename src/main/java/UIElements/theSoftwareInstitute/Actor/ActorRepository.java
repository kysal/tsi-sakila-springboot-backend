package UIElements.theSoftwareInstitute.Actor;

import UIElements.theSoftwareInstitute.Film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT f FROM Film f INNER JOIN FilmActor fa ON fa.filmId = f.filmId WHERE fa.actorId = ?1")
    Iterable<Film> findFilmsWithActor(Integer actorId);

}
