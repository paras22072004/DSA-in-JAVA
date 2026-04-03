//Max Subarrays
//Brute force
// public class Main{
//     public static void maxsubArray(int num[]){
//         int largest = Integer.MIN_VALUE;
//         for (int i = 0; i < num.length; i++) {
//             for (int j = i+1; j < num.length; j++) {
//                 int sum = 0;
//                for (int k = i; k <= j; k++) {
//                    sum=sum+num[k];
//                    if(sum>largest){
//                     largest = sum;
//                    }
//                }
//             }
//         }
//         System.out.println(largest);
//     }
//  public static void main(String[] args) {
//      int num[]={1,-2,6,-1,3};
//      maxsubArray(num);
//  }
// }
//Prefix sum
// public class Main {
//     public static void prefix(int num[]) {
//         int largest = Integer.MIN_VALUE;
//         int pre[] = new int[num.length];
//         for (int i = 0; i < num.length; i++) {
//             if (i == 0) {
//                 pre[i] = num[i];
//             } else {
//                 pre[i] = num[i] + pre[i - 1];
//             }
//         }
//         for (int i = 0; i < pre.length; i++) {
//             int sum = 0;
//             for (int j = i; j < pre.length; j++) {
//                 sum = i == 0 ? pre[i] : pre[j] - pre[i - 1];
//                 if (sum > largest) {
//                     largest = sum;
//                 }
//             }
//         }
//         System.out.println(largest);
//     }
//     public static void main(String[] args) {
//         int num[] = {1, -2, 6, -1, 3};
//         prefix(num);
//     }
// }

//kadan's
// public class Main {

//     public static void kadan(int num[]) {
//         int sum = 0;
//         int largest = Integer.MIN_VALUE;
//         for (int i = 0; i < num.length; i++) {
//             sum = sum + num[i];
//             if (sum < 0) {
//                 sum = 0;
//             }

//             largest = Math.max(sum, largest);

//         }

//         System.out.println(largest);
//     }

//     public static void main(String[] args) {
//         int num[] = {-2, -3, 4, -1, -2, 1, 5, -3};
//         kadan(num);
//     }
// }

//trapped water
// public class Main {
//     public static void trappedWater(int num[]) {
//         int n = num.length;
//left max boundary
// int left[] = new int[n];
// left[0] = num[0];
// for (int i = 1; i < n; i++) {
//     if (num[i] > left[i - 1]) {
//         left[i] = num[i];
//     } else {
//         left[i] = left[i - 1];
//     }
// }
//right max boundary
// int right[] = new int[n];
// right[n - 1] = num[n - 1];
// for (int i = n - 2; i >= 0; i--) {
//     if (num[i] > right[i + 1]) {
//         right[i] = num[i];
//     } else {
//         right[i] = right[i + 1];
//     }
// }
//loop
// int trappedwater = 0;
// for (int i = 0; i < n; i++) {
//     //waterlevel=min(left,right)
//     int waterlevel = Math.min(left[i], right[i]);
//water trapped = waterlevel-height
//             trappedwater += waterlevel - num[i];
//         }
//         System.out.println(trappedwater);
//     }
//     public static void main(String[] args) {
//         int height[] = {4, 2, 0, 6, 3, 2, 5};
//         trappedWater(height);
//     }
// }




//buy &sell stock
public class Main{

    public static void permutation(int arr[]) {
        int stop = -1;
        int big = -1;

        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i]<arr[i+1]){
                stop = i;
                break;
            }
        }


        if(stop == -1){
            reverse(arr,0);
        }
        else{
            for (int i = arr.length-1; i >= 0; i--) {
                if(arr[i]>arr[stop]){
                   big = i;
                   break;
                }
            }


             int temp = arr[stop];
             arr[stop] = arr[big];
             arr[big] = temp;


            reverse(arr,stop+1);
        }
    } 

     public static void reverse( int arr[],int idx) {
         int en = arr.length-1;
         while(idx<en){
            int temp = arr[idx];
            arr[idx] = arr[en];
            arr[en]= temp;

            idx++;
            en--;
         }
     }
    public static void profit(int num[]){
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < num.length; i++) {
            if(buyPrice<num[i]){
                int profit = num[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else {
                buyPrice = num[i];
            }
            
        }
        System.out.println(maxProfit);
    }
    public static void main(String[] args) {
        //int price[]={7,1,5,3,6,4};
        //profit(price);
        int arr[] = {1,2,3};
        permutation(arr);
       
    }
}