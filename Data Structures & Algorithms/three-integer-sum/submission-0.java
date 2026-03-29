class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // if we loop through the array, we can use two=pointers
        // so that we know the position of three indicies of the array
        // start one pointer at the beginning (left), another at the end (right)
        // run throuhg a while loop, where left < right
        // if result of the 3 indices > 0, if left < right, right--; otherwise left++;
        // if result < 0, if left < right, left++; otherwise right--;
        // if result = 0, add to list of integers
        // must also make sure left or right != current_index
        // if left or right == current_index, we can move the pointer before any calculations
        // we also need to check for duplicate triplets --> how?
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int total = nums[i] + nums[left] + nums[right];
                // check for result = 0, > 0, and < 0
                if (total == 0) {
                    if (!checkDuplicate(list, Arrays.asList(nums[i], nums[left], nums[right]))) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }

                    left++;
                    right--;

                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }

    private boolean checkDuplicate(List<List<Integer>> list, List l2) {
        Collections.sort(l2);
        for (List l1: list) {
            Collections.sort(l1);
            if (l1.equals(l2)) {
                return true;
            }
        }

        return false;
    }
}
