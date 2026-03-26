
import java.util.*;

public class Main {

    //pascal triangle
    public static void generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                // first or last element
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // sum of above two
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }
        System.out.println(triangle);

    }

    //3 sum
    public static void threeSum(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> sumList = new ArrayList<>();
                    sumList.add(nums[i]);
                    sumList.add(nums[left]);
                    sumList.add(nums[right]);
                    ans.add(sumList);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }

            }

        }

        System.out.println(ans);

    }

    //4 sum
    public static void fourSum(int nums[], int target) {
        Arrays.sort(nums);
        List<List<Integer>> Ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = nums[i] + nums[left] + nums[right] + nums[j];

                

                     if (sum == target ) {
                        List<Integer> sumList1 = new ArrayList<>();
                        sumList1.add(nums[i]);
                        sumList1.add(nums[j]);
                        sumList1.add(nums[left]);
                        sumList1.add(nums[right]);

                        Ans.add(sumList1);

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                }

            }
        }

        System.out.println(Ans);

    }

    public static void main(String[] args) {
        int num[] = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;

        //threeSum(num);
        //generate(num); 
        fourSum(num,target);
    }
}
