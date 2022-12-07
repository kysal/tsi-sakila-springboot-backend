package UIElements.theSoftwareInstitute.FilmCategory;

import UIElements.theSoftwareInstitute.Category.Category;
import UIElements.theSoftwareInstitute.Film.Film;

import java.io.Serializable;

public class NewFilmCategoryId implements Serializable {
    private Film film;
    private Category category;

    public NewFilmCategoryId() {}

    public NewFilmCategoryId(Film film, Category category) {
        this.film = film;
        this.category = category;
    }
}
