package UIElements.theSoftwareInstitute.FilmCategory;

import UIElements.theSoftwareInstitute.Category.Category;
import UIElements.theSoftwareInstitute.Category.CategoryRepository;
import UIElements.theSoftwareInstitute.Film.Film;
import jakarta.persistence.*;

@Entity
@IdClass(NewFilmCategoryId.class)
@Table(name="film_category")
public class FilmCategory {

//    private
//    @Id
//    @Column(name="film_id")
//    Integer filmId;
//
//    private
//    @Id
//    @Column(name="category_id")
//    Integer categoryId;

    @Id
    @ManyToOne()
    @JoinColumn(name="film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    private Film film;

    @Id
    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private Category category;

    FilmCategory() {}

//    public Integer getFilmId() {
//        return filmId;
//    }
//
//    public void setFilmId(Integer filmId) {
//        this.filmId = filmId;
//    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }

    public Film getFilmId() {
        return film;
    }

    public void setFilmId(Film filmId) {
        this.film = filmId;
    }

    public Category getCategoryId() {
        return category;
    }

    public void setCategoryId(Category categoryId) {
        this.category = categoryId;
    }

}
