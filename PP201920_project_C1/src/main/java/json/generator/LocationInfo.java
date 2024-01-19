package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LocationInfo {
    @JsonSetter("RegionInfo")
    RegionInfo regionInfo;

    public RegionInfo getRegionInfo() {
        return regionInfo;
    }
}
