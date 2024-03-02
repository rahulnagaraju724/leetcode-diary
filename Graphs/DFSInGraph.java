import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// Dis-connected graphs
public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge:edges){
            Integer a=edge.get(0);
            Integer b=edge.get(1);
            //System.out.println("Printing edge: "+a+" :"+b);
            adj.get(a).add(b);
            adj.get(b).add(a);

            // This is wrong
            // adj.add(a,b);
            // adj.add(b,a);
        }

//         // System.out.println("Printing before adj");
//         // for (List<Integer> innerList : adj) {
//         //     for (Integer element : innerList) {
//         //         System.out.print(element + ", ");
//         //     }
//         //     System.out.println(); // Print a new line after printing each inner ArrayList
//         // }
//         // System.out.println("Printing after adj");

        
        boolean[] visited=new boolean[v];

        Stack<Integer> stack=new Stack<>();

        ArrayList<ArrayList<Integer>> dfs=new ArrayList<>(); // Dis-connected graphs


        for(int k=0;k<visited.length;k++){

            ArrayList<Integer> dfsTraversal=new ArrayList<>();

            if(visited[k]==false){
                stack.push(k);
                visited[k]=true;
                dfsTraversal.add(k);
            }
            
            while(!stack.isEmpty()){
                Integer node=stack.peek();
                boolean end=true;
                for(Integer i: adj.get(node)){
                    if(visited[i]==false){
                        dfsTraversal.add(i);
                        visited[i]=true;
                        stack.push(i);
                        end=false;
                        break;
                    }
                
                }
                if(end==true){
                    stack.pop();
                }
            }//end while

            //dfs.add(dfsTraversal);
            if(dfsTraversal.size()>0){ // Bcz if an element is already visited, it adds empty dfsTraversal to DFS
                dfs.add(dfsTraversal);
            }

        }//end for

        // // Print each ArrayList on a new line
        // System.out.println("Printing dfs");
        // for (ArrayList<Integer> list : dfs) {
        //     for (Integer element : list) {
        //         System.out.print(element + " ");
        //     }
        //     System.out.println(); // Move to the next line after printing all elements of the current ArrayList
        // }
        // System.out.println("After print dfs");

        return dfs;
    }
}




// //Not this solution
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Stack;

// public class Solution {
//     public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
//         // Write your code here.

//         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<v;i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(ArrayList<Integer> edge:edges){
//             Integer a=edge.get(0);
//             Integer b=edge.get(1);
//             //System.out.println("Printring edge: "+a+" :"+b);
//             adj.get(a).add(b);
//             adj.get(b).add(a);
//             // adj.add(a,b);
//             // adj.add(b,a);
//         }

//         // System.out.println("Printing before adj");
//         // for (List<Integer> innerList : adj) {
//         //     for (Integer element : innerList) {
//         //         System.out.print(element + ", ");
//         //     }
//         //     System.out.println(); // Print a new line after printing each inner ArrayList
//         // }
//         // System.out.println("Printing after adj");

//         ArrayList<Integer> dfsTraversal=new ArrayList<>();
//         boolean[] visited=new boolean[v];

//         Stack<Integer> stack=new Stack<>();

//         stack.push(0);
//         visited[0]=true;
//         dfsTraversal.add(0);

//         while(!stack.isEmpty()){
//             Integer node=stack.peek();
//             boolean end=true;
//             for(Integer i: adj.get(node)){
//                 if(visited[i]==false){
//                     dfsTraversal.add(i);
//                     visited[i]=true;
//                     stack.push(i);
//                     end=false;
//                     break;
//                 }
               
//             }
//             if(end==true){
//                 stack.pop();
//             }
//         }

//         System.out.println("Printing before dfs");
//         dfsTraversal.forEach(System.out::print);
//         System.out.println("Printing after dfs");

//         return adj;
//     }
// }
