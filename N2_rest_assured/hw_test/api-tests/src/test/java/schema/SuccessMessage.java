package schema;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class SuccessMessage {

    private String message;

    public SuccessMessage(){

    }

    public SuccessMessage(String message) {
        this.message = message;
    }

    @JsonGetter("message")
    public String getMessage1() {
        return message;
    }

    @JsonSetter("message")
    public void setMessage1(String message) {
        this.message = message;
    }
}
