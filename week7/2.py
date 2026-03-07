class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value      # operator or operand
        self.left = left        # left child node
        self.right = right      # right child node

    def __repr__(self):
        return f"Node({self.value})"
    

    def _str(self, level=0):
            result = ""

            # print right subtree first
            if self.right:
                result += self.right._str(level + 1)

            # print current node
            result += "    " * level + str(self.value) + "\n"

            # print left subtree
            if self.left:
                result += self.left._str(level + 1)

            return result

    def __str__(self):
        return self._str()

# leaves
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n1 = Node(1)
# internal nodes
n5 = Node('+', n2, n3)
n6 = Node('-', n4, n1)
# root
n7 = Node('*', n5, n6)

print(n7)