package json.generator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    @JsonSetter("Id")
    String id;
    @JsonSetter("ODHTags")
    Type[] types;
    @JsonSetter("GpsTrack")
    List<GpsTrack> gpsTrack;
    @JsonSetter("GpsInfo")
    List<GpsInfo> gpsInfo;
    @JsonSetter("GpsPoints")
    GpsPoints gpsPoints;
    @JsonSetter("Detail")
    LocalizedDetail localizedDetail;
    @JsonSetter("LocationInfo")
    LocationInfo locationInfo;


    public boolean hasGpsTrack() {

        return (gpsTrack.size() != 0) || (gpsInfo.size() != 0) || (gpsPoints.getPosition() != null);

    }


    public String getDesc() {
        String desc;
        if (localizedDetail.getEn() != null) {
            desc = (localizedDetail.getEn()).getDescription();
        } else if (localizedDetail.getIt() != null) {
            desc = (localizedDetail.getIt()).getDescription();
        } else {
            desc = (localizedDetail.getDe()).getDescription();
        }


        return FormatUtility.cleanHtmlFormatting(desc);
    }


    public String getName() {
        String name;
        if (localizedDetail.getEn() != null) {
            name = (localizedDetail.getEn()).getName();
        } else if (localizedDetail.getIt() != null) {
            name = (localizedDetail.getIt()).getName();
        } else {
            name = (localizedDetail.getDe()).getName();
        }

        return FormatUtility.cleanHtmlFormatting(name);
    }

    public String getLocalizedName() {
        LocalizedName name = locationInfo.getRegionInfo().getName();
        String region;
        if ((region = name.getEnglishName()) == null) {
            if ((region = name.getItalianName()) == null) {
                region = name.getGermanName();
            }
        }

        return region;
    }

    public ArrayList<String> getTypes() {
        ArrayList<String> typeDesc = new ArrayList<>();

        for (Type type : types) {

            typeDesc.add(type.getId());

        }

        return typeDesc;
    }

    public String getRegionId() {
        String id = locationInfo.getRegionInfo().getId();
        return id;
    }

    @Override
    public String toString() {
        return "JsonFileGenerator.Activity {" +
                "\n id='" + id + '\'' +
                "\n types='" + getTypes() + '\'' +
                "\n hasGPSTrack='" + hasGpsTrack() + '\'' +
                "\n detail= '" + getName() + " " + getDesc() +
                "\n region= '" + getLocalizedName() +
                "\n region Id= '" + getRegionId() + "\n";
    }


}
