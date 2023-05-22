package algosecon.balanced;

import java.util.Arrays;

public class BalancedBST {
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        // создаём дерево с нуля из неотсортированного массива a
        // ...
        Arrays.sort(a);
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
        BSTNode node = new BSTNode(src[mid], parent);
        node.Level = level;
        level += 1;
        final BSTNode leftChild = makeBalancedTree(src, start, mid - 1, level, node);
        final BSTNode rightChild = makeBalancedTree(src, mid + 1, end, level, node);
        if (leftChild != null)
            leftChild.Level = level;
        if (rightChild != null)
            rightChild.Level = level;
        node.LeftChild = leftChild;
        node.RightChild = rightChild;
//        } else {

        return node;

    }
}
