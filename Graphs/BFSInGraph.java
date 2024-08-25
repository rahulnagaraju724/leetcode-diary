import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        List<Integer> bfsTraversal=new ArrayList<>();
        boolean[] visited=new boolean[n];

        Queue<Integer> queue=new LinkedList<>();

        queue.offer(0);
        visited[0]=true;

        while(!queue.isEmpty()){
            Integer node=queue.poll();
            bfsTraversal.add(node);

            for(Integer i: adj.get(node)){
                if(visited[i]==false){
                    visited[i]=true;
                    queue.offer(i);
                }
               
            }
        }

        return bfsTraversal;
    }
}

