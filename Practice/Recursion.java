public class Recursion{

    //print dec num
    public static void dec(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }

        System.out.println(n);
        dec(n-1);
    }

    //print acs num
    public static void inc(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        inc(n-1);
        System.out.println(n);
        
    }

    //fact
    public static int fact(int n) {
      if(n==0){
        return 1;
      } 

      return n * fact(n-1);       
    }

     //Natural number
    public static int natural(int n) {
      if(n==1){
        return 1;
      } 

      return n + natural(n-1);       
    }

    //fibonacci
    public static int fibo(int n) {
        if(n==0 || n==1){
            return n;
        }
        
        return fibo(n-1) + fibo(n-2);
    }

    //sorted array
    public static boolean sorted(int arr[],int i) {
        if(i==arr.length-1){
            return true;
        }

        if(arr[i+1] < arr[i]){
            return false;
        }

        
        return sorted(arr, i+1);
    }

    //first occurance
    public static int firstocc(int arr[], int key, int i) {
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }

        return firstocc(arr, key, i+1);
    }


    //last occurance
    public static int lastocc(int arr[], int key, int i) {
        //  if(i < 0){
        //     return -1;
        // }
        // if(arr[i]==key){
        //     return i;
        // }

        // return lastocc(arr, key, i-1);


        if(i==arr.length){
            return -1;
        }

        int found = lastocc(arr, key, i+1);
        if(found == -1 && arr[i]== key){
            return i;
        }

        return found;
    }


    //power
    public static int pow(int x,int n) {
      if(n==0){
        return 1;
      } 
    
      return x * pow(x, n-1);       
    }

    //optimize power
    public static int powOp(int x,int n) {
      if(n==0){
        return 1;
      } 

      int hals = pow(x, n/2) * pow(x, n/2);

      if(n%2 != 0){
        hals = x * hals;
      }
    
      return hals;       
    }
    public static void main(String[] args) {
       
       System.out.println(powOp(2, 10));
    }
}