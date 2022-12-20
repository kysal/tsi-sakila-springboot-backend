package UIElements.theSoftwareInstitute;

import UIElements.theSoftwareInstitute.Actor.ActorController;
import UIElements.theSoftwareInstitute.Actor.ActorRepository;
import UIElements.theSoftwareInstitute.Address.AddressController;
import UIElements.theSoftwareInstitute.Address.AddressRepository;
import UIElements.theSoftwareInstitute.Category.CategoryController;
import UIElements.theSoftwareInstitute.Category.CategoryRepository;
import UIElements.theSoftwareInstitute.Film.FilmController;
import UIElements.theSoftwareInstitute.Film.FilmRepository;
import UIElements.theSoftwareInstitute.FilmCategory.FilmCategoryRepository;
import UIElements.theSoftwareInstitute.FilmScore.FilmScoreController;
import UIElements.theSoftwareInstitute.User.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home")
@CrossOrigin
@SpringBootApplication
@ComponentScan(basePackageClasses = {
		ActorController.class,
		AddressController.class,
		CategoryController.class,
		FilmController.class,
		FilmScoreController.class,
		UserController.class,
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
