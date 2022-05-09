package app.model;

import app.database.Connection;
import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance;

    static {
        try {
            instance = new Model();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    public Model() throws Exception {
        Connection conn = new Connection();
        model = conn.readFromJson();
//        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }
    public List<User> getUsers(){
        return model;
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}