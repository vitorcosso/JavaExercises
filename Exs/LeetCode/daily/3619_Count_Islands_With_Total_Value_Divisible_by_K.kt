// 26/10/2026
class Solution {
    fun countIslands(grid: Array<IntArray>, k: Int): Int {
        val rows = grid.size
        val columns = grid[0].size
        val visited = Array(rows) { BooleanArray(columns) }
        var res = 0

        fun dfs(r: Int, c: Int): Long {
            if (r !in 0 until rows ||
                c !in 0 until columns ||
                grid[r][c] == 0 ||
                visited[r][c]
            ) {
                return 0L
            }

            visited[r][c] = true
            var sum = grid[r][c].toLong()

            sum += dfs(r + 1, c)
            sum += dfs(r - 1, c)
            sum += dfs(r, c + 1)
            sum += dfs(r, c - 1)

            return sum
        }

        for (r in 0 until rows) {
            for (c in 0 until columns) {
                if (grid[r][c] != 0 && !visited[r][c]) {
                    val sum = dfs(r, c)

                    if (sum % k == 0L) {
                        res++
                    }
                }
            }
        }

        return res
    }
}
