// import java.util.*;
public class Main{

    //bitwise operators
    public static void bit() {
        System.out.println(5 & 6);
        System.out.println(5 | 6);
        System.out.println(5 ^ 6);
        System.out.println(5 << 6);
        System.out.println(5 >> 6);
    }

    //odd even
    public static void oddEven(int n) {
        int bit = 1;
        if((n & bit) == 0){
          System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }

    //XOR After Range Multiplication Queries I
    public static void XORQuery(int arr[], int queries[][]) {
     
        for (int j = 0; j < queries.length; j++) {
                int li = queries[j][0];
                int ri = queries[j][1];
                int ki = queries[j][2];
                int vi = queries[j][3];

                while(li<=ri){
                 arr[li] = (int)(((long)arr[li] * vi) % 1000000007);
                 li += ki;
                 }
            }
            
      
         int ans = arr[0];

          for (int i = 1; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }

        System.out.println(ans);
      
    }
    public static void main(String[] args) {
        //bit();
        // oddEven(5);
        // oddEven(2);
        // oddEven(10000);
     
        int arr[]= {1,1,1};
        int nums[][]={{0,2,1,4}};
        XORQuery(arr, nums);

    }
}