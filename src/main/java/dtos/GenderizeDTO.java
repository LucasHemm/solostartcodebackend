package dtos;

public class GenderizeDTO {


    public String gender;
    public double probability;

    public GenderizeDTO(String gender,double probability){
        this.gender = gender;
        this.probability = probability;
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
