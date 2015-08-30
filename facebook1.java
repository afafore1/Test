import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;


public class facebook1 {
	public static void Deletenum(int [] nums, int thenum){
		int r = nums.length-1;
		for(int l = 0; l < r; l++){
			if(nums[l] == 0){
				nums = ArrayUtils.remove(nums, l);
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		int [] givenArray = new int[] {3,4,45,5,0,3,0,32,4,5,40,23,0,43,0,0,43,2,4};
		int rightPointer = givenArray.length -1;
		for(int leftPointer = 0; leftPointer < rightPointer;leftPointer++){
			if(givenArray[leftPointer] == 0){
				for(int x = leftPointer; x < rightPointer; x++){
					givenArray[x] = givenArray[x] ^ givenArray[x+1];
					givenArray[x+1] = givenArray[x] ^ givenArray[x+1];
					givenArray[x] = givenArray[x] ^ givenArray[x+1];
				}
				rightPointer--;
				leftPointer--;
			}
		}
		for(int i = givenArray.length-1; i > 0; i--){
			if(givenArray[i] == 0){
				int [] tempArray = new int[givenArray.length-1];
				System.arraycopy(givenArray, 0, tempArray, 0, givenArray.length-1);
				givenArray = tempArray;
			}
		}
		long end = System.nanoTime();
		System.out.println(Arrays.toString(givenArray));
		System.out.println("Time taken "+(end-start)+" ns");
		start = System.nanoTime();
		Deletenum(givenArray,0);
		end = System.nanoTime();
		System.out.println("Time taken for Deletenum "+(end-start)+" ns");


	}

}
