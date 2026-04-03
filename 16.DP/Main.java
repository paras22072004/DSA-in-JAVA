import java.util.*;
import javax.sound.midi.Receiver;
public class Main {

    //fobonacci
    public static int fibo(int n , int f[]) {
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!= 0){
            return f[n];
        }

        f[n]=  fibo(n-1, f) + fibo(n-2, f);

        return f[n];
    }

    //tabulation fibnoacci
    public static int fiboTab(int n) {
        int dp[] = new int[n+1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i]= dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //climbing stairs by recursion
    public static int stairs(int n) {
        if(n==0){
         return 1;
        }

        if(n<0){
            return 0;
        }

        return stairs(n-1)+ stairs(n-2);
    }

     //climbing stairs by memoization
    public static int stairsme(int n, int m[]) {
        if(n==0){
         return 1;
        }

        if(n<0){
            return 0;
        }

        if(m[n]!=-1){
            return m[n];
        }

        m[n]=  stairsme(n-1,m)+ stairsme(n-2,m);

        return m[n];
    }

    //climbing stairs by tabulation
    public static int stairTab(int n) {
        int dp[] = new int[n+1];
        dp[0]= 1;
       
        for(int i=1; i <= n; i++){
            if(i==1){
                dp[i]= dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        //int f[] = new int[n+1];
       // Arrays.fill(f,-1);
        System.out.println(stairTab(n));
    }
}