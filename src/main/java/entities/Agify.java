package entities;

import javax.persistence.*;

@Entity
@Table(name = "agify")
public class Agify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "count")
    private Integer count;

    @OneToOne(mappedBy = "agify", orphanRemoval = true)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Agify() {
    }
    public Agify(int age, int count) {
        this.age = age;
        this.count = count;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}