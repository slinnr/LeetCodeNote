class Solution(object):

    def destCity(self, paths):
        """
        :type paths: List[List[str]]
        :rtype: str
        """
        beginList = []
        endList = []

        for begin, end in paths:
            if begin in endList:
                endList.remove(begin)
            else:
                beginList.append(begin)
            if end in beginList:
                beginList.remove(end)
            else:
                endList.append(end)
        return endList[0]


solution = Solution()
city = solution.destCity([["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]])
print(city)
