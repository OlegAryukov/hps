package algosecon.push;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}
class BalancedBST {
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        // создаём дерево с нуля из неотсортированного массива a
        // ...
        this.Root = makeBalancedTree(a, 0, a.length - 1, 0, null);
    }

    public boolean IsBalanced(BSTNode root_node) {
        final int leftLevel = getLeftLevel(root_node);
        final int rightLevel = getRightLevel(root_node);
        return (leftLevel == rightLevel) || (Math.abs(leftLevel - rightLevel) == 1); // сбалансировано ли дерево с корнем root_node
    }

    private int getLeftLevel(BSTNode root) {
        return root.LeftChild == null ? root.Level : getLeftLevel(root.LeftChild);
    }

    private int getRightLevel(BSTNode root) {
        return root.RightChild == null ? root.Level : getRightLevel(root.RightChild);
    }

    private BSTNode makeBalancedTree(int[] src, int start, int end, int level, BSTNode parent) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
//        if(level == 0){
        level++;
        BSTNode node = new BSTNode(src[mid], parent);
        node.LeftChild = makeBalancedTree(src, start, mid - 1, level, node);
        node.RightChild = makeBalancedTree(src, mid + 1, end, level, node);
//        } else {

        return node;

    }
}
