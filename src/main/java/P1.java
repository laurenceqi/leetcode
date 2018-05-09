import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by laurenceqi on 18/5/8.
 */
public class P1 {
    private HashMap<Integer, Integer> valuemap = new HashMap<Integer, Integer>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            valuemap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            Integer index = valuemap.get(remain);
            if(index != null && index != i) {
                return new int[] {i, valuemap.get(remain)};
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
