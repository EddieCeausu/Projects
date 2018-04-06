public class Node {
  Node left, right;
  int key;

  public Node(int key) {
    this.key = key;
    left = right = null;
  }

  public Node() {
    left = right = null;
    this.key = 0;
  }

  public int getData() {
    return key;
  }

  public void changeData(int n) {
    this.key = n;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public String toString() {
    return key + "";
  }
}
