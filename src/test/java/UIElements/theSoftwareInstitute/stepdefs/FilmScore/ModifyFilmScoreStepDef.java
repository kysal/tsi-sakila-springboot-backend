package UIElements.theSoftwareInstitute.stepdefs.FilmScore;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.FilmScore.FilmScore;
import UIElements.theSoftwareInstitute.FilmScore.FilmScoreController;
import UIElements.theSoftwareInstitute.User.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.ServerException;


@ScenarioScope
public class ModifyFilmScoreStepDef {

    @Autowired
    FilmScoreController filmScoreController;

    Integer filmId;
    Integer userId;
    Film film;
    User user;
    Integer expectedScore;

    //FilmScore filmScore;

    @Given("a film exists of id {int} and a user exists with id {int}")
    public void aFilmExistsOfIdFilmIdAndAUserExistsWithIdUserId(Integer filmId, Integer userId) {
        this.filmId = filmId;
        this.userId = userId;
        film = new Film();
        film.setFilmId(this.filmId);
        user = new User();
        user.setUserId(this.userId);
    }

    @When("creating a new film score of {int}")
    public void creatingANewFilmScoreOfScore(Integer score) throws ServerException {
        expectedScore = score;
        FilmScore filmScore = new FilmScore(film, user, score);

        filmScoreController.addNewFilmScore(filmScore);
    }

//    @And("updating film score to {int}")
//    public void updatingFilmScoreToScore(Integer score) throws ServerException {
//
//        FilmScore filmScore = new FilmScore();
//        filmScore.setFilm(film);
//        filmScore.setUser(user);
//        filmScore.setScore(score);
//
//        filmScoreController.updateFilmScore(filmScore);
//    }
//
//
//    @And("deleting film score")
//    public void deleting_film_score() {
//
//        filmScoreController.deleteFilmScore(filmId, userId);
//
//    }

    @Then("the film score will be removed")
    public void theFilmScoreWillBeRemoved() {
        Integer score = filmScoreController.getSingleFilmScore(filmId, userId).getBody();
        Assertions.assertEquals(score, expectedScore);
    }


}
