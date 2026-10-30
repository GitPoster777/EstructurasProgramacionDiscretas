public class Node<T> extends Comparable<T> {
  Node left, right;
  T value;
  
  public Node(T item){
    this.left = this.right = null;
    this.value = item; 
  }
  public Node getLeft(){
    return this.left;
  }
  public Node getRight(){
    return this.right;
  }

  public T getValue(){
    return this.value;
  }

  public void setLeft(Node<T> left){
    this.left = left;
  }

  public void setRight(Node<T> right){
    this.right = right;
  }
}
