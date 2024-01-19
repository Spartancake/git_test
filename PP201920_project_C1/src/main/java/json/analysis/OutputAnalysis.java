package json.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OutputAnalysis {

    private Map<String, Integer> activitiesTypes;
    private ArrayList<String> trackedActivityIds;
    private Map<String, Object> regionsWithMostActivities;
    private Map<String, Object> regionsWithLeastActivities;

    public OutputAnalysis(Map<String, Integer> types, ArrayList<String> gps, Map<String, Object> mA, Map<String, Object> mL) {
        this.activitiesTypes = new HashMap<>(types);
        this.trackedActivityIds = new ArrayList<String>(gps);
        this.regionsWithMostActivities = new HashMap<>(mA);
        this.regionsWithLeastActivities = new HashMap<>(mL);

    }

    public ArrayList<String> getTrackedActivityIds() {
        return trackedActivityIds;
    }

    public Map<String, Integer> getActivitiesTypes() {
        return activitiesTypes;
    }

    public Map<String, Object> getregionsWithMostActivities() {
        return regionsWithMostActivities;
    }

    public Map<String, Object> getregionsWithLeastActivities() {
        return regionsWithLeastActivities;
    }
}
