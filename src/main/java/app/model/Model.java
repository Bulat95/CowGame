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
    public void checkInitArray(User user) {
        if(model == null){
            model = new ArrayList<>();
            model.add(user);
        }
        else {
            model.add(user);
        }
    }
    public void add(User user) {
        model.add(user);
    }
    public List<User> getUsers(){
        if (model == null) {
            return null;
        }
        return model;
    }
    public List<String> list() {
        if (model == null) {
            return null;
        }
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
    public User actUser;
}