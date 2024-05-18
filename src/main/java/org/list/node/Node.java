package org.list.node;


//Generic serializable node for usage in 2D lists
public class Node <T> implements java.io.Serializable {
    int index;
    private Node<T> previous;
    private Node<T> next;
    private T content;
    public Node(T content) {
        this.content = content;
    }
    public Node(T content, int index) {
        this.content = content;
        this.index = index;
    }
    public Node(T content, Node<T> previous, Node<T> next) {
        this.content = content;
        this.previous = previous;
        this.next = next;
    }
    public Node(T content, int index, Node<T> previous, Node<T> next) {
        this.content = content;
        this.index = index;
        this.previous = previous;
        this.next = next;
    }

    public void calculateIndex(){
        if(previous == null){
            index = 0;
        }else{
            index = previous.getIndex() + 1;
        }
        if(next != null){
            next.calculateIndex();
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String toString() {
        return content.toString();
    }
}
