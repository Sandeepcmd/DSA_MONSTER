class Solution {
    public boolean validPalindrome(String s) {

        int start=0,end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return isValid(s,start+1,end) || isValid(s,start,end-1);
            }
            start++;
            end--;
        }

        return true;
    }
    public boolean isValid(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}