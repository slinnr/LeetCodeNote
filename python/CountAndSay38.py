"""根据题意暴力输出"""
class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        temp = "1" + ""
        for i in range(n-1):
            sayString = ""
            num = int(temp[0])
            count = 0
            for j in range(len(temp)):
                if str(num) == temp[j]:
                    count+=1
                else:
                    sayString += str(count) + str(num)
                    num = int(temp[j])
                    count = 1
                if j == (len(temp) - 1):
                    sayString += str(count) + str(num)
            temp = sayString
        return sayString