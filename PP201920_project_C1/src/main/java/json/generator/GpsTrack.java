package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GpsTrack {
    @JsonSetter("Id")
    String id;
    @JsonSetter("Type")
    String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}


