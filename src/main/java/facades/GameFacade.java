package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.*;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class GameFacade {

    private static GameFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private GameFacade() {
    }

//test
    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static GameFacade getGameFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GameFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public String fetchData(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json"); // Add this line
        try {
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();

            }
        } catch (Exception e) {
            System.out.println("Error in fetchData");
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    public PersonDTO create(PersonDTO pdto){
        Agify agify = new Agify(pdto.getAge(),pdto.getCount());
        Genderize genderize = new Genderize(pdto.getGender(),pdto.getProbability());
        Person person = new Person(pdto.getName(),agify,genderize);
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        AgifyDTO agifyDTO = new AgifyDTO(agify.getAge(),agify.getCount());
        GenderizeDTO genderizeDTO = new GenderizeDTO(genderize.getGender(),genderize.getProbability());
        PersonDTO personDTO = new PersonDTO(person.getName(),agifyDTO,genderizeDTO);
        return personDTO;
    }


    //little comment
    public AgifyDTO createAgifyDTo(String input) {
        return GSON.fromJson(input, AgifyDTO.class);
    }

    public GenderizeDTO createGenderizeDTO(String input) {
        return GSON.fromJson(input, GenderizeDTO.class);
    }

}
