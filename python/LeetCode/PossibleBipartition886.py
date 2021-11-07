"""
886. 可能的二分法

给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。

每个人都可能不喜欢其他人，那么他们不应该属于同一组。

形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。

当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。

示例 1：

输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
输出：true
解释：group1 [1,4], group2 [2,3]

示例 2：

输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
输出：false

示例 3：

输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
输出：false


"""

class Solution(object):
    def possibleBipartition(self, n, dislikes):
        """
        :type n: int
        :type dislikes: List[List[int]]
        :rtype: bool
        """
         graph = [[0 for i in range(n)] for j in range(n)]

        for i, j in dislikes:
            graph[i-1][j-1] = 1
        colors = [0] * n
        for i in range(n):
            if colors[i] == 0 and self.dfs(n, colors, graph, i, 1):
                return True
        return False

    def dfs(self, n, colors, graph, i, color):

        for person in range(n):
            if graph[i][person]:
                if color[person] == 0:
                    color[person] = -1
                else:
                    self.dfs(n, color, graph, person)


