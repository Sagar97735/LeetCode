class Spreadsheet {
     int [][] arr;
    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char c = cell.charAt(0);
        int col = (int)(c)-'A';
        String str = cell.substring(1);
        int row = Integer.valueOf(str);
        arr[row-1][col] = value;
    }
    
    public void resetCell(String cell) {
        char c = cell.charAt(0);
        int col = (int)(c)-'A';
        String str = cell.substring(1);
        int row = Integer.valueOf(str);
        arr[row-1][col] = 0;
    }
    
    public int getValue(String formula) {

        String s = formula.substring(1);
        String ar[] = s.split("\\+"); int sum = 0;
        for(String term: ar){
            if(Character.isAlphabetic(term.charAt(0))){
                char c = term.charAt(0);
                int col = (int)(c)-'A';
                String str = term.substring(1);
                int row = Integer.valueOf(str);
                sum += arr[row-1][col];
            } else {
                sum += Integer.parseInt(term);
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */