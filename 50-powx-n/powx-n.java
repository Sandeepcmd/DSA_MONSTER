class Solution {
    public double myPow(double x, int n) {
        if(n > 0)return pow(x,n);
        return pow(1/x,-n);
    }
    public double pow(double x,int n)
    {
        if(n == 0)return 1;
        if(n%2 == 0)return pow(x*x,n/2);
        return x*pow(x*x,n/2);
    }
}