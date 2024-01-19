package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizedName {
    @JsonSetter("de")
    String germanName;
    @JsonSetter("en")
    String englishName;
    @JsonSetter("it")
    String italianName;

    public String getEnglishName() {
        return englishName;
    }

    public String getGermanName() {
        return germanName;
    }

    public String getItalianName() {
        return italianName;
    }
}
