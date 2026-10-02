package structures;
// Abstraccion de la clase nodo para una lista doblemente enlazada
public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;


    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    // los getters me permiten consultar los enlaces
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }
    // Los setters me permiten modificar los enlaces
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

}

