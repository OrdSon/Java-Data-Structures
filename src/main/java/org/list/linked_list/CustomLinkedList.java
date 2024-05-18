package org.list.linked_list;

import org.list.node.Node;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements java.io.Serializable{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {

    }

    public void setFirstElement(Node<T> value) {
        this.head = value;
        this.tail = value;
        this.head.setIndex(0);
        size ++;

    }
    /*
        Adds new element next to the target
        target -> newValue
     */
    private void addNextElement(Node<T>target,Node<T> newValue) {
        boolean hasNext = false;
        if(target.getNext() != null){
            newValue.setNext(target.getNext());
            target.getNext().setPrevious(newValue);
            hasNext = true;
        }
        newValue.setPrevious(target);
        target.setNext(newValue);
        if(!hasNext){
            this.tail = newValue;
        }
        newValue.setIndex(size);
        size++;
    }
    /*
        Adds element previous to the target
        newValue <- target
     */
    private void addPreviousElement(Node<T>target,Node<T> newValue) {
        boolean hasPrevious = false;
        if(target.getPrevious() != null){
            newValue.setPrevious(target.getPrevious());
            target.getPrevious().setNext(newValue);
            hasPrevious = true;
        }
        newValue.setNext(target);
        target.setPrevious(newValue);

        if(!hasPrevious){
            this.head = newValue;
        }
        newValue.calculateIndex();
        size ++;
    }


    public void add(T value) {

        if(value == null) {
            System.err.println("Error adding null value");
        };

        Node<T> content = new Node<>(value);
        if(isEmpty()){
            setFirstElement(content);
        }else{
            addNextElement(this.tail,content);
        }

    }

    public void addFirst(T value) {
        if(value != null) {
            addPreviousElement(this.head, new Node<T>(value));
        }else {
            System.err.println("Error adding null value");
        }
    }

    public void add(int index, T value) {
        Node<T> content = new Node<>(value);
        if(isIndex(index)) {
            if(index == 0) {
                addFirst(value);
            }else {
                Node<T> result = getNode(index);
                addPreviousElement(result,content);
            }
        }
    }

    public void addBefore(int index, T value) {

    }

    public void modify(int index, T value) {
        if(!isEmpty()){
            Node<T> node = getNode(index);
            node.setContent(value);
        }
    }

    public T peekFirst() throws NoSuchElementException {
        if(!isEmpty()){
            return head.getContent();
        }
        throw new NoSuchElementException();
    }

    public T peekLast() throws NoSuchElementException {
        if(!isEmpty()){
            return tail.getContent();
        }
        throw new NoSuchElementException();
    }

    public T removeFirst() {
        T value = this.head.getContent();
        deleteNode(this.head);
        return value;
    }

    public T removeLast() {
        T value = this.tail.getContent();
        deleteNode(this.tail);
        return value;
    }

    public void delete(int index){
        Node<T> node = getNode(index);
        if(!isEmpty()){
            deleteNode(node);
        }
    }

    private void deleteNode(Node<T> node) {
        if(node.getPrevious() != null) {
            if(node.getNext() != null) {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                size --;
            }else{
                this.tail = node.getPrevious();
                this.tail.getNext().setPrevious(null);
                this.tail.setNext(null);
                size --;
            }
        } else if (node.getNext()!=null) {
            this.head = node.getNext();
            this.head.getPrevious().setNext(null);
            this.head.setPrevious(null);
            size --;
        }else {
            this.head = null;
            this.tail = null;
            size --;
        }
    }

    public Node<T> getNode(int index) throws IndexOutOfBoundsException{
        if(isIndex(index)){
            Node<T> result = this.head;
            for(int i = 0; i < index; i++){
                result = result.getNext();
            }
            return result;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public int indexOf(T value){
        Node<T> node = searchByContent(value);
        if(node != null){
            return node.getIndex();
        }
        return -1;
    }

    public Node<T> searchByContent(T value){
        if(!isEmpty()){
            Node<T> result = this.head;
            for(int i = 0; i < this.size; i++){
                if(!result.getContent().equals(value)){
                    result = result.getNext();
                }else{
                    return result;
                }
            }
        }
        return null;
    }

    public boolean exists(T value){
        return searchByContent(value) != null;
    }

    public boolean isIndex(int index){
        return !(index < 0 || index >= this.size);
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < this.size; i++){
            result.append(getNode(i).getContent().toString());
            result.append("\n");
        }
        return result.toString();
    }

    public int getSize(){
        return this.size;
    }
}
