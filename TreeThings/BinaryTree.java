/**
 * BinaryTree
 * 
 */
public class BinaryTree<T> extends Comparable<T> {
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
  private boolean inserRec(Node<T> root, T data){ // patron facade --> fachada
     // if three is empty, return a new node 
     if(root == null){
       return new Node<T>(data);

     }
     if(data.{
        root.setLeft(left = insertRec(root.getLeft(), key);
     }

     else if(key > root.getRight()){
       root. = inserRec(root.getRight(), key);
     }
     return root;
  }

}
