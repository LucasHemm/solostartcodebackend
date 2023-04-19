package entities;

import javax.persistence.*;

@Entity
@Table(name = "genderize")
public class Genderize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "probability")
    private Double probability;

    @OneToOne(mappedBy = "genderize", orphanRemoval = true)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Genderize() {
    }

    public Genderize(String gender, Double probability) {
        this.gender = gender;
        this.probability = probability;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}