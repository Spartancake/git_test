package json.generator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.UnsupportedEncodingException;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ImportantActivityInfo {
    String id;
    String name;
    String description;
    List<String> types;
    boolean hasGPSTrack;
    String region;

    public ImportantActivityInfo() {
    }

    public ImportantActivityInfo(String id, String name, String description, List<String> types, boolean hasGPSTrack, String region) throws UnsupportedEncodingException {
        this.id = id;
        this.name = name;
        this.description = description;
        //TODO types should be another field of type List
        this.types = types;
        this.hasGPSTrack = hasGPSTrack;
        //TODO implement region
        this.region = region;
    }

    @Override
    public String toString() {
        return "ImportantActivityInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", types=" + types +
                ", hasGPSTrack=" + hasGPSTrack +
                ", region='" + region + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
}
