package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RegionInfo {

    @JsonSetter("Id")
    String id;
    @JsonSetter("Name")
    LocalizedName localizedName;

    public String getId() {
        return id;
    }

    public LocalizedName getName() {
        return localizedName;
    }

}
