package app.model;

import app.database.Base;
import app.database.Person;
import app.entities.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.Writer;
import org.hibernate.cfg.Configuration;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private static Model instance = new Model();

    private List<User> model;
    Gson gson;

    public static Model getInstance()
    {
        return instance;
    }

    private Model() {
        Configuration configuration = new Configuration().configure();
        

       readUsers();
//        User user1 = new User("Ivan", "123", 0);
//        model.add(user1);
    }

    private void readUsers() {
        model = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("user.json"));
            JSONObject jsonObject = (JSONObject) obj;
            int a = 42;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        model.add(user);
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

}