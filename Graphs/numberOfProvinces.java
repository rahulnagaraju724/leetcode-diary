// Basically it's finding number of connected components
class Solution {
    public int findCircleNum(int[][] isConnected) {
        //547. Number of Provinces
        int n = isConnected.length;
        boolean visited[]=new boolean[n];

        int result=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    if(visited[i]==false && visited[j]==false){
                        visited[i]=true;
                        visited[j]=true;
                        findOthers(isConnected,i,n,visited,0);
                        findOthers(isConnected,j,n,visited,0);
                        result++;
                    }
                }
            }//end for j
        }//end for i

        if(result==0){
            return n;
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                result++;
            }
        }
        return result;
    }

    public void findOthers(int[][] isConnected,int checkCol,int n,boolean[] visited,int count){
        for(int row=0;row<n;row++){
            if(isConnected[row][checkCol]==1 && row!=checkCol && visited[row]==false){
                visited[row]=true;
                findOthers(isConnected,row,n,visited,count);
            }
        }
        return;
    }
    
}