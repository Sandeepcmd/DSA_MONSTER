class Solution {
    public int leastInterval(char[] tasks, int n) {
        String ans = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int len = tasks.length;
        int map[] = new int[26];
        for(int i=0;i<len;i++)
        {
            map[tasks[i]-'A']++;
        }
        for(int i=0;i<26;i++)
        {
            if(map[i] > 0)pq.offer(map[i]);
        }
       
        while(pq.size() > 0)
        {
             List<Integer> temp = new ArrayList<>();
             for(int i=0;i<n+1;i++)
             {
                if(pq.size() == 0 )ans += "#";
                else{
                   int curr = pq.remove()-1;
                   if(curr != 0){temp.add(curr);}
                   ans += "1";
                }
             }
             for(int ele : temp){
                System.out.println(ele);
                pq.offer(ele);
             }

        }
        int leng = 0;
        for(int i=ans.length()-1;i>=0;i--)
        {
            if(ans.charAt(i) == '#')leng++;
            else{
                break;
            }
        }
        return ans.length()-leng;
    }
}