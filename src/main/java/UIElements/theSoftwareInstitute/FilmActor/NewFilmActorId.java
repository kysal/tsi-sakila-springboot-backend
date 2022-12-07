package UIElements.theSoftwareInstitute.FilmActor;

import UIElements.theSoftwareInstitute.Actor.Actor;
import UIElements.theSoftwareInstitute.Film.Film;

import java.io.Serializable;

public class NewFilmActorId implements Serializable {
    private Film film;
    private Actor actor;

    public NewFilmActorId() {}

    public NewFilmActorId(Film film, Actor actor) {
        this.film = film;
        this.actor = actor;
    }

}
