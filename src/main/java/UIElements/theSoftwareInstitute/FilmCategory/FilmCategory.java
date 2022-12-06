package UIElements.theSoftwareInstitute.FilmCategory;

import jakarta.persistence.*;

@Entity
@IdClass(FilmCategoryId.class)
@Table(name="film_category")
public class FilmCategory {

    private
    @Id
    @Column(name="film_id")
    Integer filmId;

    private
    @Id
    @Column(name="category_id")
    Integer categoryId;

    FilmCategory() {}

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
