package UIElements.theSoftwareInstitute.Category;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer categoryId;

    @Column(name="name")
    String name;

    Category() {}

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
