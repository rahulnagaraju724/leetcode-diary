class Solution {
    public boolean isValidSudoku(char[][] board) {
        //36. Valid Sudoku
        // Check rows
        for (int i = 0; i < 9; i++) {
            if (!isValidSet(board[i])) {
                return false;
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            char[] column = new char[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }
            if (!isValidSet(column)) {
                return false;
            }
        }

        // Check sub-boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char[] subBox = new char[9];
                int index = 0;
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        subBox[index++] = board[row][col];
                    }
                }
                if (!isValidSet(subBox)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidSet(char[] set) {
        HashSet<Character> seen = new HashSet<>();
        for (char digit : set) {
            if (digit != '.') {
                if (!seen.add(digit)) {
                    return false; // Duplicate found
                }
            }
        }
        return true;
    }
}
