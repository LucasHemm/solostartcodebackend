package entities;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "agify_id")
    private Agify agify;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "genderize_id")
    private Genderize genderize;





    public Person() {
    }
    public Person(String name,Agify agify,Genderize genderize) {
        this.name = name;
        this.agify = agify;
        this.genderize = genderize;
    }

    public Genderize getGenderize() {
        return genderize;
    }

    public void setGenderize(Genderize genderize) {
        this.genderize = genderize;
    }


    public Agify getAgify() {
        return agify;
    }

    public void setAgify(Agify agify) {
        this.agify = agify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}