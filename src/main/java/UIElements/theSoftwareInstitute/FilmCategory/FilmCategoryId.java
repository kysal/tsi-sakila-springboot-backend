package UIElements.theSoftwareInstitute.FilmCategory;

import java.io.Serializable;

public class FilmCategoryId implements Serializable {
    private int filmId;
    private int categoryId;

    public FilmCategoryId() {}

    public FilmCategoryId(int filmId, int categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
}
