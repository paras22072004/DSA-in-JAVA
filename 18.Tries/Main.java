public class Main{
	static class Node{
		Node children[] = new Node[26];
		boolean eow = false;

        Node() {
			for (int i = 0; i < 10; i++) {
				children[i] = null;
			}
        }
	}
    public static  Node root = new Node();

	public static void insert(String word){
		Node curr = root;
		for (int level = 0; level < word.length() ; level++) {
			int idx = word.charAt(level) - 'a';
			if(curr.children[idx]==null){
               curr.children[idx] = new Node();
			}
              curr = curr.children[idx];
		}
		curr.eow = true;
	}

	public static boolean search(String key){
       Node curr = root;
	   for (int level = 0; level < key.length(); level++) {
		   int idx = key.charAt(level) - 'a';
		   if(curr.children[idx]== null){
			 return false;
		   }
		   curr = curr.children[idx];
	   }
	   return curr.eow == true;
	}

	public static boolean wordbrek(String key){
		if(key.length() == 0){
			return true;
		}
		for (int i = 1; i <= key.length(); i++) {
		   if(search(key.substring(0,i)) && wordbrek(key.substring(i))){
			return true;
		   }
		}
		return false;
	}
	public static void main(String[] args){
		//String words[] = {"the","a","there","their","any","thee"};
		String words[] = { "i","like","sam","sumsung","mobile","ice"};
		for(int idx = 0; idx < words.length; idx++) {
			insert(words[idx]);
		}

		//System.out.println(search("theee"));
        System.out.print(wordbrek("ilikesumsun"));


	}
}