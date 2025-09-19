class Spreadsheet {
    HashMap<String,Integer> map;
    int rows;
    public Spreadsheet(int rows) {
        this.rows = rows;
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        String s = formula.substring(1);
        String arr[]=s.split("\\+");
        return convert(arr[0])+ convert(arr[1]);
    }
     private int convert(String operand) {
        if (Character.isDigit(operand.charAt(0)))
            return Integer.parseInt(operand);
        return map.getOrDefault(operand, 0);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */