package designpatterns.behavioral.iterator.treetraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree {
    private Node root;

    public static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    public BinaryTree() {

    }

    public void createSimpleTree() {
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
    }

    public Iterator<Integer> preOrderIterator() {
        return new PreOrderIterator(root);
    }

    private static class PreOrderIterator implements Iterator<Integer> {
        private Stack<Node> stack = new Stack<>();

        public PreOrderIterator(Node root) {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            return node.value;
        }
    }

}