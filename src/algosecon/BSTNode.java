package algosecon;

class BSTNode<T> {
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T> {
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }
}

class BST<T> {
   BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        return findNodeByKey(Root, key);
    }

    public boolean AddKeyValue(int key, T val) {
        // добавляем ключ-значение в дерево
        BSTFind<T> tbstFind = FindNodeByKey(key);
        if (tbstFind == null || tbstFind.NodeHasKey)
            return false;
        if (tbstFind.ToLeft) {
            tbstFind.Node.LeftChild = new BSTNode<>(key, val, tbstFind.Node);
            return true;
        }
        tbstFind.Node.RightChild = new BSTNode<>(key, val, tbstFind.Node);
        return true; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FindMax) {
            return FromNode.RightChild == null ? FromNode : FinMinMax(FromNode.RightChild, FindMax);
        }
        return FromNode.LeftChild == null ? FromNode : FinMinMax(FromNode.LeftChild, FindMax);
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> nodeByKey = findNodeByKey(Root, key);
        if (nodeByKey == null)
            return false; // если узел не найден
        if(nodeByKey.Node.RightChild == null && nodeByKey.Node.LeftChild == null){
            if(nodeByKey.Node.Parent.NodeKey < key){
                nodeByKey.Node.Parent.RightChild = null;
                return true;
            }
            nodeByKey.Node.Parent.LeftChild = null;
            return true;
        }
        if (nodeByKey.Node.RightChild!=null){
            BSTNode<T> leftMin = FinMinMax(nodeByKey.Node.RightChild, false);
            if (leftMin != null) {
                if (leftMin.Parent.NodeKey > leftMin.NodeKey) {
                    leftMin.Parent.LeftChild = null;
                } else {
                    leftMin.Parent.RightChild = null;
                }
                if (nodeByKey.Node.Parent.NodeKey < key) {
                    nodeByKey.Node.Parent.RightChild = leftMin;
                } else {
                    nodeByKey.Node.Parent.LeftChild = leftMin;
                }
                leftMin.Parent = nodeByKey.Node.Parent;
                leftMin.LeftChild = nodeByKey.Node.LeftChild;
                if (nodeByKey.Node.LeftChild != null)
                    nodeByKey.Node.LeftChild.Parent = leftMin;
                leftMin.RightChild = nodeByKey.Node.RightChild;
                if (nodeByKey.Node.RightChild != null)
                    nodeByKey.Node.RightChild.Parent = leftMin;
                return true;
            }
        }
        if(nodeByKey.Node.Parent.NodeKey < key) {
            nodeByKey.Node.Parent.LeftChild = null;
            return true;
        }
        nodeByKey.Node.Parent.RightChild = null;
        return true;

    }

    public int Count() {
        return getNodeCount(Root, 0); // количество узлов в дереве
    }

    private BSTFind<T> findNodeByKey(BSTNode<T> node, int key) {
        if (node == null)
            return null;
        if (node.NodeKey == key) {
            BSTFind<T> res = new BSTFind<>();
            res.Node = node;
            res.NodeHasKey = true;
            return res;
        }
        if (node.NodeKey < key) {
            if (node.RightChild == null) {
                BSTFind<T> res = new BSTFind<>();
                res.Node = node;
                res.NodeHasKey = false;
                res.ToLeft = false;
                return res;
            }
            return findNodeByKey(node.RightChild, key);
        }
        if (node.LeftChild == null) {
            BSTFind<T> res = new BSTFind<>();
            res.Node = node;
            res.NodeHasKey = false;
            res.ToLeft = true;
            return res;
        }
        return findNodeByKey(node.LeftChild, key);
    }

    private int getNodeCount(BSTNode<T> root, int count) {
        count += 1;
        if (root.LeftChild != null)
            count = getNodeCount(root.LeftChild, count);
        if (root.RightChild != null)
            count = getNodeCount(root.RightChild, count);
        return count;
    }

}

