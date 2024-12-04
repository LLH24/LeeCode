package Hot100;

import java.util.LinkedList;

public class GraphTheory {
    /***
     * 岛屿数量DFS
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    nums++;
                    toDFS(grid,i,j);
                }
            }
        }
        return nums;
    }

    public void toDFS(char[][] root, int i, int j) {
        if (i < 0 || i >= root.length) return;
        if (j < 0 || j >= root[0].length) return;
        if (root[i][j] == '1'){
            root[i][j] = '2';
            toDFS(root,i+1,j);
            toDFS(root,i,j+1);
            toDFS(root,i-1,j);
            toDFS(root,i,j-1);
        }
    }

    /***
     * 腐烂的橘子BFS
     * @param grid
     * @return
     */

    LinkedList<int[]>  linkedListBfs = new LinkedList<int[]>();
    public int orangesRotting(int[][] grid) {
        int maxDays = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    linkedListBfs.add(new int[]{i,j});
                }
            }
        }
        maxDays = Math.max(toBFS(grid),0);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return maxDays;
    }

    public int toBFS(int[][] root){
        int days = 0;
        while(!linkedListBfs.isEmpty()){
            int size = linkedListBfs.size();
            while(size > 0){
                int[] pop = linkedListBfs.pop();
                int i = pop[0];
                int j = pop[1];
                size--;
                addBfsNode(i+1,j,root);
                addBfsNode(i-1,j,root);
                addBfsNode(i,j+1,root);
                addBfsNode(i,j-1,root);
            }
            days++;

        }
        return days-1;
    }

    public void addBfsNode(int i,int j,int[][] root){
        if ( i < 0 || j < 0 || i >= root.length || j >= root[0].length||root[i][j] == 0 || root[i][j] == 2 ) return;
        linkedListBfs.add(new int[]{i,j});
        root[i][j] = 2;
    }
}
