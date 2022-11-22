package algosecon;

import java.util.ArrayList;

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
        if(Root == null){
            Root = new BSTNode<>(key, val, null);
            return true;
        }
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
        if (nodeByKey.Node == null)
            return false; // если узел не найден
        if (nodeByKey.Node.RightChild == null && nodeByKey.Node.LeftChild == null) {
            if(nodeByKey.Node.equals(Root)){
                Root = null;
                return true;
            }
            if (nodeByKey.Node.Parent.NodeKey < key) {
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
        return Root == null ? 0 : getNodeCount(Root, 0); // количество узлов в дереве
    }

    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> res = new ArrayList<>();
        ArrayList<BSTNode> levelNodes = new ArrayList<>();
        if (Root == null)
            return res;
        res.add(Root);
        if (Root.LeftChild != null)
            levelNodes.add(Root.LeftChild);
        if (Root.RightChild != null)
            levelNodes.add(Root.RightChild);
        return wideSearch(res, levelNodes);

    }

    public ArrayList<BSTNode> DeepAllNodes() {
        ArrayList<BSTNode> result = new ArrayList<>();
        if (this.Root.NodeKey == 0) {
            return inOrderTraversal(result, this.Root);
        }
        if (this.Root.NodeKey == 1) {
            return postOrderTraversal(result, this.Root);
        }
        return preOrderTraversal(result, this.Root);

    }

    private ArrayList<BSTNode> preOrderTraversal(ArrayList<BSTNode> result, BSTNode node) {
        if(node == null)
            return result;
        result.add(node);
        preOrderTraversal(result, node.LeftChild);
        return preOrderTraversal(result, node.RightChild);
    }

    private ArrayList<BSTNode> postOrderTraversal(ArrayList<BSTNode> result, BSTNode node) {
        if(node == null)
            return result;
        postOrderTraversal(result, node.LeftChild);
        postOrderTraversal(result, node.RightChild);
        result.add(node);
        return result;
    }

    private ArrayList<BSTNode> inOrderTraversal(ArrayList<BSTNode> result, BSTNode node) {
        if(node == null)
            return result;
        inOrderTraversal(result, node.LeftChild);
        result.add(node);
        inOrderTraversal(result, node.RightChild);
        return result;
    }

    private ArrayList<BSTNode> wideSearch(ArrayList<BSTNode> result, ArrayList<BSTNode> allLevelNodes) {
        if (allLevelNodes.isEmpty())
            return result;
        result.addAll(allLevelNodes);
        ArrayList<BSTNode> copyAllLevelNodes = new ArrayList<>(allLevelNodes);
        allLevelNodes.clear();
        for (BSTNode node : copyAllLevelNodes) {
            if (node.LeftChild != null)
                allLevelNodes.add(node.LeftChild);
            if (node.RightChild != null)
                allLevelNodes.add(node.RightChild);
        }
        return wideSearch(result, allLevelNodes);
    }

    private BSTFind<T> findNodeByKey(BSTNode<T> node, int key) {
        if (node == null)
            return new BSTFind<>();
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

