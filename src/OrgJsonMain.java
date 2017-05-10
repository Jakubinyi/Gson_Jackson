import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by jakubinyi on 2017.05.10..
 */
public class OrgJsonMain {

    public static void main(String[] args) throws Exception {
       JSONObject o = new JSONObject();
        o.put("asd", 2);
        o.put("asd", 2);
        o.put("asd2", new JSONArray("[\"a\"]"));
       System.out.println(o.toString());
    }
}
