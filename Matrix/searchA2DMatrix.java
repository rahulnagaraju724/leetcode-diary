// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         //74. Search a 2D Matrix

//         int m=matrix.length;
//         int n=matrix[0].length;
//         int topRow=0;
//         int bottomRow=matrix.length-1;
//         // int leftCol=0;
//         // int rightCol=matrix[0].length-1;

//         while(topRow<=bottomRow){
//             int middleRow=topRow+(bottomRow-topRow)/2;
//             if( target>= matrix[middleRow][0] && target<=matrix[middleRow][n-1]){
//                 int left=0;
//                 int right=n-1;
//                 while(left<=right){
//                     int middle=left+(right-left)/2;
//                     if(target==matrix[middleRow][middle]){
//                         return true;
//                     }
//                     if(target>matrix[middleRow][middle]){
//                         left=middle+1;
//                     }else{
//                         right=middle-1;
//                     }
//                 }
//             }
//             if(target< matrix[middleRow][0]){
//                 bottomRow=middleRow-1;
//             }else{
//                 topRow=middleRow+1;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}