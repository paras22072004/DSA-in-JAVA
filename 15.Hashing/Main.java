
import java.util.*;

// public class Main{
//  public static void main(String[] args) {
//      HashMap <String,Integer> hm = new HashMap<>();
//      hm.put("samosa",5);
//      hm.put("rice",56);
//      hm.put("namkeen",5);
//      hm.put("pari bujiya",56);
//      hm.remove("pari bujiya");
//      hm.put("namkeen",9);
//      hm.keySet();
//      System.out.print(hm.keySet());
//  }
// }
public class Main {

    //Majority element
    public static void majority(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        Set<Integer> keySet = hm.keySet();
        for (Integer key : keySet) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    

    //first lowest frequency element
    public static void firstfreq(int arr[]) {
         HashMap <Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
           if(hm.containsKey(arr[i])){
            hm.put(arr[i], hm.get(arr[i])+1);
           }
           else{
            hm.put(arr[i], 1);
        }
        }

        for (int i = 0; i < arr.length; i++) {
            if(hm.get(arr[i])==1){

                System.out.println(arr[i]);
                break;
            }
            
        }
    }

    //duplicate print
    public static void duplicatePrint(int arr[]){
      HashMap <Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
         hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);   
          
        }
        for(Map.Entry<Integer, Integer> en : hm.entrySet()){
            if(en.getValue()>1){
              System.out.println(en.getKey());
            }
        } 
       
    }

    //itinerary Tickets
    public static String start(HashMap <String, String> tickets) {
        HashMap<String, String> rev = new HashMap<>();

        for(String key : tickets.keySet()){
            rev.put(tickets.get(key), key);
        } 

        for(String keys : tickets.keySet()){
           if(!rev.containsKey(keys)){
            return keys;
           }
        }
        return null;
    }
    public static void tickets() {
        HashMap <String, String> hm = new HashMap<>();
        hm.put("Chennai", "Bengaluru");
        hm.put("Mumbai","Delhi");
        hm.put("Goa","Chennai");
        hm.put("Delhi","Goa");
        
        String start = start(hm);
        System.out.print(start);
        for(String key: hm.keySet()){
            System.out.print("->"+hm.get(start));
            start = hm.get(start);
        }
        System.out.println("");
        
    }


    //longest sequence
     public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],true);
        }

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]-1)){
                hm.put(nums[i],false);
            }
        }

        int max = 0;
        for(Integer key: hm.keySet()){
            if(hm.get(key) == true){
              int curr = key;
              int ans = 0;
               while(hm.containsKey(curr)){
                ans++;
                curr++;
             }
             max = Math.max(max,ans);
            }
        }
        return max;

    }


    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 2, 4,3,3,2,4,2,1,2,9,3,4,5,56,6,7,754,3,10,2,2, 1};
        // HashMap <Integer, Integer> hm = new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //     hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        // }

        //System.out.println(hm.keySet());
         
        //   Set< Integer> k = hm.keySet();
        //  for(Integer keys : k){
        //    System.out.println(keys +" "+ hm.get(keys));
        //  }
        int nums[] = {3,2,3};
        ArrayList <Integer> ar = new ArrayList<>();
        HashMap <Integer,Integer> hm = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        System.out.println(hm);

        for(Integer key: hm.keySet()){
            if(hm.get(key)>n/3){
                ar.add(key);
            }
        }
       System.out.println(ar);
    }
}
