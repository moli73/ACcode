import java.util.*;

public class NextLargerNumber {
	/**
	 * http://www.1point3acres.com/bbs/thread-301466-1-1.html
	 * @param nums
	 * @return
	 */
	public int[] nextLargerNumber(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] res = new int[n];

		for(int i = 0; i < n; i++) {
			int num = nums[i];
			while(!stack.empty() && num > nums[stack.peek()]) {
				int last = stack.pop();
				res[last] = i - last;
			}
			stack.push(i);
		}

		while(!stack.empty()) {
			int index= stack.pop();
			res[index] = -1;
		}

		return res;
	}

	public static void main(String[] args) {
		NextLargerNumber obj = new NextLargerNumber();

//		int[] nums = {69,73,68,81,82};
		int[] nums = {5,3,1,6,7,9,5,3,4,6,2};

		int[] res = obj.nextLargerNumber(nums);
		System.out.println(Arrays.toString(res));
	}
}
