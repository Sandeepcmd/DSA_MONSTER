class Trie {
    class Node{
        Node children[];
        boolean eow;
        Node()
        {
            children = new Node[26];
            eow = false;
        }
    }
    public Node root;
    public Trie() {
       root = new Node();   
    }
    public void insert(String word) {
        Node curr = root;
        int level = word.length();
        for(int i=0;i<level;i++)
        {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx] == null)
            {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx]; 
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        int level = word.length();
        for(int i=0;i<level;i++)
        {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null)
            {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        int level = word.length();
        for(int i=0;i<level;i++)
        {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null)
            {
                return  false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */