package app.database;

import app.entities.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Connection {
    Gson gson = new Gson();
    List <User> answer;

    public List <User> readFromJson() throws Exception{
        JsonReader reader = new JsonReader(new FileReader("D:\\Repositories\\CowGame\\src\\main\\java\\app\\database\\users.json"));
        gson = new Gson();
        Type User_TYPE = new TypeToken<List<User>>(){}.getType();
        return gson.fromJson(reader, User_TYPE);
    }
    public void writeToJson(List <User> array)throws Exception{
        Writer writer = Files.newBufferedWriter(Paths.get("D:\\Repositories\\CowGame\\src\\main\\java\\app\\database\\users.json"));
        gson.toJson(array, writer);
        writer.close();
    }

}
