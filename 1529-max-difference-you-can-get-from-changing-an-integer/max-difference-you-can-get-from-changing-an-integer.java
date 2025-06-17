class Solution {
    public int maxDiff(int num) {
        int c1 = 0;
        int n1 = num;
        while (n1 != 0) {
            c1++;
            n1 /= 10;
        }

        int c = c1;
        int n2 = num;
        int pow = 1;
        for (int i = 1; i < c; i++) pow *= 10;

        int digit = -1;
        for (int p = pow; p > 0; p /= 10) {
            int a = (n2 / p) % 10;
            if (a != 9) {
                digit = a;
                break;
            }
        }

        int max = 0;
        n2 = num;
        for (int p = pow; p > 0; p /= 10) {
            int a = (n2 / p) % 10;
            if (a == digit) a = 9;
            max = max * 10 + a;
        }

        n2 = num;
        int first = n2 / pow;
        int replaceDigit = -1;
        int replaceWith = 1;

        if (first != 1) {
            replaceDigit = first;
            replaceWith = 1;
        } else {
            for (int p = pow / 10; p > 0; p /= 10) {
                int a = (n2 / p) % 10;
                if (a != 0 && a != 1) {
                    replaceDigit = a;
                    replaceWith = 0;
                    break;
                }
            }
        }

        int min = 0;
        for (int p = pow; p > 0; p /= 10) {
            int a = (n2 / p) % 10;
            if (a == replaceDigit) a = replaceWith;
            min = min * 10 + a;
        }

        return max - min;
    }
}
