package structures;

// Abstraccion de la clase de lista enlazada me permite manipular la lista enlazada
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
    }

    //Operacion insertar al final
    public void insertNode(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;

    }


    //Operacion insertar en un punto en especifico
    public void insertNodeAfterNode(T data, T dataAfter){
        Node<T> node = new Node<>(data);
        Node<T> currentNode = head;
        while(!currentNode.getData().equals(dataAfter)){
            currentNode = currentNode.getNext();

        }
        Node<T> temp = currentNode.getNext();
        node.setNext(temp);
        temp.setPrev(node);
        
    }
    //Operacion insertar antes
    public void insertNodeBefore(T data, T dataBefore){
        Node<T> newNode = new Node<T>(data);
        Node<T> currentNode = head;
        while(!currentNode.getData().equals(dataBefore)){
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode);
        newNode.setPrev(currentNode.getPrev());

        currentNode.setPrev(newNode);
        newNode.getPrev().setNext(newNode);
    }
    //Operacion de eliminar al principio
    public void deleteNode(T data){
        if(head.getData().equals(data)){
            if(head.getNext() ==  null){
                head = null;
            }
            Node<T> temp = head.getNext();
            head.setNext(null);
            temp.setPrev(null);
            head = temp;

        } else if () {

        }
    }
    //eliminar entre dosnnn
    public void deleteNodeLast(T data){
        Node<T> currentNode = head;
        while(!currentNode.getData().equals(data)) {
            currentNode = currentNode.getNext();
            if(currentNode == tail){
                break;
            }
        }
        Node<T> temp = currentNode.getPrev();
        currentNode.setPrev(null);
        temp.setNext(currentNode.getNext());
        currentNode.getNext().setPrev(temp);
        }
    // Operacion de busqueda
    public boolean searchNode(T data){
        Node<T> currentNode=
    }
    // Operacion de ordenar
    public void bubbleSort(){
        for(int i = 0; i< size; i++){

        }
    }

    @Override
    public CustomIterator<T> iterator(){
        return new
    }


}
