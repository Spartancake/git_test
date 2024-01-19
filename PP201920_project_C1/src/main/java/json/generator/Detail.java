package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Detail {

    @JsonSetter("Title")
    String name;
    @JsonSetter("BaseText")
    String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
