package UIElements.theSoftwareInstitute.stepdefs.Film;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.Film.FilmController;
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

    @Autowired
    FilmController filmController;

    Integer filmId;

    Film chosenFilm;
    Film expectedFilm;

    @Given("a film exists with id {int}")
    public void a_film_exists_with_id(Integer id) {
        this.filmId = id;
    }

    @When("requesting film details")
    public void requesting_film_details() {
        this.chosenFilm = filmController.getFilmById(this.filmId).getBody();
        Assertions.assertNotEquals(null, this.chosenFilm, "Film could not be retrieved");
    }



    @Then("the website will show {string} {string} {int} {int} {int} {int} {float} {int} {float} and {string} of film")
    public void the_website_will_show_title_and_description(String title, String description, Integer releaseYear, Integer languageId, Integer originalLanguageId, Integer rentalDuration, Float rentalRate, Integer length, Float replacementCost, String rating) {
        this.expectedFilm = new Film();
        this.expectedFilm.setFilmId(this.filmId);
        this.expectedFilm.setTitle(title);
        this.expectedFilm.setDescription(description);
        this.expectedFilm.setReleaseYear(releaseYear);
        this.expectedFilm.setLanguageId(languageId);
        this.expectedFilm.setOriginalLanguageId((originalLanguageId == 0) ? null : originalLanguageId);
        this.expectedFilm.setRentalDuration(rentalDuration);
        this.expectedFilm.setRentalRate(rentalRate);
        this.expectedFilm.setLength(length);
        this.expectedFilm.setReplacementCost(replacementCost);
        this.expectedFilm.setRating(rating);

        Assertions.assertEquals(this.expectedFilm.getFilmId(), this.chosenFilm.getFilmId());
        Assertions.assertEquals(this.expectedFilm.getDescription(), this.chosenFilm.getDescription());
        Assertions.assertEquals(this.expectedFilm.getReleaseYear(), this.chosenFilm.getReleaseYear());
        Assertions.assertEquals(this.expectedFilm.getLanguageId(), this.chosenFilm.getLanguageId());
        Assertions.assertEquals(this.expectedFilm.getOriginalLanguageId(), this.chosenFilm.getOriginalLanguageId());
        Assertions.assertEquals(this.expectedFilm.getRentalDuration(), this.chosenFilm.getRentalDuration());
        Assertions.assertEquals(this.expectedFilm.getRentalRate(), this.chosenFilm.getRentalRate());
        Assertions.assertEquals(this.expectedFilm.getLength(), this.chosenFilm.getLength());
        Assertions.assertEquals(this.expectedFilm.getReplacementCost(), this.chosenFilm.getReplacementCost());
        Assertions.assertEquals(this.expectedFilm.getRating(), this.chosenFilm.getRating());
        Assertions.assertEquals(this.expectedFilm.getTitle(), this.chosenFilm.getTitle());



    }
}
