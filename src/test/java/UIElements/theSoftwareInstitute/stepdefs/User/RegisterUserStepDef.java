package UIElements.theSoftwareInstitute.stepdefs.User;

import UIElements.theSoftwareInstitute.User.User;
import UIElements.theSoftwareInstitute.User.UserController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.rmi.ServerException;

@ScenarioScope
public class RegisterUserStepDef {

    @Autowired
    UserController userController;

    User newUser;

    User userOutput;

    @Given("a new user is created with the attributes {string}, {string}, {string}")
    public void aNewUserIsCreatedWithTheAttributes(String password, String firstName, String lastName) {
        this.newUser = new User();

        this.newUser.setPassword(password);
        this.newUser.setFirstName(firstName);
        this.newUser.setLastName(lastName);
    }

    @And("a random username")
    public void aRandomUsername() {
        String username = "cucumber" + System.currentTimeMillis() + Math.round(Math.random() * 100000);
        this.newUser.setUsername(username);
    }


    @When("creating the database user")
    public void creatingTheDatabaseUser() throws ServerException {
        this.userOutput = this.userController.createUser(this.newUser).getBody();
        Assertions.assertNotNull(this.userOutput);
    }


    @Then("the website will return the new user database record")
    public void theWebsiteWillReturnTheNewUserDatabaseRecord() {
        Assertions.assertEquals(this.userOutput.getUsername(), this.newUser.getUsername());
        Assertions.assertEquals(this.userOutput.getPassword(), this.newUser.getPassword());
        Assertions.assertEquals(this.userOutput.getFirstName(), this.newUser.getFirstName());
        Assertions.assertEquals(this.userOutput.getLastName(), this.newUser.getLastName());
    }

}
