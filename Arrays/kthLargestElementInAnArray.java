class Solution {
    public int findKthLargest(int[] nums, int k) {
        //215. Kth Largest Element in an Array
        // Here we add all elements to heap and remove k times to get kth highest element
        // In java, default it's Min Heap -> top element is smallest
        // We want minimum elements to be removed, hence we implement Max Heap
        // Question of improvement - depending on k and nums.length...
        // can we say to implement either min or max heap?
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pQueue.add(nums[i]);
        }

        Iterator<Integer> itr = pQueue.iterator();
 
        while (itr.hasNext())
            System.out.println(itr.next());

        int integer=0;
        for(int i=0;i<k;i++){
            integer=pQueue.poll();
        }
        return integer;
    }
}

// More optimised
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++){
            pQueue.add(nums[i]);
        }

        // Iterator<Integer> itr = pQueue.iterator();
 
        // while (itr.hasNext())
        //     System.out.println(itr.next());

        for(int i=k;i<nums.length;i++){
            if(pQueue.peek()<nums[i]){
                pQueue.poll();
                pQueue.add(nums[i]);
            }
            
        }
        return pQueue.peek();
    }
}