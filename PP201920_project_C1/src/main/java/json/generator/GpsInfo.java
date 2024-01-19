package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GpsInfo {
    @JsonSetter("Gpstype")
    String gpstype;
    @JsonSetter("Altitude")
    float altitude;
    @JsonSetter("Latitude")
    float latitude;
    @JsonSetter("Longitude")
    float longitude;

    public String getGpstype() {
        return gpstype;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getAltitude() {
        return altitude;
    }
}





