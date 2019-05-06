package au.com.mongodb.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class ResponseMessage implements Serializable {

    private int httpCode;
    private String message;

    public ResponseMessage() {
        super();
    }

    public ResponseMessage(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String toJSON() {
        final ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException ioe) {
            json = null;
        }
        return json;
    }
}
