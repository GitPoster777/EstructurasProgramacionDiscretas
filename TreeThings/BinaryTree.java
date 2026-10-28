/**
 * BinaryTree
 */
public class BinaryTree<T> {
  Node<T> root;

  public BinaryTree(){
    this.root = null;
  }
  // Method to insert a new node with given key
  public void insert(T data){
    root = insertRec(root, key);
  }
  private Node inserRec(Node root, int key){
     // if three is empty, return a new node 
     if(root == null){
       return new Node<E>(key);
     }
     if(key<root.getValue()){
        root.left = insertRec(root.getLeft(), key);
     }

     else if(key > root.getValue()){
       root.right = inserRec(root.getRight(), key);
     }
     return root;
  }

}
