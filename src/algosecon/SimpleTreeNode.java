package algosecon;

import java.util.ArrayList;
import java.util.List;

class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode.Children != null) {
            ParentNode.Children.add(NewChild);
        } else {
            List<SimpleTreeNode<T>> children = new ArrayList<>();
            children.add(NewChild);
            ParentNode.Children = children;
        }

        NewChild.Parent = ParentNode;
        // ваш код добавления нового дочернего узла существующему ParentNode
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        NodeToDelete.Parent.Children.remove(NodeToDelete);
        if (NodeToDelete.Parent.Children.isEmpty())
            NodeToDelete.Parent.Children = null;
        NodeToDelete.Parent = null;
        NodeToDelete.Children = null;
        // ваш код удаления существующего узла NodeToDelete
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> result = new ArrayList<>();
        result.add(this.Root);
        // ваш код выдачи всех узлов дерева в определённом порядке
        return getAllNodes(result, this.Root);
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        List<SimpleTreeNode<T>> result = new ArrayList<>();
        if (this.Root.NodeValue == val)
            result.add(Root);
        if (Root.Children != null)
            getNodeByValue(Root.Children, val, result);
        // ваш код поиска узлов по значению
        return result.isEmpty() ? null : result;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        if (!this.Root.equals(OriginalNode)) {
            OriginalNode.Parent.Children.remove(OriginalNode);
            NewParent.Children.add(OriginalNode);
            OriginalNode.Parent = NewParent;
        }
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
    }

    public int Count() {
        if (this.Root.Children == null)
            return 1;
        return getNodeCount(this.Root, 0);
    }

    public int LeafCount() {
        if (this.Root.Children == null)
            return 1;
        return getLeafCount(this.Root, 0);
    }

    public ArrayList<T> EvenTrees() {
        ArrayList<T> res = new ArrayList<>();
        if (this.Count() % 2 != 0)
            return res;
        for (SimpleTreeNode<T> node : this.Root.Children) {
            if (this.getNodeCount(node, 0) % 2 == 0) {
                res.add(Root.NodeValue);
                res.add(node.NodeValue);
            }
        }
        return res;
    }

    private void getNodeByValue(List<SimpleTreeNode<T>> children, T value, List<SimpleTreeNode<T>> result) {
        for (SimpleTreeNode<T> node : children) {
            if (node.NodeValue == value)
                result.add(node);
            if (node.Children != null)
                getNodeByValue(node.Children, value, result);
        }
    }

    private List<SimpleTreeNode<T>> getAllNodes(List<SimpleTreeNode<T>> result, SimpleTreeNode<T> root) {
        if (root.Children != null) {
            result.addAll(root.Children);
            for (SimpleTreeNode<T> node : root.Children) {
                getAllNodes(result, node);
            }
        }
        return result;
    }

    private int getLeafCount(SimpleTreeNode<T> root, Integer count) {
        if (root.Children == null)
            return count + 1;

        for (SimpleTreeNode<T> node : root.Children) {
            count = getLeafCount(node, count);
        }

        return count;
    }

    private int getNodeCount(SimpleTreeNode<T> root, Integer count) {
        if (root.Children != null) {
            count += 1;
            for (SimpleTreeNode<T> node : root.Children) {
                count = getNodeCount(node, count);
            }
        }
        return count;
    }
}
