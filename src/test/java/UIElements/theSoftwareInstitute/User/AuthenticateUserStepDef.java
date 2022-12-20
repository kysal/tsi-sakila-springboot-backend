package UIElements.theSoftwareInstitute.User;

import UIElements.theSoftwareInstitute.User.User;
import UIElements.theSoftwareInstitute.User.UserController;
import UIElements.theSoftwareInstitute.User.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.ServerException;

@ScenarioScope
public class AuthenticateUserStepDef {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserController userController;
    User loginDetails;

    User chosenUser;


    @Given("a user exists with {string} and {string}")
    public void a_user_exists_with_username_and_password(String username, String password) {
        this.loginDetails = new User();
        this.loginDetails.setUsername(username);
        this.loginDetails.setPassword(password);
    }


    @When("authenticating a user password")
    public void authenticatingAUserPassword() throws ServerException {
        this.chosenUser = this.userController.authenticate(this.loginDetails).getBody();
        Assertions.assertNotNull(this.chosenUser, "User could not be found");
    }


    @Then("the website will show {string} and {string} of user")
    public void theWebsiteWillShowAndOfUser(String firstName, String lastName) {
        Assertions.assertEquals(this.chosenUser.getUsername(), this.loginDetails.getUsername(), "Login username and received username does not match");
        Assertions.assertEquals(this.chosenUser.getFirstName(), firstName, "First name does not match");
        Assertions.assertEquals(this.chosenUser.getLastName(), lastName, "Last name does not match");
    }
}
