package UIElements.theSoftwareInstitute.FilmCategory;

import java.io.Serializable;

public class FilmCategoryId implements Serializable {
    private Integer filmId;
    private Integer categoryId;

    public FilmCategoryId() {}

    public FilmCategoryId(Integer filmId, Integer categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
}
