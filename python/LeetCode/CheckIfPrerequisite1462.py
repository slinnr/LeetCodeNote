
"""

你总共需要上 n 门课，课程编号依次为 0 到 n-1 。

有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。

给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。

对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。

请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。

注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。

示例 1：

输入：n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
输出：[false,true]
解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。

示例 2：

输入：n = 2, prerequisites = [], queries = [[1,0],[0,1]]
输出：[false,false]
解释：没有先修课程对，所以每门课程之间是独立的。

解决方案：先使用floyd_warshall算出图中两点之间的距离，然后遍历queries，如果dp列表中两个点的距离为inf，就说明是没有
"""
class Solution(object):
    def checkIfPrerequisite(self, numCourses, prerequisites, queries):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :type queries: List[List[int]]
        :rtype: List[bool]
        """
        graph = [[0 for i in range(numCourses)] for j in range(numCourses)]

        for i, j in prerequisites:
            graph[i][j] = 1
        dist = self.floyd_warshall(graph, numCourses)
        res = []
        for index in range(len(queries)):
                res.append(bool(dist[queries[index][0]][queries[index][1]]))
        return res

    def floyd_warshall(self, dist, v):
        for i in range(v):
            for j in range(v):
                for k in range(v):
                    dist[j][k] = dist[j][k] or (dist[j][i] and dist[i][k])
        return dist



n = 13
prerequisites = [[2,1],[2,7],[2,0],[2,10],[2,11],[1,7],[1,0],[1,9],[1,4],[1,11],[7,3],[7,9],[7,4],[7,11],[7,8],[3,6],[3,12],[3,5],[6,10],[6,8],[0,4],[12,9],[12,8],[9,4],[9,11],[9,8],[9,5],[10,8],[4,8]]
queries = [[12,11],[11,1],[10,12],[9,10],[10,11],[11,12],[2,7],[6,8],[3,2],[9,5],[8,7],[1,4],[3,12],[9,6],[4,3],[11,4],[5,7],[3,9],[3,1],[8,12],[5,12],[0,8],[10,5],[10,11],[12,11],[12,9],[5,4],[11,5],[12,10],[11,0],[6,10],[11,7],[8,10],[2,1],[3,4],[8,7],[11,6],[9,11],[1,4],[10,8],[7,1],[8,7],[9,7],[5,1],[8,10],[11,8],[8,12],[9,12],[12,11],[6,12],[12,11],[6,10],[9,12],[8,10],[8,11],[8,5],[7,9],[12,11],[11,12],[8,0],[12,11],[7,0],[8,7],[5,11],[11,8],[1,9],[4,10],[11,6],[10,12]]
solution = Solution()
print(solution.checkIfPrerequisite(n, prerequisites, queries))
