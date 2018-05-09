import java.util.HashMap;

/**
 * Created by laurenceqi on 18/5/9.
 */
public class P3 {
    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, current = 0;

        for(int i=0; i< ss.length; i++) {
            Integer oldIndex = map.get(ss[i]);
            if( oldIndex == null) {
                current +=1;
            } else {
                if(i - oldIndex > current) {
                    current += 1;
                } else {
                    current = i - oldIndex;
                }
            }
            if(current > max) max = current;
            map.put(ss[i], i);
        }
        return max;
    }
}
