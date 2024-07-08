class linkedlist{
    Node head;
    private int size;

    linkedlist(){
        this.size= 0;
    }
    class Node{
        int data;
        Node next;
        Node (int data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    
    public void insertAtFirst(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        
            newNode.next=head;
            head=newNode;
        
    }
     public void insertAtLast(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node last = head;
        while(last.next != null){
            last=last.next;
            
        }
        last.next=newNode;
        return;
    }

    public void insertAtOrder(int data){
        Node newNode =new Node(data);
        if(head==null){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node save=head;
        while((newNode.data >= save.next.data)){
            save = save.next;
        }
        newNode.next = save.next;
        save.next = newNode;

    }
    public void removeAtFirst(){
        if(head==null){
          System.out.println("The list is empty");
            return;
        }
        size--;
        head = head.next;

    }

    public void removeAtLast(){
        if(head==null){
          System.out.println("The list is empty");
            return;
        }
        if(head.next == null){
            head=null;
            return;
        }
        size--;

        Node pred = head;
        Node save = head.next;

        while(save.next != null){
            save = save.next;
            pred =pred.next;

        }
        pred.next=null;


    }

    public int getSize(){
        return (size);
    }



    public void print(){
        Node currNode = head;
           if(head==null){
            System.out.println("List is empty");
            return;
        }
            
        while(currNode != null){
             System.out.print(currNode.data+"-->");
            currNode=currNode.next;
            
        }
       System.out.println("null");
    }



    public static void main(String args[]){
        linkedlist list = new linkedlist();
        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.print();

        list.insertAtLast(8);
        list.print();

        // list.insertAtFirst("this");
        // list.print();

        list.insertAtOrder(6);
        list.print();

        list.removeAtFirst();
        list.print();


        list.removeAtLast();
        list.print();

       System.out.println( list.getSize());
    }
}