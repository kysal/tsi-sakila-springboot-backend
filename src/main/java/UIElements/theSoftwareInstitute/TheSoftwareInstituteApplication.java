package UIElements.theSoftwareInstitute;

import UIElements.theSoftwareInstitute.Actor.*;
import UIElements.theSoftwareInstitute.Address.*;
import UIElements.theSoftwareInstitute.Category.*;
import UIElements.theSoftwareInstitute.Film.*;
import UIElements.theSoftwareInstitute.FilmCategory.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerException;


@RestController
@RequestMapping("/home")
@CrossOrigin
@SpringBootApplication
@ComponentScan(basePackageClasses = {
		FilmController.class,
		ActorController.class,
		CategoryController.class,
		AddressRepository.class
})
public class TheSoftwareInstituteApplication {

	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private FilmCategoryRepository filmCategoryRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private AddressRepository addressRepo;

	public TheSoftwareInstituteApplication() {}

	public static void main(String[] args) {
		SpringApplication.run(TheSoftwareInstituteApplication.class, args);
	}
}
