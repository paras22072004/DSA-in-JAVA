
import java.util.*;
// // public class Main{
// //     // longest common prefix
// //     public static void longest(String[] ch) {
// //       if(ch == null || ch.length==0 ){
// //         System.out.println("");
// //         return;
// //       }
// //         int c = ch.length;
// //         //mim length  
// //         StringBuilder str = new StringBuilder("");
// //         int length = Integer.MAX_VALUE;
// //         for(int j = 0; j< c;j++){
// //              length = Math.min(length,ch[j].length());
// //         }
// //         //compare character
// //         for (int i = 0; i < length; i++) {
// //         char current = ch[0].charAt(i);
// //         for (int j = 1; j < ch.length; j++) {
// //             if (ch[j].charAt(i) != current) {
// //                 System.out.println(str.toString());
// //                 return;
// //             }
// //         }
// //         str.append(current);
// //     }
// //         System.out.println(str);
// //     }
// //   public static void main(String[] args) {
// //       //String str[]= {"flower","flow"};
// //       String ch[]= {"flower","flow","flight"};
// //       //System.out.println(ch.charAt(3));
// //     //longest("hlo", "yu"); 
// //       //longest(str);
// //       longest(ch);
// //   }
// // }
// // binary tree structure 
// // public class Main{
// //   static class Node{
// //     int data;
// //     Node left;
// //     Node right;
// //     Node(int data){
// //       this.data = data;
// //       this.left = null;
// //       this.right = null;
// //     }
// //   }
// //   static class BinaryTree{
// //     static int idx = -1;
// //     public static Node builtTree(int nodes[]){
// //       idx++;
// //       if( nodes[idx] == -1){
// //          return null;
// //       }
// //       Node newNode = new Node(nodes[idx]);
// //       newNode.left= builtTree(nodes);
// //       newNode.right = builtTree(nodes);
// //       return newNode;
// //     }
// //   }
// //   public static void main(String[] args) {
// //   int nodes[]= {1,2,4,-1,-1, 5, -1, -1, 3, -1, 6, -1, -1};
// //   BinaryTree tree = new BinaryTree();
// //   Node root = tree.builtTree(nodes);
// //   System.out.println(root.data);
// //   }
// // }
// // public class Main{
// //     static class Node{
// //     int data;
// //     Node left;
// //     Node right;
// //      Node(int data){
// //       this.data= data;
// //       left = right = null;
// //     }
// //   }
// //   public static void printTree(Node root, int level){
// //     if(root == null) return;
// //     printTree(root.right, level-1);
// //     for(int i=0;i<level;i++) System.out.print("   ");
// //     System.out.println(root.data);
// //     printTree(root.left, level-1);
// // }
// //   public static void main(String [] args){
// //      Node root = new Node(1);
// //     root.left = new Node(2);
// //     root.right = new Node(3);
// //     root.left.left = new Node(4);
// //     root.left.right = new Node(5);
// //     root.right.left = new Node(6);
// //     root.right.right= new Node(7);
// //     printTree(root,3);
// //   }
// // }
// public class Main{
//     public static int maxSubArray(int[] nums) {
//       int larsum = Integer.MIN_VALUE;
//       if(nums.length == 1){
//         return nums[0];
//        }else {
//        for(int i = 0; i < nums.length; i++){
//          for(int j = i+1 ; j < nums.length ; j++){
//              int sum = 0;
//              for(int k = i; k <= j ; k++){
//                  sum = sum + nums[k];
//                  if( sum > larsum){
//                      larsum = sum;
//                  }
//              }
//          }
//        }  
//        return larsum;
//       } 
//       }
//       //prefix sum
//       public static void prefix(int arr[]){
//         int lar = Integer.MIN_VALUE;
//         int pre[] = new int[arr.length];
//         for(int i=0; i<arr.length ; i++){
//           if(i== 0){
//             pre[i]= arr[i];
//           }
//           else 
//           pre[i] = arr[i] + pre[i-1];
//         }
//  int sum = 0;
//         for(int i = 0 ; i < pre.length ; i++){
//           for(int j=i ; j< pre.length; j++){
//             sum = i==0 ? pre[j] : pre[j] - pre[i-1];
//             if(sum > lar){
//               lar = sum ;
//             }
//           }
//         }
//         System.out.println(lar);
//       }
//       //kadans rule
//       public static void kadan(int num[]){
//         int sum = 0;
//         int larg = Integer.MIN_VALUE;
//         for (int i = 0; i < num.length; i++) {
//             sum = sum+ num[i];
//             if(sum < 0){
//               sum = 0;
//             }   
//             larg = Math.max(larg, sum);
//           }
//           System.out.println(larg);
//       }
//        public static int kmaxSubArray(int[] arr) {
//         int currentSum = arr[0];
//         int maxSum = arr[0];
//         for (int i = 1; i < arr.length; i++) {
//             // ya to naya subarray start karo
//             // ya previous sum me add karo
//             currentSum = Math.max(arr[i], currentSum + arr[i]);
//             // maximum update
//             maxSum = Math.max(maxSum, currentSum);
//         }
//         return maxSum;
//     }
//       //duplicate num in array
//       public static boolean duplicate(int arr[]){
//         int start = 0 ;
//         int end = arr.length/2;
//          for (int i = start; i < end; i++) {
//              for (int j = end; j < arr.length; j++) {
//                  if(arr[i] == arr[j]){
//                   return true;
//                  }
//              }
//          }
//          return false;
//       }
//   public static void main(String[] args) {
//     int arr[] = {-1};
//     //System.out.println(maxSubArray(arr));
//     //int max = Integer.MIN_VALUE;
//     //System.out.println(max);
//     //prefix(arr);
//     //kadan(arr);
//     System.out.println(kmaxSubArray(arr));  
//   }
// }

public class ArrayPractice {

    // binary 
    public static void binary(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                System.out.println(mid);
                return;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    //reverse array
    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //pairs arrays
    public static void pairs(int num[]) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + num[i] + " " + num[j] + ")" + " ");
            }
            System.out.println("");
        }
    }

    //subarrays
    public static void subarray(int num[]) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(num[k] + " ");
                }
                System.out.print("   ");
            }
            System.out.println("");
        }
    }

    //max sum subarray
    public static void maxsubarray(int num[]) {
        int lar = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {

            for (int j = i + 1; j < num.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += num[k];
                    lar = Math.max(sum, lar);
                }
            }

        }
        System.out.println(lar);
    }

    // max subarray prefix
    public static void prefix(int num[]) {
        int lar = Integer.MIN_VALUE;
        int pre[] = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                pre[i] = num[i];
            } else {
                pre[i] = num[i] + pre[i - 1];
            }
        }

        for (int i = 0; i < pre.length; i++) {
            int sum;
            for (int j = i; j < pre.length; j++) {
                sum = i == 0 ? pre[j] : pre[j] - pre[i - 1];
                lar = Math.max(lar, sum);
            }

        }
        System.out.println(lar);
    }

    //max kadan's rule add sum
    public static void kadan(int num[]) {
        int lar = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < num.length; i++) {
            curr = curr + num[i];
            if (curr < 0) {
                curr = 0;
            }
            lar = Math.max(lar, curr);

        }
        System.out.println(lar);
    }

    //trapping rain water problem
    public static void trapWater(int num[]) {
        int trapwater = 0;
        int n = num.length;
        int left[] = new int[n];
        left[0] = num[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(num[i], left[i - 1]);

        }
        //rigth max
        int right[] = new int[n];
        right[n - 1] = num[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], num[i]);
            //System.out.println(right[i]);
        }
        int waterlevel;
        for (int i = 0; i < num.length; i++) {
            waterlevel = Math.min(left[i], right[i]);

            trapwater += waterlevel - num[i];

        }
        System.out.println(trapwater);
    }

    //majority element
    public static int majority(int num[]) {
        int half = num.length / 2;
        for (int i = 0; i < num.length; i++) {
            int freq = 0;
            for (int j = 0; j < num.length; j++) {
                if (num[i] == num[j]) {
                    freq++;
                }
            }
            if (half < freq) {
                return num[i];
            }
        }
        return -1;
    }

    //buy stock and sell
    public static int buystock(int prices[]) {
        int maxProfit = 0;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            } else {
                maxProfit = prices[i] - minValue;
                maxProfit = Math.max(maxProfit, minValue);
            }
        }
        return maxProfit;
    }

    //palidrome
    public static boolean isPal(int x) {
        int rev = 0;
        int org = x;
        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return org == rev;
    }

    //SORTING
    // bubble sort
    public static void bubblesort(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // optimize bubble sort
    public static void opbubblesort(int nums[]) {
        int n = nums.length;
        int swap = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap++;
                }
                System.out.print(swap + " ");

            }
            System.out.println("");
            if (swap == 0) {
                return;
            }
        }
    }

    //selection sort
    public static void selsort(int num[]) {
        for (int i = 0; i < num.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[minpos]) {
                    minpos = j;
                }
                int temp = num[minpos];
                num[minpos] = num[i];
                num[i] = temp;
            }

        }
    }

    //rotated array
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public static void reverse(int num[], int left, int right) {
        while (left < right) {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotateArr(int arr[], int d) {
        int n = arr.length;
        reverse(arr, 0, n - d - 2);
        reverse(arr, n - d - 1, n - 1);
        reverse(arr, 0, n - 1);
    }

    //2D array
    public static void doublearray() {
        int a[][] = new int[2][2];
        a[0][0] = 5;
        a[1][1] = 15;
        a[0][1] = 25;
        a[1][0] = 35;
        // for(int i = 0; i < a.length; i++) {
        //     for (int j = 0; j < a[0].length; j++) {
        //         System.out.println(a[i][j]); 

        //     }
        // }
    }

    //spiral 
    public static void spiral(int arr[][]) {
        int n = arr.length;
        int strow = 0;
        int enrow = n - 1;
        int stcol = 0;
        int encol = n - 1;
        while (strow <= enrow && stcol <= encol) {
            //top
            for (int i = stcol; i <= encol; i++) {
                System.out.print(arr[strow][i] + " ");
            }

            //right
            for (int i = strow + 1; i <= enrow; i++) {
                System.out.print(arr[i][encol] + " ");
            }

            //bottom
            for (int i = encol - 1; i >= stcol; i--) {
                if (strow == enrow) {
                    break;
                }
                System.out.print(arr[enrow][i] + " ");
            }

            //left
            for (int i = enrow - 1; i > strow; i--) {
                if (stcol == encol) {
                    break;
                }
                System.out.print(arr[i][stcol] + " ");
            }

            stcol++;
            strow++;
            enrow--;
            encol--;
        }
    }

    //missing in 2d array
    public static int[] missing(int grid[][]) {
        int n = grid.length;
        int total = n * n;

        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[2];

        // Find repeated
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(grid[i][j])) {
                    ans[0] = grid[i][j]; // repeated
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        // Find missing
        for (int i = 1; i <= total; i++) {
            if (!set.contains(i)) {
                ans[1] = i;
            }
        }

        return ans;

    }

    //Set Matrix Zeroes
    public static void setZero(int arr[][]) {
        boolean row[] = new boolean[arr.length];
        boolean col[] = new boolean[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (row[i] || col[j]) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "");
            }
            System.out.println("");
        }

        //  for (int j = 0; j < arr[0].length; j++) {
        //         System.out.println(row[j]);
        //     }
    }

    //overlap 
    public static void overlap(int arr[][]) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
             
            int start = arr[i][0];
            int last = arr[i][arr[0].length - 1];
            hm.put(start, 0);
            hm.put(last, 1);
            System.out.println();
            for (int j = start; j <= last; j++) {
                
            }

            //System.out.println(start+" "+last);
        }


        System.out.println(hm);
    }

    public static void main(String[] args) {
        //int nums[][] = {{1,4},{4,5}};
        //int nums[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //overlap(nums);
        int arr[] ={2,3,4,5,11};
        int k = 5;
        int start = 0;
        int end = arr.length - 1;
        
        // Binary Search to find the position where the missing count crosses k
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // Calculate how many numbers are missing before the index 'mid'
            // Expected value at index mid is (mid + 1)
            int missingNumbersTillNow = arr[mid] - (mid + 1);
            
            if (missingNumbersTillNow < k) {
                // Not enough missing numbers yet, look to the Right
                start = mid + 1;
            } else {
                // Too many (or exactly k) missing numbers, look to the Left
                end = mid - 1;
            }
        }
        
        // Derivation:
        // The answer is 'k' more than the number of non-missing elements found so far.
        // At the end of the loop, 'start' is the number of elements in the array smaller than the kth missing number.
        // Formula: Result = k + start
        System.out.println(start);
        //return k + start;
        
       
    }
}
