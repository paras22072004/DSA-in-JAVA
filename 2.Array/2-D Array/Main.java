
public class Main {

    //largeest number
    public static void largest(int num[][]) {
        int largest = Integer.MIN_VALUE;
        int n = num.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < num[0].length; j++) {
                if (num[i][j] > largest) {
                    largest = num[i][j];
                }
            }
        }
        System.out.println(largest);
    }


    //Spiral matrix
    public static void SpiralMatrix(int num[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = num.length - 1;
        int endcol = num.length - 1;

        while (startrow <= endrow && startcol <= endcol) {
            //top
            for (int i = startcol; i <= endcol; i++) {
                System.out.print(num[startrow][i] + " ");
            }

            //right
            for (int i = startrow + 1; i <= endrow; i++) {
                System.out.print(num[i][endcol] + " ");
            }

            //bottom
            for (int i = endcol - 1; i >= startcol; i--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(num[endrow][i] + " ");
            }

            //left
            for (int i = endrow - 1; i > startrow; i--) {
                if (startcol == endcol) {
                    break;
                }
                System.out.print(num[i][startcol] + " ");
            }

            startcol++;
            startrow++;
            endcol--;
            endrow--;
        }

    }
    
    //Diagonal sum
    public  static void DiagonalSum(int num[][]){
        int sum = 0;
    //   for (int i = 0; i < num.length; i++) {
    //       for (int j = 0; j < num[0].length; j++) {
    //           if(i==j || i+j==(num.length-1)){
    //           sum = sum+num[i][j];
    //           }
              
    //       }
          
    //   }

    for (int i = 0; i < num.length; i++) {
        sum = sum+num[i][i];
        if(i != num.length-1-i){
           sum = sum + num[i][num.length-1-i];
        }
        
            }
      System.out.println(sum);
    }
    

    //staircase search
    public static void stair(int arr[][],int key) {
        int row = 0;
        int col = arr[0].length-1;

        while(row < arr.length && col>=0){
            if(arr[row][col] == key){
                System.out.println("i"+row+" "+"j"+col);
                return;
            }
            else if(key < arr[row][col]){
                col--;
            }else{
                row++;
            }
        }
    } 


    public static void main(String[] args) {
        int num[][] = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};
        
        //largest(num);
        //SpiralMatrix(num);
        //DiagonalSum(num);
        stair(num, 10);
    }
}
