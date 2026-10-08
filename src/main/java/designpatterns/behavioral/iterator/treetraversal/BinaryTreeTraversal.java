package designpatterns.behavioral.iterator.treetraversal;

import java.util.Iterator;

public class BinaryTreeTraversal {
    static void main() {
        BinaryTree tree = new BinaryTree();
        tree.createSimpleTree();
        /*
                  10
             5        20
          3    7
         */
        Iterator<Integer> it = tree.preOrderIterator();
        while  (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
