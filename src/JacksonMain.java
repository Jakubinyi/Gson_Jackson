import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.List;

/**
 * Created by jakubinyi on 2017.05.10..
 */
public class JacksonMain {

    public static void main(String[] args) throws Exception {
        ObjectMapper om = new ObjectMapper();
        ObjectReader or = om.reader()
                .withoutFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        ObjectWriter ow = om.writer()
                .with(SerializationFeature.INDENT_OUTPUT);

        Message message = deserializeSingle(or, new FileInputStream("single.json"));
        serializeSingle(ow, new FileOutputStream("message-output.json"), message);

        List<Message> messages = deserializeMultiple(or, new FileInputStream("multiple.json"));
        serializeMultiple(ow, new FileOutputStream("messages-output.json"), messages);
    }


    private static Message deserializeSingle(ObjectReader or, InputStream is) throws IOException {
        System.out.println("Write a single message as a JSON object:");
        Message message = or.forType(Message.class).readValue(is);
        System.out.format("The message: %s%n", message);
        return message;
    }

    private static void serializeSingle(ObjectWriter ow, OutputStream out, Message message) throws IOException {
        ow.writeValue(out, message);
    }

    private static List<Message> deserializeMultiple(ObjectReader or, InputStream is) throws IOException {
        System.out.println("Write multiple messages as a JSON array:");
        List<Message> messages = or.forType(new TypeReference<List<Message>>() {
        }).readValue(is);
        System.out.format("The messages: %s%n", messages);
        return messages;
    }

    private static void serializeMultiple(ObjectWriter ow, OutputStream out, List<Message> messages) throws IOException {
        ow.writeValue(out, messages);
    }
}
