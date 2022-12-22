package UIElements.theSoftwareInstitute.FilmCategory;

import UIElements.theSoftwareInstitute.Category.Category;
import UIElements.theSoftwareInstitute.Film.Film;

import java.io.Serializable;
import java.util.Objects;

public class NewFilmCategoryId implements Serializable {
    private Film film;
    private Category category;

    public NewFilmCategoryId() {}

    public NewFilmCategoryId(Film film, Category category) {
        this.film = film;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewFilmCategoryId that = (NewFilmCategoryId) o;
        return film.equals(that.film) && category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, category);
    }
}
