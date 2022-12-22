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
public class ShowFilmPageWithSearchStepDef {

    @Autowired
    FilmController filmController;

    Integer pageNum;
    String search;
    Page<Film> page;

    @Given("a list of films exists at page {int} and search term {string}")
    public void a_list_of_films_exists_at_page_and_search_term(Integer page, String search) {
        this.pageNum = page;
        this.search = search;
    }


    @When("requesting film details of search")
    public void requestingFilmDetailsOfSearch() {
        this.page = this.filmController.getFilms(search, pageNum-1).getBody();
    }


    @Then("the ids {int} {int} will be shown for the search")
    public void theIdsIdIdWillBeShownForTheSearch(Integer id1, Integer id2) {
        Integer[] ids = {id1, id2};

        for (Integer id : ids) {
            boolean found = false;
            for (Film film: this.page.stream().toList()) {
                if (film.getFilmId().equals(id)) {
                    found = true;
                    break;
                }
            }

            Assertions.assertTrue(found, "Id not found for id " + id);
        }

    }
}
