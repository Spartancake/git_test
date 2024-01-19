package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    @JsonSetter("Name")
    LocalizedName localizedName;

    public LocalizedName getLocalizedName() {
        return localizedName;
    }
}
