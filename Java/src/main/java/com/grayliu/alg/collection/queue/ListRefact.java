package com.grayliu.alg.collection.queue;

/**
 * Created by liuhui-ds9 on 2017/8/18.
 */
public class ListRefact {

    public static void main(String...args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        printNode(node1);

        Node firstNode = node1;
        Node newNode = null;
        Node secondNode = null;

        while(firstNode.hasNext()){
            secondNode = firstNode.getNextNode();

            firstNode.setNext(newNode);
            newNode = firstNode;

            firstNode = secondNode;
        }
        firstNode.setNext(newNode);
        newNode = firstNode;

        printNode(newNode);
    }

    public static void printNode(Node node){
        System.out.println(node.data);
        if(node.hasNext()){
            printNode(node.getNextNode());
        }
    }
}

class Node {
    int data = 0;
    Node next = null;

    public Node(int i){
        data = i;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public boolean hasNext(){
        if(next != null){
            return true;
        }else{
            return false;
        }
    }

    public Node getNextNode(){
        return next;
    }
}