public class BinaryTree {
  Node root;

  BinaryTree() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void insert(int data) {
    root = insert(root, data);
  }

  private Node insert(Node node, int data) {
    if (node == null)
      node = new Node(data);
    else {
      if (node.getRight() == null)
        node.right = insert(node.right, data);
      else
        node.left = insert(node.left, data);
    }
    return node;
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    for (int i = 0; i < 10; i++)
      tree.insert(i);
    //  System.out.println()
  }
}
