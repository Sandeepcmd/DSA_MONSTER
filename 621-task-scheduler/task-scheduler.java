class Solution {
    public int leastInterval(char[] tasks, int n) {
         int ans = 0;
         int map[] = new int[26];
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
         for(int i=0;i<tasks.length;i++)
         {
            map[tasks[i]-'A']++;
         }
         for(int i=0;i<26;i++)
         {
            if(map[i] > 0)pq.offer(map[i]);
         }
         while(pq.size() > 0)
         {
            List<Integer> list= new ArrayList<>();
            for(int i=1;i<=n+1;i++)
            {
                if(pq.size()>0)
                {
                    int freq = pq.poll();
                    freq--;
                    list.add(freq);
                }
            }
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i)>0)pq.offer(list.get(i));
            }
            if(pq.size() == 0)
            {
              ans += list.size();
            }
            else ans += n+1;
         }
         return ans;
    }
}