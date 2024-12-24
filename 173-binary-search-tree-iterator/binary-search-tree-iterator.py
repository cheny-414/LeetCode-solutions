# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        self.nodes.append(root.val)
        self.inorder(root.right)

    def __init__(self, root: Optional[TreeNode]):
        self.nodes = []
        self.inorder(root)
        self.pointer = 0

    def next(self) -> int:
        ret = self.nodes[self.pointer]
        self.pointer += 1
        return ret

    def hasNext(self) -> bool:
        if self.pointer >= len(self.nodes):
            return False
        return True


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()