package matrix;

/**
 * @author badrikant.soni
 * Video : https://www.youtube.com/watch?v=WRxGI8TeckU (Best Explaination)
 * Vidoe : Another : https://www.youtube.com/watch?v=CLvNe-8-6s8
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        //initialize number of islands to zero
        int numberOfIslands = 0;

        //iterate through every index of the grid
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    //attempt to "sink" the current index of the grid
                    numberOfIslands++;
                    changeLandToWater(grid, i, j);
                }
            }
        }

        //return the total number of islands
        return numberOfIslands;

    }

    void changeLandToWater(char[][] grid, int i, int j) {

        //check the bounds of i and j and if the current index is an island or not (1 or 0)
        // base conditions
        // 1) row less than 0
        // 2) row greater than grid.length
        // 3) column less than 0
        // 4) column greater than grid[0].length
        // 5) if position is a '0'
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return ;
        }

        // set current index to 0
        grid[i][j] = '0';

        // sink all neighbors of current index
        changeLandToWater(grid, i + 1, j); // down
        changeLandToWater(grid, i - 1, j); // up
        changeLandToWater(grid, i, j + 1); // right
        changeLandToWater(grid, i, j - 1); // left

    }

    public static void main(String[] args) {

         char[][] M = new char[][]
                 {
                 { '1', '1', '0', '0', '0' },
                 { '0', '1', '0', '0', '1' },
                 { '1', '0', '0', '1', '1' },
                 { '0', '0', '0', '0', '0' },
                 { '1', '0', '1', '0', '1' }
                };
        NumberOfIslands I = new NumberOfIslands();
        System.out.println("Number of islands is: " + I.numIslands(M));
    }
}
