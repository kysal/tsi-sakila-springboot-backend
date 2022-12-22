package UIElements.theSoftwareInstitute.stepdefs.Actor;

import UIElements.theSoftwareInstitute.Actor.Actor;
import UIElements.theSoftwareInstitute.Actor.ActorController;
import UIElements.theSoftwareInstitute.Actor.ActorRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@ScenarioScope
public class ShowActorCostarsStepDef {

    @Autowired
    ActorRepository actorRepo;

    @Autowired
    ActorController actorController;

    Integer actorId;
    Collection<Actor> chosenCostars;

    @Given("an actor exists with the id {int}")
    public void an_actor_exists_with_the_id(Integer id) {
        this.actorId = id;
    }


    @When("requesting the actor costars")
    public void requestingTheActorCostars() {
        this.chosenCostars = actorController.getActorCostars(this.actorId).getBody();
    }


    @Then("The website will show the {int} {int} {int} {int} {int} of the actor")
    public void theWebsiteWillShowTheCostarActorIdsOfTheActor(Integer id1, Integer id2,Integer id3,Integer id4,Integer id5) {
        Integer[] ids = {id1, id2, id3, id4, id5};

        for (Integer id : ids) {
            boolean found = false;
            for (Actor costar : this.chosenCostars) {
                if (costar.getActorId().equals(id)) {
                    found = true;
                    break;
                }
            }
            Assertions.assertTrue(found);
        }
    }

}
