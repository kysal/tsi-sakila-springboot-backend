package UIElements.theSoftwareInstitute.stepdefs.Film;

import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.Film.FilmController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@ScenarioScope
public class ShowFilmPageStepDef {

    @Autowired
    FilmController filmController;

    Integer pageNum;
    Page<Film> page;

    @Given("a list of films exists at page {int}")
    public void a_list_of_films_exists_at_page(Integer page) {
        this.pageNum = page;
    }


    @When("requesting the film details")
    public void requestingTheFilmDetails() {
        this.page = filmController.getFilms(this.pageNum-1).getBody();
    }


    @Then("the ids {int} {int} will be shown")
    public void theIdsIdIdWillBeShown(Integer id1, Integer id2) {
        Integer[] ids = {id1, id2};

        for (Integer id : ids) {
            boolean found = false;
            for (Film film: this.page.stream().toList()) {
                if (film.getFilmId().equals(id)) {
                    found = true;
                    break;
                }
            }

            Assertions.assertTrue(found, "Id not found");
        }


    }
}
