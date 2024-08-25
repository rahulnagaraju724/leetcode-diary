class LRUCache {

    public class Node { 
        int value; 
        int key;
        Node prev; 
        Node next; 
    
        public Node(int value,int key) 
        { 
            this.value = value; 
            this.key=key;
            this.prev = null; 
            this.next = null; 
        } 
    } 

    int capacity;

    Node head; //-> most recently used
    Node tail; //-> least recently used

    HashMap<Integer,Node> cache;

    public LRUCache(int capacity) {
        this.capacity=capacity;

        this.head=null;
        this.tail=null;

        cache=new HashMap<>();
    }
    
    public int get(int key) {

        // System.out.println("Get inside"+key);
        
        
        // printList(head);

        Node node = cache.get(key);

        if(node==null){
            return -1;
        }

        if(head==node && tail==node){
            // don't do anything
            return node.value;
        }
        if(head==node){
            // Dont do anything here as well
            return node.value;
        }

        if(tail==node){
            tail=tail.prev;
        }

        if(node.prev!=null){
            node.prev.next=node.next;
        }
        
        if(node.next!=null){
            node.next.prev=node.prev;
        }
        

        node.prev=null;
        //node.next=null;

        node.next=head;

        if(head!=null){
            head.prev=node;
            head=node;
        }else{ // I dont think this case will arise
            head=node;
            tail=node;
        }
        
        return node.value;
    }


    
    public void put(int key, int value) {
        // System.out.println("Put inside"+key+","+value);
        // printList(head);
        //First check if it's already there
        Node node=cache.get(key);
        if(node!=null){
            node.value=value;
            // and also move to head;
            if(head==node && tail==node){
                //No need to do anything
                return;
            }
            if(head==node){
                return;
            }

            if(tail==node){
                tail=tail.prev;
            }

            if(node.prev!=null){
                node.prev.next=node.next;
            }
            
            if(node.next!=null){
                node.next.prev=node.prev;
            }
            

            node.prev=null;
            //node.next=null;

            node.next=head;

            if(head!=null){
                head.prev=node;
                head=node;
            }else{ // I dont think this case will arise
                head=node;
                tail=node;
            }
            return;
        }

        node=new Node(value,key);
        if(cache.size()<capacity){
            // If capacity not exceeded, add at head
            if(head!=null){
                node.next=head;
                head.prev=node;
                head=node;
            } else{
                head=node;
                tail=node;
            }          
            
            cache.put(key,node);  
        }else{
            // If capacity exceeded, remove from tail and add at head
            Node toBeRemovedTail=tail;

            
            
            if(head==tail){
                head=null;
                //tail=null //this will be done eventually down
            }

            tail=tail.prev;

            if(tail!=null){// If only 1 capacity and head, tail points to one node only
                tail.next=null;
            }
            
            toBeRemovedTail.prev=null;

            cache.remove(toBeRemovedTail.key); 

            if(head!=null){
                node.next=head;
                head.prev=node;
                head=node;
            } else{
                head=node;
                tail=node;
            }          
            
            cache.put(key,node);        
        }
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("Value: " + temp.value + " Key: " + temp.key + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



// Initial code
// class LRUCache {

//     public class Node { 
//         int data; 
//         Node prev; 
//         Node next; 
    
//         public Node(int data) 
//         { 
//             this.data = data; 
//             this.prev = null; 
//             this.next = null; 
//         } 
//     } 

//     int capacity;
//     int minimumUsed;
//     HashMap<Integer,Integer> cache;


//     public LRUCache(int capacity) {
//         this.capacity=capacity;
//         this.minimumUsed=0;

//         cache=new HashMap<>();
//     }
    
//     public int get(int key) {
//         return cache.getOrDefault(key,-1);
//     }

//     // A,B,C,D
//     // 1,2,1,3

//     // 1->[A,C]
//     // 2->[B]
//     // 3->[D]
//     // this required maintaining current capacity variable

    
//     public void put(int key, int value) {
//         if(cache.size()<capacity){
//             cache.put(key,cache.getOrDefault(key,0)+value);
//         }else{

//         }
//     }
// }

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */