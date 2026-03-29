class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // target = numbers[index1] + numbers[index2]
        // numbers[index1] = target - numbers[index2]
        // let's have index1 start at the beginning and index2 at the end
        // in a while loop where index1 < index2, 
        // if target = numbers[index1] + numbers[index2]: return i1, i2
        // if index1 + index2 < target: index1++
        // if index1 + index2 > target: index2--

        int index1 = 0;
        int index2 = numbers.length - 1;

        while (index1 < index2) {
            if (target == numbers[index1] + numbers[index2]) {
                return new int[] {index1 + 1, index2 + 1};
            }

            if (numbers[index1] + numbers[index2] > target) {
                index2--;
            } else {
                index1++;
            }
        }

        return new int[0];

    }
}
