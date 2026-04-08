import java.util.*;
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
    public static void main(String[] args) {
        //bit();
        // oddEven(5);
        // oddEven(2);
        // oddEven(10000);


       String s = "the sky is blue";
       int j =s.length()-1;
       int i = s.length()-1;
       String[] words = s.split("\\s+");
       for (int k = 0; k < words.length; k++) {
           System.out.println(words[k]);
           
       }

       StringBuilder sb = new StringBuilder();
       while (i >= 0) {

            // jab space mile → word print karo
            if (s.charAt(i) == ' ') {
                int start = i + 1;
                int end = j;

                for (int k = start; k <= end; k++) {
                    sb.append(s.charAt(k));
                }
                sb.append(" ");

                j = i - 1; // next word ka end
            }

            i--;
        }
      
         for (int k = 0; k <= j; k++) {
            sb.append(s.charAt(k));
        }
        
      sb.toString();
        


    }
}