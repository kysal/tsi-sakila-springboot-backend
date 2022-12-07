package UIElements.theSoftwareInstitute.FilmScore;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.User.User;

import java.io.Serializable;

public class FilmScoreId implements Serializable {

    private Film film;
    private User user;

    public FilmScoreId() {}

    public FilmScoreId(Film film, User user) {
        this.film = film;
        this.user = user;
    }
}
