package UIElements.theSoftwareInstitute.FilmCategory;

import jakarta.persistence.*;

@Entity
@IdClass(FilmCategoryId.class)
@Table(name="film_category")
public class FilmCategory {

    private
    @Id
    @Column(name="film_id")
    int filmId;

    private
    @Id
    @Column(name="category_id")
    int categoryId;

    FilmCategory() {}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
