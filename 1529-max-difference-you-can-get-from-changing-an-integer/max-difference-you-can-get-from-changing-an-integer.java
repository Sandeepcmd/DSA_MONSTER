class Solution {
    public int maxDiff(int num) {
        int c1 = 0;
        int n1 = num;
        while (n1 != 0) {
            c1++;
            n1 /= 10;
        }

        int digit = -1;
        for (int pos = c1; pos > 0; pos--) {
            int d = (int) Math.pow(10, pos - 1);
            int a = (num / d) % 10;
            if (a != 9) {
                digit = a;
                break;
            }
        }

        int max = 0;
        int n2 = num;
        for (int pos = c1; pos > 0; pos--) {
            int d = (int) Math.pow(10, pos - 1);
            int a = n2 / d;
            n2 %= d;
            if (a == digit) a = 9;
            max = max * 10 + a;
        }

        int min = minimum(c1, num);
        return max - min;
    }

    private int minimum(int c, int num) {
        int div = (int) Math.pow(10, c - 1);
        int first = num / div;

        int changeDigit;
        int changeTo;
        if (first != 1) {
            changeDigit = first;
            changeTo = 1;
        } else {
            changeDigit = -1;
            changeTo = 0;
            for (int pos = c - 1; pos > 0 && changeDigit == -1; pos--) {
                int d = (int) Math.pow(10, pos - 1);
                int a = (num / d) % 10;
                if (a != 0 && a != 1) changeDigit = a;
            }
        }

        int n2 = num;
        int min = 0;
        for (int pos = c; pos > 0; pos--) {
            int d = (int) Math.pow(10, pos - 1);
            int a = n2 / d;
            n2 %= d;
            if (a == changeDigit) a = changeTo;
            min = min * 10 + a;
        }
        return min;
    }
}
