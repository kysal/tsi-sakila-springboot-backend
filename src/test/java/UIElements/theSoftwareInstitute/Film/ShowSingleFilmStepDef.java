package UIElements.theSoftwareInstitute.Film;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.Film.FilmRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleFilmStepDef {


    @Autowired
    FilmRepository filmRepo;

    Integer filmId;

    Film chosenFilm;

    @Given("a film exists with id {int}")
    public void a_film_exists_with_id(Integer id) {
        this.filmId = id;
    }

    @When("requesting film details")
    public void requesting_film_details() {
        this.chosenFilm = this.filmRepo.findById(this.filmId).orElseThrow(() -> new ResourceAccessException("Film ID doesn't exist"));
        Assertions.assertNotEquals(null, this.chosenFilm, "Film could not be retrieved");
    }

    @Then("the website will show {string} and {string} of film")
    public void the_website_will_show_title_and_description(String title, String description) {
        Assertions.assertEquals(title, this.chosenFilm.getTitle(), "Title does not match");
        Assertions.assertEquals(description, this.chosenFilm.getDescription(), "Description does not match");
    }


}
