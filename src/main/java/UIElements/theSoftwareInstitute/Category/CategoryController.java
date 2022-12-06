package UIElements.theSoftwareInstitute.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryRepository repo;

    CategoryController(CategoryRepository categoryRepository) {
        this.repo = categoryRepository;
    }


    @GetMapping("")
    public @ResponseBody Iterable<Category> getCategories() {
        return repo.findAll();
    }

}
