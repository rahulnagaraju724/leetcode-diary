import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        // System.out.println("Printing before edges");
        // for (int[] edge : edges) {
        //     for (int i = 0; i < edge.length; i++) {
        //         System.out.print(edge[i]);
        //         if (i < edge.length - 1) {
        //             System.out.print(" "); // Print space between elements
        //         }
        //     }
        //     System.out.println(); // Move to the next line after printing each array
        // }
        // System.out.println("Printing after edges");

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            //System.out.println("Printing edge: "+u+" :"+v);
            
            // This is wrong
            // adj.set(u,adj.get(u).add(v));
            // adj.set(v,adj.get(v).add(u));

            adj.get(u).add(v); // Add v to the list at index u
            adj.get(v).add(u); // Add u to the list at index v
        }

        // System.out.println("Printing before adj");
        // for (List<Integer> innerList : adj) {
        //     for (Integer element : innerList) {
        //         System.out.print(element + ", ");
        //     }
        //     System.out.println(); // Print a new line after printing each inner ArrayList
        // }
        // System.out.println("Printing after adj");
        

        boolean[] visited = new boolean[n+1];

        //Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Stack<Pair<Integer, Integer>> stack=new Stack<>();

        for(int k=0;k<visited.length;k++){

            // visited[0]=true;// Set 0 as true, as it is one based

            // queue.offer(new Pair<>(1,1));
            // visited[1]=true;
            if(visited[k]==false){
                visited[k]=true;
                //queue.offer(new Pair<>(k,k));
                stack.push(new Pair<>(k,k));
            }

            // while(! queue.isEmpty()){
            //     Pair<Integer,Integer> pair=queue.poll();
            //     int element=pair.getFirst();
                
            //     for(int i=0;i<adj.get(element).size();i++){
            //         int next=adj.get(element).get(i);
            //         if(visited[next]==false){
            //             queue.offer(new Pair<>(next,element));
            //             visited[next]=true;
            //         }
            //         else if(visited[next]==true && pair.getSecond()!=next){
            //             System.out.println("Priting Yes here:"+next+" "+ element+" Parent"+pair.getSecond() );
            //             return "Yes";
            //         }
                    
            //     }
            // }

            while(!stack.isEmpty()){
                Pair<Integer,Integer> pair=stack.peek();
                int element=pair.getFirst();
                boolean end=true;

                for(int i=0;i<adj.get(element).size();i++){
                    int next=adj.get(element).get(i);
                    if(visited[next]==false){
                        stack.push(new Pair<>(next,element));
                        visited[next]=true;
                        end=false;
                        break;
                    }
                    else if(visited[next]==true && pair.getSecond()!=next){
                        // Wrong DFS because 3 is already visited and not a parent of 2
                        //System.out.println("Priting Yes here:"+next+" "+ element+" Parent"+pair.getSecond() );
                        return "Yes";
                    }
                    
                }                

                if(end==true){
                    stack.pop();
                }
            }//end while

        }

        return "No";

    }

    public static void main(String[] args) {
        int[][] edges = { {1, 2}, {2, 3}, {3, 4}, {4, 1} }; // Example edges
        //int[][] edges = { {1,2},{2,3},{3,4} }; // Example edges
        int n = 4; // Number of vertices
        int m = edges.length; // Number of edges

        String result = cycleDetection(edges, n, m);
        System.out.println("Cycle Detected: " + result);
    }
    
}