package structures;

public class CustomIterator<T>  implements Iterator<T>, Comparable<T> {
    private Node<T> currentNode;

    public CustomIterator(Node<T> first){
        this.currentNode = first;
    }
    @Override
    public int compareTo(T o) {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return currentNode.getNext()!=null;
    }

    @Override
    public Node<T> next() {
        return currentNode.getNext();
    }
}
