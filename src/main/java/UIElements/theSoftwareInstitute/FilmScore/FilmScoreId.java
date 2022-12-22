package UIElements.theSoftwareInstitute.FilmScore;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.User.User;

import java.io.Serializable;
import java.util.Objects;

public class FilmScoreId implements Serializable {

    private Film film;
    private User user;

    public FilmScoreId() {}

    public FilmScoreId(Film film, User user) {
        this.film = film;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmScoreId that = (FilmScoreId) o;
        return film.getFilmId().equals(that.film.getFilmId()) && user.getUserId().equals(that.user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(film.getFilmId(), user.getUserId());
    }
}
