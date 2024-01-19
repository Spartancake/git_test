package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizedDetail {

    @JsonSetter("de")
    Detail detailDe;
    @JsonSetter("en")
    Detail detailEn;
    @JsonSetter("it")
    Detail detailIt;

    public Detail getDe() {
        return detailDe;
    }

    public Detail getEn() {
        return detailEn;
    }

    public Detail getIt() {
        return detailIt;
    }

}
