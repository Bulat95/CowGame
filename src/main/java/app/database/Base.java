package app.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Base {
    Gson gson;
    public List <Person> Users = new ArrayList<>();

    public void start(){
        Base base = new Base();
        base.addToArray("Ivan", "root");
        base.addToArray("Test", "root");
    }
    public List <Person> readFromJson() throws Exception{
        JsonReader reader = new JsonReader(new FileReader("users.json"));
        gson = new Gson();
        Type Person_TYPE = new TypeToken<List<Person>>(){}.getType();
        return gson.fromJson(reader, Person_TYPE);
    }
    void writeToJson(List <Person> users)throws Exception{
        Writer writer = Files.newBufferedWriter(Paths.get("users.json"));
        gson = new Gson();
        gson.toJson(users, writer);
        writer.close();
    }
    public void addToArray(String login, String password){
        Person person = new Person(login, password, 0);
        Users.add(person);
    }

}
