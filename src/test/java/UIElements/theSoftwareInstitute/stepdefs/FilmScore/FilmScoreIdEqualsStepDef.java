package UIElements.theSoftwareInstitute.stepdefs.FilmScore;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.FilmScore.FilmScoreId;
import UIElements.theSoftwareInstitute.User.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;

@ScenarioScope
public class FilmScoreIdEqualsStepDef {

    FilmScoreId filmScoreId1;
    FilmScoreId filmScoreId2;
    Boolean result;

    @Given("two film scores exist with {int} {int} {int} {int}")
    public void two_film_scores_exist_with(Integer filmId1, Integer userId1, Integer filmId2, Integer userId2) {
        Film film1 = new Film();
        film1.setFilmId(filmId1);
        User user1 = new User();
        user1.setUserId(userId1);
        Film film2 = new Film();
        film2.setFilmId(filmId2);
        User user2 = new User();
        user2.setUserId(userId2);

        this.filmScoreId1 = new FilmScoreId(film1, user1);
        this.filmScoreId2 = new FilmScoreId(film2, user2);
        FilmScoreId filmScoreId3 = new FilmScoreId();

    }


    @When("comparing the two film scores")
    public void comparingTheTwoFilmScores() {

        this.result = this.filmScoreId1.equals(filmScoreId2);
    }


    @Then("they will be correctly determined to equal {string}")
    public void theyWillBeCorrectlyDeterminedToEqualEqual(String expectedResult) {

        Assertions.assertTrue(filmScoreId1.equals(filmScoreId1));
        Assertions.assertFalse(filmScoreId1.equals(null));
        Assertions.assertEquals(Boolean.parseBoolean(expectedResult), filmScoreId1.hashCode() == filmScoreId2.hashCode());
        Assertions.assertEquals(Boolean.parseBoolean(expectedResult), this.result);
    }
}
