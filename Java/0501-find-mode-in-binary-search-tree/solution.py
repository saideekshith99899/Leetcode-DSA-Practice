# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import Counter
class Solution:
    def preorder(self,root,arr):
        if not root:
            return None
        self.preorder(root.left,arr)
        arr.append(root.val)
        self.preorder(root.right,arr)
        return arr
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        arr=[]
        self.preorder(root,arr)
        #return arr
        c=Counter(arr)
        mode=max(c.values())
        a=[]
        #for i,j in c.items():
            #a.append([i,j]
        #return mode
        for i,j in c.items():
            if mode==j:
                a.append(i)
        return a
