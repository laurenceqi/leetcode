/**
 * Created by laurenceqi on 18/4/23.
 */
public class P477 {
    public int totalHammingDistance(int[] nums) {
        int total=0; int len=nums.length;
        for(int i=0; i< 32; i++ ){
            int sub = 0;
            for(int j=0; j< len; j++){
                sub += nums[j] >> i & 0x01;
            }
            total += sub * (len - sub);
        }
        return total;
    }
}
