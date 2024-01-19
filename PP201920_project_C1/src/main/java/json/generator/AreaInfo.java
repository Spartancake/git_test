package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaInfo {
    @JsonSetter("AreaInfo")
    Name name;

    public Name getName() {
        return name;
    }
}
