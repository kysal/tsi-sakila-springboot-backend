package UIElements.theSoftwareInstitute.Actor;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.FilmActor.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT f FROM Film f INNER JOIN FilmActor fa ON fa.film = f WHERE fa.actor.actorId = ?1")
    Iterable<Film> findFilmsWithActor(Integer actorId);

    @Query("SELECT fa FROM FilmActor fa WHERE fa.film IN ?1")
    Iterable<FilmActor> findActorsInFilms(Iterable<Film> films);

}
