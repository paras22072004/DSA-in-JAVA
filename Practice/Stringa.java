
import java.util.*;

// public class Stringa {

//     //palidrome
//     public static boolean palid(String name) {
//         for (int i = 0; i < name.length() / 2; i++) {
//             if (name.charAt(i) != name.charAt(name.length() - 1 - i)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     //uppercase
//     public static void uppercase(String name) {
//         StringBuilder sb = new StringBuilder("");
//         char ch = name.charAt(0);
//         sb.append(Character.toUpperCase(ch));

//         for (int i = 1; i < name.length(); i++) {
//             if (name.charAt(i) == ' ' && i < name.length() - 1) {
//                 sb.append(name.charAt(i));
//                 i++;
//                 sb.append(Character.toUpperCase(name.charAt(i)));
//             } else {
//                 sb.append(name.charAt(i));
//             }
//         }

//         System.out.println(sb.toString());

//     }

//     // remove parenthesis
//     public static void para(String str) {
//         Queue<Character> q = new LinkedList<>();
//         StringBuilder sb = new StringBuilder("");

//         q.add(str.charAt(0));

//         for (int i = 1; i < str.length(); i++) {
//             if (q.peek() == str.charAt(i)) {
//                 q.remove();
//                 q.add(str.charAt(i));
//             } else {
//                 q.add(str.charAt(i));
//             }
//         }

//     }

//     public static int robotSim(int[] commands, int[][] obstacles) {

//         Set<String> set = new HashSet<>();
//         for (int[] o : obstacles) {
//             set.add(o[0] + "#" + o[1]);
//         }

//         int[][] dir = {
//             {0, 1},
//             {1, 0},
//             {0, -1},
//             {-1, 0}
//         };

//         int x = 0, y = 0;
//         int d = 0;
//         int max = 0;

//         for (int cmd : commands) {

//             if (cmd == -1) {

//                 d = (d + 1) % 4;
//             } else if (cmd == -2) {

//                 d = (d + 3) % 4;
//             } else {

//                 for (int i = 0; i < cmd; i++) {

//                     int nx = x + dir[d][0];
//                     int ny = y + dir[d][1];

//                     if (set.contains(nx + "#" + ny)) {
//                         break;
//                     }

//                     x = nx;
//                     y = ny;

//                     max = Math.max(max, x * x + y * y);
//                 }
//             }
//         }

//         return max;
//     }
    

   
//     public static void main(String[] args) {
//         String name = "(()())(())";
//         //uppercase(name);
//         para(name);
//     }
// }
public class Stringa {

static class Robot {

    int x = 0, y = 0;
    int dir = 0; 
    
    int width, height;
    
    String[] dirs = {"East", "North", "West", "South"};
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    // ✅ constructor
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void step(int num) {
        int cycle = 2 * (width + height) - 4;
        num = num % cycle;
        
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3;
            }
            return;
        }
        
        while (num-- > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir]; 
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dirs[dir];
    }
}

    public static void main(String[] args) {
        Robot r = new Robot(6, 3);
        
        r.step(2);
        r.step(2);
        System.out.println(Arrays.toString(r.getPos())); // [4,0]
        System.out.println(r.getDir()); // East
        
        r.step(2);
        r.step(1);
        r.step(4);
        System.out.println(Arrays.toString(r.getPos())); // [1,2]
        System.out.println(r.getDir()); // West
    }
}