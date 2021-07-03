public class Node<T> {
    T data;
    Node<T> nextNode;

    Node(T data) {
        this.data = data;
        this.nextNode = null;
    }
}
