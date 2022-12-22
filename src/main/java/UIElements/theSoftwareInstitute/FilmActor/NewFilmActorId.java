package UIElements.theSoftwareInstitute.FilmActor;

import UIElements.theSoftwareInstitute.Actor.Actor;
import UIElements.theSoftwareInstitute.Film.Film;

import java.io.Serializable;
import java.util.Objects;

public class NewFilmActorId implements Serializable {
    private Film film;
    private Actor actor;

    public NewFilmActorId() {}

    public NewFilmActorId(Film film, Actor actor) {
        this.film = film;
        this.actor = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewFilmActorId that = (NewFilmActorId) o;
        return Objects.equals(film.getFilmId(), that.film.getFilmId()) && Objects.equals(actor.getActorId(), that.actor.getActorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(film.getFilmId(), actor.getActorId());
    }
}
