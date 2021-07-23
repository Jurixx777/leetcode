/**
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
* You may assume all four edges of the grid are all surrounded by water.
* 
* Exemple:
* Input: grid = [
*  ["1","1","1","1","0"],
*  ["1","1","0","1","0"],
*  ["1","1","0","0","0"],
*  ["0","0","0","0","0"]]
*
*/

class Solution {
  //class for to keep coordinates of island parts  
  class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<Pair>(); 
        Pair p; //point if coordinate (i, j)
       
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0' || visited[i][j] == true) continue;
                queue.add(new Pair(i,j));
                visited[i][j] = true;
                
                while(queue.size() != 0) {
                    p = queue.poll();
                    if(p.i - 1 >= 0 && grid[p.i - 1][p.j] == '1' && visited[p.i - 1][p.j] == false) {
                        queue.add(new Pair(p.i - 1, p.j));
                        visited[p.i - 1][p.j] = true;
                    }
                    if(p.i + 1 < m && grid[p.i + 1][p.j] == '1' && visited[p.i + 1][p.j] == false) {
                        queue.add(new Pair(p.i + 1, p.j));
                        visited[p.i + 1][p.j] = true;
                    }
                    if(p.j - 1 >= 0 && grid[p.i][p.j - 1] == '1' && visited[p.i][p.j - 1] == false) {
                        queue.add(new Pair(p.i, p.j - 1));
                        visited[p.i][p.j - 1] = true;
                    }
                    if(p.j + 1 < n && grid[p.i][p.j + 1] == '1' && visited[p.i][p.j + 1] == false) {
                        queue.add(new Pair(p.i, p.j + 1));
                        visited[p.i][p.j + 1] = true;
                    }
                }
                count++;
            }
        }
        return count;
    }
}
