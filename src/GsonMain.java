import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

/**
 * Created by jakubinyi on 2017.05.10..
 */
public class GsonMain {

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        List<Message> messages = gson.fromJson(
                new FileReader("multiple.json"),
               new TypeToken<List<Message>>() {}.getType());
        System.out.println("The messages " + messages);

        String json = gson.toJson(messages);
        FileOutputStream out = new FileOutputStream("gson-out2.json");
        out.write(json.getBytes());
        out.close();
    }
}
