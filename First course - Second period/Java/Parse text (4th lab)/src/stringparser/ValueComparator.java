/**
 * Created 02/25/2017 by Vitaliy Vinnichenko (v1.0)
 */

package stringparser;

import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<String> {
    private Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map){
        this.map = map;
    }

    public int compare(String a, String b){
        if(this.map.get(a) >= this.map.get(b)){
            return -1;
        } else {
            return 1;
        }
    }
}
