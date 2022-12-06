package UIElements.theSoftwareInstitute.FilmActor;

import jakarta.persistence.*;

@Entity
@IdClass(FilmActorId.class)
@Table(name = "film_actor")
public class FilmActor {

    @Id
    @Column(name = "film_id")
    Integer filmId;

    @Id
    @Column(name = "actor_id")
    Integer actorId;

    FilmActor() {}

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
}
