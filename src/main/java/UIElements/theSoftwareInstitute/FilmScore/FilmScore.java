package UIElements.theSoftwareInstitute.FilmScore;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.User.User;
import jakarta.persistence.*;

@Entity
@IdClass(FilmScoreId.class)
@Table(name = "film_score")
public class FilmScore {
    @Id
    @ManyToOne()
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    private Film film;

    @Id
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "score")
    private Integer score;

    public FilmScore() {}

    public FilmScore(Film film, User user, Integer score) {
        this.film = film;
        this.user = user;
        this.score = score;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
