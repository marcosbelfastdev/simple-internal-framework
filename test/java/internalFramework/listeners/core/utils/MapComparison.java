package core.utils;

import java.util.HashMap;
import java.util.Map;

public class MapComparison {

    /*
    Compares 2 hashmaps of String key, String value.
     */

    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();

    public MapComparison(Map<String, String> map1, Map<String, String> map2) {
        this.map1.putAll(map1);
        this.map2.putAll(map2);
    }

    /**
     * Returns whether key/value pairs are identical or different sizes (false)
     * Returns true only and if only all key/value pairs exist and are identical in both maps
     * @return
     */
    public boolean areKeyValuePairsIdentical() {
        if (map1.keySet().size() != map2.keySet().size())
            return false;

        for (String key : map1.keySet()) {
            if (!map2.get(key).equals(map1.get(key)))
                return false;
        }

        return true;
    }
}
