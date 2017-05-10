import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    private Integer id;
    private String text;

    public Message() {}

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("Message{id=%s, text=%s}", id, text);
    }
}
