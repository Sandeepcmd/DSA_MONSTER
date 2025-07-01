class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int in[]=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=prerequisites.length;
      
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(in[i]==0)
            {
                que.add(i);
            }
        }
         int course=0;
        while(que.size()>0)
        {
            int curr=que.remove();
           course++;
            for(int i=0;i<adj.get(curr).size();i++)
            {
                int neigh=adj.get(curr).get(i);
                in[neigh]--;
                if(in[neigh]==0)
                {
                    que.offer(neigh);
                }
            }
        }
        if(course==numCourses)
        {
            return true;
        }
        return false;
    }
}