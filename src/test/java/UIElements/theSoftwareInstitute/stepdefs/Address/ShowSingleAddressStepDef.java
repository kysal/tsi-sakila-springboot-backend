package UIElements.theSoftwareInstitute.stepdefs.Address;

import UIElements.theSoftwareInstitute.Address.Address;
import UIElements.theSoftwareInstitute.Address.AddressRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope
public class ShowSingleAddressStepDef {

    @Autowired
    AddressRepository addressRepo;

    Integer addressId;

    Address chosenAddress;

    @Given("an address exists with id {int}")
    public void an_address_exists_with_id(Integer id) {
        this.addressId = id;
    }


    @When("requesting address details")
    public void requestingAddressDetails() {
        this.chosenAddress = this.addressRepo.findById(this.addressId).orElseThrow(() -> new ResourceAccessException("Film ID doesn't exist"));
        Assertions.assertNotEquals(null, this.chosenAddress, "Film could not be retrieved");
    }

    @Then("the website will show {string}, {string}, {string}, {int}, {string} and {string} of the address")
    public void theWebsiteWillShowCityIdAndOfTheAddress(String address, String address2, String district, Integer cityId, String postalCode, String phone) {
        Address expectedAddress = new Address();
        expectedAddress.setAddressId(this.addressId);
        expectedAddress.setAddress(address);
        expectedAddress.setAddress2(address2);
        expectedAddress.setDistrict(district);
        expectedAddress.setCityId(cityId);
        expectedAddress.setPostalCode(postalCode);
        expectedAddress.setPhone(phone);

        Assertions.assertEquals(expectedAddress.getAddressId(), this.chosenAddress.getAddressId());
        Assertions.assertEquals(expectedAddress.getAddress(), this.chosenAddress.getAddress());
        Assertions.assertEquals(expectedAddress.getAddress2(), this.chosenAddress.getAddress2());
        Assertions.assertEquals(expectedAddress.getDistrict(), this.chosenAddress.getDistrict());
        Assertions.assertEquals(expectedAddress.getCityId(), this.chosenAddress.getCityId());
        Assertions.assertEquals(expectedAddress.getPostalCode(), this.chosenAddress.getPostalCode());
        byte[] location = this.chosenAddress.getLocation();
        Assertions.assertEquals(expectedAddress.getPhone(), this.chosenAddress.getPhone());
    }
}
