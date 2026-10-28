public class Node<E> {
  Node left, right;
  E value;
  
  public Node(E item){
    this.left = this.right = null;
    this.value = item; 
  }
  public Node getLeft(){
    return this.left;
  }
  public Node getRight(){
    return this.right;
  }

  public E getValue(){
    return this.value;
  }

}
