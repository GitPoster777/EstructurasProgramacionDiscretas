
/**
 * BinaryTree
 * 
 */
public class BSTApo<T> extends Comparable<T> {
  // Propiedad de orden -> facilita la busqueda O(log n)
  Node<T> root;

  public BinaryTree(){
    this.root = null;
  }
  // patron facade --> fachada

  // Method to insert a new node with given key
  public boolean insertNode(T data){
    return insertRec(root, data);
  }
  private boolean inserRec(Node<T> node, T data){ // patron facade --> fachada
     // if three is empty, return a new node 
     BSTApo<T>  newNode = new BSTApo<>(data);
     if(root == null){
       return new Node<T>(data);
        return true;
     }
     else if(newNode.getValue().compareTo(node.getValue())>1){
       if(node.getRight() == null){
         node.setRight(newNode);
         return true;

       }
       return inserRec(node.getRight(), data);
     }
     else if(newNode.getValue().compareTo(node.getValue())<1){
       if(node.getLeft() == null){
         node.setLeft(newNode);
         return true;
       }
       return inserRec(node.getLeft(), data);
     }
    return false;
}
// Implementar recorridos de arbol 

//Implementar preOrder con fachada
public void inOrder(){
  inOrderRec(root);
}
private void inOrderRec(Node<T> node){
  if(node != null){
    inOrderRec(node.getLeft());
    System.out.println(node.getValue());
    inOrderRec(node.getRight())
  }
}
//implementar inOrder
public void preOrder(){
  preOrderRec(root);
}
private void preOrderRec(Node<T> node){
  if(node != null){
    System.out.println(node.getValue());
    preOrderRec(node.getLeft());
    preOrderRec(node.getRight())
  }
}
//implementar postOrder
public void postOrder(){
  postOrderRec(root);
}
private void postOrderRec(Node<T> node){
  if(node != null){
    postOrderRec(node.getLeft());
    postOrderRec(node.getRight()) 
    System.out.println(node.getValue());
    
  }
}
}
