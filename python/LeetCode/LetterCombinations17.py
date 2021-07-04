from typing import List
import copy
"""根据题意暴力循环求结果就行"""
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        dict = {
            "2":['a','b','c'],
            "3":['d','e','f'],
            "4":['g','h','i'],
            "5":['j','k','l'],
            "6":['m','n','o'],
            "7":['p','q','r','s'],
            "8":['t','u','v'],
            "9":['w','x','y','z']
                }
        temp = []
        wordList = []
        for digit in digits:
            wordList.clear()
            if len(temp) == 0:
                wordList = dict[digit].copy()
            else:
                for list in temp:
                    for letter in dict[digit]:
                        j = list + letter
                        wordList.append(j)
            temp = wordList.copy()
        return wordList

solution = Solution()
print(solution.letterCombinations("22"))

