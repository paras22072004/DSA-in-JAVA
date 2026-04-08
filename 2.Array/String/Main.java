public class Main{

    //Print string 
    public static void print(String name) {
        for(int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            
        }
    }

    // Palndrome
    public static boolean  Palidrome(String name) {
        int n = name.length();
        for (int i = 0; i < name.length()/2; i++) {
            if(name.charAt(i)!=name.charAt(n-1-i)){
                return false;
            }    
        }
         return true;
    }

    //north east south west
    public static void shortestPath(String dir){
        int x = 0;
        int y = 0;
        for (int i = 0; i < dir.length(); i++) {
            char disha = dir.charAt(i);
            if(disha=='N'){
               y++;
            }
            else if(disha=='S'){
                y--;
            }
            else if(dir.charAt(i)=='E'){
                x++;
            } else{
                x--;
            }
        }
        int x2 = x*x;
        int y2 = y*y;
        System.out.println(Math.sqrt(x2+y2));
    }


    // Substring 
    public static void subString(String str , int st, int end){
        String str2 = "";
        for (int i = st; i < end; i++) {
            str2 += str.charAt(i);
        }
        System.out.println(str2);
    }

    //StringBuilder 
    public static void builder() {
        StringBuilder str = new StringBuilder("");
        for (char i = 'a'; i <= 'z'; i++) {
            str.append(i);
        }
        System.out.println(str+" "+str.length());
    }

    //First letter UpperCase
    public  static void UpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

         for (int i = 1; i < str.length(); i++) {
             if(str.charAt(i)==' ' && i<str.length()-1 ){
               sb.append(str.charAt(i));
               i++;
               sb.append(Character.toUpperCase(str.charAt(i)));
            } else{
                sb.append(str.charAt(i));
            }
      }

      System.out.println(sb.toString());
    }


    //compression
    public static void compression(String str){
        StringBuilder sb = new StringBuilder("");
    
        for (int i = 0; i < str.length(); i++) {
            Integer count=1; 
            while(i<str.length()-1 &&str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
            
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        //String name = "paras";
        //print(name);
        //System.out.print(Palidrome(name));
        //String dir= "WNEENESENNN"; 
        //shortestPath(dir);
        //String str = "HelloWorld";
        //System.out.println(str.substring(0, 5));
        //subString(str, 0, 5);
        //builder();
        //String str = "hi i am paras";
        //UpperCase(str);
        // String str = "aaabbcccdd";
        // compression(str);

      String moves = "UD";
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {
            int dir = moves.charAt(i);
            if(dir == 'L'){
                x++;
            }else if(dir == 'R'){
                x--;
            }else if(dir == 'U'){
                y++;
            }
            else{
                y--;
            }
        }
        
        
    
       }
}