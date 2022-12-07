package UIElements.theSoftwareInstitute.FilmActor;

import UIElements.theSoftwareInstitute.Actor.Actor;
import UIElements.theSoftwareInstitute.Film.Film;
import jakarta.persistence.*;

@Entity
@IdClass(NewFilmActorId.class)
@Table(name = "film_actor")
public class FilmActor {

//    @Id
//    @Column(name = "film_id")
//    Integer filmId;
//
//    @Id
//    @Column(name = "actor_id")
//    Integer actorId;

    @Id
    @ManyToOne()
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    private Film film;

    @Id
    @ManyToOne()
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
    private Actor actor;

    FilmActor() {}

//    public Integer getFilmId() {
//        return filmId;
//    }
//
//    public void setFilmId(Integer filmId) {
//        this.filmId = filmId;
//    }
//
//    public Integer getActorId() {
//        return actorId;
//    }
//
//    public void setActorId(Integer actorId) {
//        this.actorId = actorId;
//    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film filmId) {
        this.film = filmId;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actorId) {
        this.actor = actorId;
    }
}
