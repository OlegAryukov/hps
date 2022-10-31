package algosecon;

import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}
//public class SimpleTree<T> {
//    public SimpleTreeNode<T> Root; // корень, может быть null
//
//    public SimpleTree(SimpleTreeNode<T> root) {
//        Root = root;
//    }
//
//    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
//        ParentNode.Children.add(NewChild);
//        NewChild.Parent = ParentNode;
//        // ваш код добавления нового дочернего узла существующему ParentNode
//    }
//
//    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
//        NodeToDelete.Parent.Children.remove(NodeToDelete);
//        NodeToDelete.Parent = null;
//        NodeToDelete.Children = null;
//        // ваш код удаления существующего узла NodeToDelete
//    }
//
//    public List<SimpleTreeNode<T>> GetAllNodes() {
//        // ваш код выдачи всех узлов дерева в определённом порядке
//        return null;
//    }
//
//    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
//        List<SimpleTreeNode<T>> result = new ArrayList<>();
//        if(this.Root.NodeValue == val)
//            result.add(Root);
//        if(!Root.Children.isEmpty())
//            getNodeByValue(Root.Children, val, result);
//        // ваш код поиска узлов по значению
//        return result.isEmpty() ? null : result;
//    }
//
//    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
//        // ваш код перемещения узла вместе с его поддеревом --
//        // в качестве дочернего для узла NewParent
//    }
//
//    public int Count() {
//        // количество всех узлов в дереве
//        return 0;
//    }
//
//    public int LeafCount() {
//        // количество листьев в дереве
//        return 0;
//    }
//
//    private void getNodeByValue(List<SimpleTreeNode<T>> children, T value, List<SimpleTreeNode<T>> result){
//        for (SimpleTreeNode<T> node : children) {
//            if(node.NodeValue == value)
//                result.add(node);
//            if(!node.Children.isEmpty())
//                getNodeByValue(node.Children, value, result);
//        }
//    }
//}
