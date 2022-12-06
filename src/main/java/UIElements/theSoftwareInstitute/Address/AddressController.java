package UIElements.theSoftwareInstitute.Address;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/address")
@RestController
public class AddressController {

    private final AddressRepository repo;

    AddressController(AddressRepository addressRepository) {
        this.repo = addressRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Address> getAddresses() {
        return repo.findAll();
    }


}
