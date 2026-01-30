class Solution {
    public int[][] merge(int[][] arr) {
        ArrayList<int []> list = new ArrayList<>();
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int n = arr.length;
        int x = arr[0][0];
        int y = arr[0][1];
        for(int i=1;i<n;i++){
             if(arr[i][0] <=  y){
                y = Math.max(y,arr[i][1]);
             }
             else{
                list.add(new int[]{x,y});
                 x = arr[i][0];
                 y = arr[i][1];
             }
             
        }
        list.add(new int[]{x,y});
        return list.toArray(new int[list.size()][]);

    }
}