// can improve run time - beats only 10%
// 25/10/2026

class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        var rows = grid.size
        var columns = grid[0].size

        var visited = mutableSetOf<List<Int>>()
        var res = 0

        fun dfs(r: Int, c: Int): Int {
            if(r == rows || c == columns || c < 0 || r < 0) // edge case
                return 0
            if(grid[r][c] == 1 || visited.contains(listOf(r,c)))
                return 1
            
            visited.add(listOf(r,c))

            return minOf(
                dfs(r + 1, c),
                dfs(r - 1, c),
                dfs(r, c + 1),
                dfs(r, c - 1)
            )
        }

        for(r in 0 until rows){
            for(c in 0 until columns){
                if(grid[r][c] == 0 && !visited.contains(listOf(r,c))){
                    res = res + dfs(r,c)
                }
            }
        }
        return res

    }

}
