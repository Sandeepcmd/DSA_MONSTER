class Solution {
     public int result = 0;
    public int finalValueAfterOperations(String[] operations) {
         for(int i = 0; i < operations.length; i++) {
            // call operation function on each operation
            operation(operations[i]);
        }
        // return result
        return result;
    }
      public void operation(String op) {
        // declare swith case:
        switch(op) {
            // declare case --x
            case "--X":
                // apply operation --x on result
                --result;
                // break from switch
                break;
            // declare case ++x
            case "++X":
                // apply operation ++x on result
                ++result;
                // break from switch
                break;
            // declare case x--
            case "X--":
                // apply operation x-- on result
                result--;
                // break from switch
                break;
            // declare case x++
            case "X++":
                // apply operation x++ on result
                result++;
                // break from switch
                break;
        }
    }
}