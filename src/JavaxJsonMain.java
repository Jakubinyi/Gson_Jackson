import javax.json.Json;
import javax.json.JsonArray;

/**
 * Created by jakubinyi on 2017.05.10..
 */
public class JavaxJsonMain {

    public static void main(String[] args) throws Exception {
       JsonArray arr = Json.createArrayBuilder()
               .add(Json.createObjectBuilder()
                        .add("asd", 2)
                        .add("asd2", true)
                       .add("asdasdasd", "asdasdasd")
                   .build())
               .add("asdas2")
               .add("asdas2")
               .build();
        System.out.println(arr.toString());
    }
}
