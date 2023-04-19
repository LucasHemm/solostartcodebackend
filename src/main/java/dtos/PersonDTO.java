package dtos;

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
