package com.company;

public class List {

    private int size = 0;
    private Node head = null;
    private class Node {
        String  data;
        Node next;


        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }



    public int size() {
        return size;
    }



    public void add(String elem) {
        if (size() == 0) {
            head  = new Node(elem, null);
            size++;
            return;
        }


        Node trav = head;
        while (trav.next!=null){
            if (cmp(trav.data, elem) && cmp(elem, trav.next.data)) {
                trav.next = new Node(elem, trav.next);
                size++;
                return;
            }
            trav = trav.next;
        }

        trav.next=new Node(elem,null);
        size++;
    }

    private boolean cmp(String s1, String s2){
        int len;
        if (s1.length()>s2.length()){
            len=s2.length();
        }else {
            len=s1.length();
        }
        for (int i=0;i<len;i++){
            if (s1.charAt(i)<s2.charAt(i)) return true;
            if (s1.charAt(i)>s2.charAt(i)) return false;
        }
        return true;
    }


    public void print(){
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

    }

    public boolean search(String s){
        Node temp = head;
        while(true){
            if (temp.data.equals(s))return true;
            if (temp.next==null) break;
            temp=temp.next;
        }
        return false;
    }

    public boolean delete(String s){
        Node temp = head;
        if (temp.data.equals(s)){
            head = head.next;
            size--;
            return true;
        }
        while(temp.next!=null){
            if (temp.next.data.equals(s)){
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp=temp.next;
        }
        return false;
    }


}
