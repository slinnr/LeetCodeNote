"""

有 n 个网络节点，标记为 1 到 n。

给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。

示例 1：

输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2

"""


import heapq

class Solution(object):
    def networkDelayTime(self, times, n, k):
        """
        :type times: List[List[int]]
        :type n: int
        :type k: int
        :rtype: int
        """
        graph = {}
        for list in times:
            if graph.get(list[0]):
                graph.get(list[0]).update({list[1] : list[2]})
                continue
            graph.update({list[0] : {list[1] : list[2]}})
        res = 0
        for i in range(1, n+1):
            ret = self.dijkstra(graph, k, i)
            #如果有无法到达的点，立马返回-1
            if ret == -1:
                return -1
            res = max(ret, res)
        return res


    def dijkstra(self, graph, start, end):
        heap = [(0, start)]
        visited = set()
        while heap:
            (cost, u) = heapq.heappop(heap)

            if u in visited:
                continue
            visited.add(u)
            if u == end:
                return cost
            if graph.get(u):
                for v, c in graph[u].items():
                    if v in visited:
                        continue
                    next = cost + c
                    heapq.heappush(heap, (next, v))
        return -1

times = [[2,1,1],[2,3,1],[3,4,1]]
times = [[1,2,1]]
times = [[1,2,1],[2,3,7],[1,3,4],[2,1,2]]
n = 4
k = 1
solution = Solution()
print(solution.networkDelayTime(times, n, k))