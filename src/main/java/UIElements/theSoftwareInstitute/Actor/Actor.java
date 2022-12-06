package UIElements.theSoftwareInstitute.Actor;

//import javax.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer actorId;

    private
    @Column(name="first_name")
    String firstName;

    private
    @Column(name="last_name")
    String lastName;

//    @Column(name="last_update")


    public Actor() {

    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
