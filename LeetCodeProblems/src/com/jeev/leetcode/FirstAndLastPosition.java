package com.jeev.leetcode;

public class FirstAndLastPosition {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 7, 7, 7, 7, 8, 9 };
		int target = 7;
		System.out.println(searchRange(nums, target));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] ans = { -1, -1 };

		// check for first occurence if target first
		ans[0] = search(nums, target, true);
		ans[1] = search(nums, target, false);

		return ans;
	}

	// this method will search a target element
	// if target element found again
	// it will find for the first and last position of element
	public static int search(int[] nums, int target, boolean firstElement) {
		int start = 0;
		int end = nums.length - 1;
		int ans = -1;

		while (start <= end) {
			// find the mid element of the array
			int mid = start + (end - start) / 2;

			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				// if the above both conditions didn't satisfied the it will return
				// mid element
				ans = mid;

				// after finding the target element this condition will check
				// target element of first position and last position of that
				// target element.
				if (firstElement == true) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return ans;
	}
}
