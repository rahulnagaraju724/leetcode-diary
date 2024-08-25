/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        //138. Copy List with Random Pointer

        if(head==null){
            return null;
        }

        HashMap<Node,Node> map=new HashMap<>();
        Node copyList=new Node(0);
        Node copyListCurr=copyList;

        Node curr=head;

        while(curr!=null){

            if(map.containsKey(curr)){
                Node node=map.get(curr);
                copyListCurr.next=node;

                if(curr.random!=null){
                    Node randomNode=null;
                    if(map.containsKey(curr.random)){
                        randomNode=map.get(curr.random);
                    }else{
                        randomNode=new Node(curr.random.val);
                        map.put(curr.random,randomNode);
                    }
                    node.random=randomNode;
                }

                map.put(curr,node);// again updating is V.IMP

            }else{
                Node newNode=new Node(curr.val);
                map.put(curr,newNode); // V.IMP for only one node ex: [[-1,0]]

                if(curr.random!=null){
                    Node randomNode=null;
                    if(map.containsKey(curr.random)){
                        randomNode=map.get(curr.random);
                    }else{
                        randomNode=new Node(curr.random.val);
                        map.put(curr.random,randomNode);
                    }
                    newNode.random=randomNode;
                }


                copyListCurr.next=newNode;
                map.put(curr,newNode);
            }

            copyListCurr=copyListCurr.next;
            curr=curr.next;
        } 
        
        return copyList.next;
    }
}