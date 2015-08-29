import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;


public class facebook1 {
	public static void Deletenum(int [] nums, int thenum){
		int r = nums.length-1;
		for(int l = 0; l < r; l++){
			if(nums[l] == 0){
				nums = ArrayUtils.remove(nums, l);
			}else if(nums[r] == 0){
				nums = ArrayUtils.remove(nums, r);
			}else{
				r--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void delNums(int [] nums, int thenum){
		int r = nums.length -1;
		int count = 1;
		for(int l = 0; l < r; l++){
			if(nums[l] == 0){
				for(int x = l; x < r; x++){
					nums[x] = nums[x] ^ nums[x+1];
					nums[x+1] = nums[x] ^ nums[x+1];
					nums[x] = nums[x] ^ nums[x+1];
				}
				r--;
				l--;
			}else{
				count++;
			}
		}
		//nums = Arrays.copyOfRange(nums, 0, count);  this could be used too
		nums = Arrays.copyOf(nums, count);
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		
		int [] givenArray = new int[] {3,4,45,5,0,3,0,32,4,5,40,23,0,43,0,0,43,2,4};
		long start = System.nanoTime();
		Deletenum(givenArray,0);
		long end = System.nanoTime();
		System.out.println("Time taken for Deletenum "+(end-start)+" ns\n");
		
		start = System.nanoTime();
		delNums(givenArray,0);
		end = System.nanoTime();
		System.out.println("Time taken for delNums is "+(end-start)+" ns\n");
		start = System.nanoTime();
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
		end = System.nanoTime();
		System.out.println(Arrays.toString(givenArray));
		System.out.println("Time taken for shifting and copying array back is "+(end-start)+" ns\n");
	


	}

}
