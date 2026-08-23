class Solution {
    public void islandsAndTreasure(int[][] grid) {
        List<int[]> treasure = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    treasure.add(new int[]{i,j});
            }
        }

        for(int[] point:treasure){
            int x = point[0];
            int y = point[1];
            dfs(grid, x, y, 0);
        }
    }

    public void dfs(int[][] grid, int x, int y, int distance){
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir:dirs){
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            
            if(x1<0 || y1<0 || x1>=grid.length || y1>=grid[0].length){
                continue;
            }
            if(grid[x1][y1] == 0 || grid[x1][y1] == -1){
                continue;
            }            
            if(distance+1<grid[x1][y1]){
                grid[x1][y1] = distance+1;
                dfs(grid, x1, y1, distance+1);
            }
            
        }
    }
}
