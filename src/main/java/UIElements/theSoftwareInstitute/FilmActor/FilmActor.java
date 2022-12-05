package UIElements.theSoftwareInstitute.FilmActor;

import jakarta.persistence.*;

@Entity
@IdClass(FilmActorId.class)
@Table(name = "film_actor")
public class FilmActor {

    @Id
    @Column(name = "film_id")
    int filmId;

    @Id
    @Column(name = "actor_id")
    int actorId;

    FilmActor() {}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
}
