
public class AVLtree<T extends Comparable<T>> {
    private NodeAVL<T> root;

    public AVLtree() {
        root = null;
    }
    private NodeAVL<T> getRoot(){
      return root;
    }
    private int getHeigth(NodeAVL<T> node){
      if(node = null){// Caso base
        return 0;
      }
      return node.getAltura();
    }
    private int balanceFactor(NodoAVL<T> node){
      if(node=null){
        return 0;
      }
      return getHeigth(node.getDerecho())-getHeigth(node.getIzquierdo());
    }
    private NodeAVL<T> rightRotation(NodoAVL<T> y){
      //Creamos un nuevo nodo
      NodeAVL<T> x = y.getIzquierdo();
      NodeAVL<T> T2 = x.getIzquierdo();

      //Aplicamos la rotacion 
      x.setIzquierdo(y);
      y.setDerecho(T2);

      // Realizamos la operacion de balanceo
      
    } 
  }
