package UIElements.theSoftwareInstitute.FilmActor;

import java.io.Serializable;

public class FilmActorId implements Serializable {
    private Integer filmId;
    private Integer actorId;

    public FilmActorId() {}

    public FilmActorId(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }
}
