package UIElements.theSoftwareInstitute.stepdefs.FilmScore;

import UIElements.theSoftwareInstitute.FilmScore.FilmScore;
import UIElements.theSoftwareInstitute.FilmScore.FilmScoreController;
import UIElements.theSoftwareInstitute.FilmScore.FilmScoreRepository;
import io.cucumber.spring.ScenarioScope;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class ShowSingleFilmScoreStepDef {
    @Autowired
    FilmScoreRepository filmScoreRepo;

    @Autowired
    FilmScoreController filmScoreController;
    Integer filmId;
    Integer userId;
    Integer chosenFilmScore;
    FilmScore chosenFilmScoreObject;


    @Given("a film score exists with film id {int} and user id {int}")
    public void a_film_score_exists_with_film_id_and_user_id(Integer filmId, Integer userId) {
        this.filmId = filmId;
        this.userId = userId;
    }


    @When("requesting film score details")
    public void requestingFilmScoreDetails() {
        this.chosenFilmScore = filmScoreController.getSingleFilmScoreNumber(this.filmId, this.userId).getBody();
        Assertions.assertNotNull(this.chosenFilmScore);
    }


    @Then("the website will show {int}")
    public void theWebsiteWillShowScore(Integer score) {
        Assertions.assertTrue(this.chosenFilmScore > 0 && this.chosenFilmScore <= 10);
    }
}
