package UIElements.theSoftwareInstitute.stepdefs.Actor;

import UIElements.theSoftwareInstitute.Actor.Actor;
import UIElements.theSoftwareInstitute.Actor.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ScenarioScope
public class ShowSingleActorStepDef {

    @Autowired
    ActorRepository actorRepo;

    Integer actorId;
    Actor chosenActor;

    @Given("an actor exists with id {int}")
    public void an_actor_exists_with_id(Integer id) {
        this.actorId = id;
    }

    @When("requesting actor details")
    public void requesting_actor_details() {
        this.chosenActor = this.actorRepo.findById(this.actorId).orElseThrow(() -> new ResourceAccessException("Actor ID doesn't exist"));
        Assertions.assertNotEquals(null, this.chosenActor, "Actor was not retrieved");
    }

    @Then("the website will show {string} and {string} of actor")
    public void the_website_will_show_first_name_and_last_name(String firstName, String lastName) {
        String expectedDetails = firstName + " " + lastName;
        String actualDetails = this.chosenActor.getFirstName() + " " + this.chosenActor.getLastName();
        Assertions.assertEquals(expectedDetails, actualDetails, "Actor details do not match expected result");
    }
}
