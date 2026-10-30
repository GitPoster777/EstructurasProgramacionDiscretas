
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
}
