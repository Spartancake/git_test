package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
    @JsonSetter("Gpstype")
    String gpstype;
    @JsonSetter("Altitude")
    float altitude;
    @JsonSetter("Latitude")
    float latitude;
    @JsonSetter("Longitude")
    float longitude;
}
