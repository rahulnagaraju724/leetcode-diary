// class Solution {
//     int i=-1;
//     public int furthestBuilding(int[] heights, int bricks, int ladders) {
//         furthestBuilding(heights, bricks, ladders,0);
//         return i;
//     }

//     public void furthestBuilding(int[] heights, int bricks, int ladders,int index) {
//         if(index==heights.length-1){
//             //return index;
//             i=Math.max(i,index);
//         }
//         if(ladders==0 && bricks==0){
//             //return index;
//             i=Math.max(i,index);
//         }
//         //System.out.println(" index: "+index+" bricks: "+bricks+" ladders: "+ladders);
//         if(index<heights.length-1){
            
//             if(heights[index+1]<=heights[index]){
//                 furthestBuilding(heights, bricks, ladders,index+1);
//             }
//             else{
//                 int toBeJumped=(heights[index+1]-heights[index]);
//                 if(toBeJumped<=bricks){
//                     //System.out.println("Inside here index: "+index);
//                     furthestBuilding(heights, bricks-toBeJumped, ladders,index+1);
//                     if(ladders>0){
//                         //System.out.println("Inside ladder here1 index: "+index);
//                         furthestBuilding(heights, bricks, ladders-1,index+1);
//                     }              
//                 }
//                 else{
//                     if(ladders>0){
//                         //System.out.println("Inside ladder here2 index: "+index);
//                         furthestBuilding(heights, bricks, ladders-1,index+1);
//                     }
//                     else{
//                         i=Math.max(i,index);
//                     }
//                 }
                
//             }
//         }
//     }
// }
class Solution{
public int furthestBuilding(int[] heights, int bricks, int ladders) {\
    //1642. Furthest Building You Can Reach
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	for (int i=0; i<heights.length-1; i++) {
		if (heights[i] >= heights[i+1]) continue;
		bricks -= heights[i+1] - heights[i];
		pq.add(heights[i+1] - heights[i]);

		if (bricks < 0) {
			bricks += pq.poll();
			if (ladders > 0) ladders--;
			else return i;
		}
	}

	return heights.length - 1;
}
}