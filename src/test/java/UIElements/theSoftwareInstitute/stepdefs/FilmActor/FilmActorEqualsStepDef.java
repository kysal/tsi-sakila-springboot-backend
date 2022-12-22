package UIElements.theSoftwareInstitute.stepdefs.FilmActor;

import UIElements.theSoftwareInstitute.Actor.Actor;
import UIElements.theSoftwareInstitute.Film.Film;
import UIElements.theSoftwareInstitute.FilmActor.FilmActor;
import UIElements.theSoftwareInstitute.FilmActor.NewFilmActorId;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;

@ScenarioScope
public class FilmActorEqualsStepDef {

    NewFilmActorId filmActorId1;
    NewFilmActorId filmActorId2;
    Boolean result;

    @Given("two film actors exist with {int} {int} {int} {int}")
    public void two_film_actors_exist_with(Integer filmId1, Integer actorId1, Integer filmId2, Integer actorId2) {
        Film film1 = new Film();
        film1.setFilmId(filmId1);
        Film film2 = new Film();
        film2.setFilmId(filmId2);
        Actor actor1 = new Actor();
        actor1.setActorId(actorId1);
        Actor actor2 = new Actor();
        actor2.setActorId(actorId2);

        this.filmActorId1 = new NewFilmActorId(film1, actor1);
        this.filmActorId2 = new NewFilmActorId(film2, actor2);

        NewFilmActorId filmActorId3 = new NewFilmActorId();
    }


    @When("comparing two film actors")
    public void comparingTwoFilmActors() {
        this.result = this.filmActorId1.equals(filmActorId2);
    }


    @Then("the film actors will be correctly determined to equal {string}")
    public void theFilmActorsWillBeCorrectlyDeterminedToEqual(String expectedResult) {
        Assertions.assertTrue(filmActorId1.equals(filmActorId1));
        Assertions.assertFalse(filmActorId1.equals(null));
        Assertions.assertEquals(Boolean.parseBoolean(expectedResult), filmActorId1.hashCode() == filmActorId2.hashCode());
        Assertions.assertEquals(Boolean.parseBoolean(expectedResult), this.result);

    }
}
