class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            } 

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
        
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                // check for result = 0, > 0, and < 0
                if (total == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

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
