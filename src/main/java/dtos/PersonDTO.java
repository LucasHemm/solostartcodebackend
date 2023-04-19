package dtos;

import entities.Genderize;
import entities.Person;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDTO {

    public String name;
    public int age;
    public int count;
    public String gender;
    public double probability;

    public PersonDTO(String name,AgifyDTO agifyDTO,GenderizeDTO genderizeDTO){
        this.name = name;
        this.age = agifyDTO.getAge();
        this.count = agifyDTO.getCount();
        this.gender = genderizeDTO.getGender();
        this.probability = genderizeDTO.getProbability();
    }
    public static List<PersonDTO> getDtos(List<Person> persons) {
        List<PersonDTO> personDTOS = new ArrayList<>();
        for(Person p : persons){
            AgifyDTO agifyDTO = new AgifyDTO(p.getAgify().getAge(), p.getAgify().getCount());
            GenderizeDTO genderizeDTO = new GenderizeDTO(p.getGenderize().getGender(), p.getGenderize().getProbability());
            personDTOS.add(new PersonDTO(p.getName(),agifyDTO,genderizeDTO));
        }
        return personDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
