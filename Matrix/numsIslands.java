

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Helper function for BFS traversal
    private void bfs(int row, int col, int[][] visit, char[][] grid) {
        visit[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        // Define movements: up, right, down, left
        int[] rowMovement = {-1, 0, 1, 0};
        int[] colMovement = {0, 1, 0, -1};

        // BFS traversal
        while (!q.isEmpty()) {
            int currentRow = q.peek().first;
            int currentCol = q.peek().second;
            q.remove();

            // Explore all four directions
            for (int direction = 0; direction < 4; direction++) {
                int newRow = currentRow + rowMovement[direction];
                int newCol = currentCol + colMovement[direction];

                // Check if the new position is valid and has '1'
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == '1' && visit[newRow][newCol] == 0) {
                    // Mark as visited and add to the queue for further exploration
                    visit[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    // Main function to count islands
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        int[][] visit = new int[row][column];

        // Iterate through each cell in the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // If the cell contains '1' and has not been visited, start BFS
                if (grid[i][j] == '1' && visit[i][j] == 0) {
                    count++;
                    bfs(i, j, visit, grid);
                }
            }
        }
        // Return the count of islands
        return count;
    }
}