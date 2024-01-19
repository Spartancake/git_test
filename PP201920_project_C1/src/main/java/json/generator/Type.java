package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
    @JsonSetter("Id")
    String id;

    public String getId() {
        return id;
    }
}
