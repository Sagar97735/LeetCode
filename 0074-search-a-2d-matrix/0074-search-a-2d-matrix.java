class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int start = 0;
        int end = matrix.length-1;
        int mid = 0;
        while(start<=end){
         mid  = (start + end)/2;
         if(matrix[mid][0]<target){
            if(matrix[mid][matrix[0].length-1]>target){
                break;
            }
             if(matrix[mid][matrix[0].length-1]==target){
                return true;
            }
            else{
                start = mid +1;
            }
         }
        else if(matrix[mid][0]>target){
            end = mid -1;
           }
           else{
            return true;
           }
        }
        start = 0;
        int i = mid;
        end = matrix[0].length-1;
        mid = 0;
        while(start<=end){
            mid = (start +end)/2;
            if(matrix[i][mid]<target){
               start = mid+1;
            }
            else if(matrix[i][mid]>target){
                end = mid -1;
            }
            else{
                return true;
            }
        }
        if(matrix[i][mid]==target){
            return true;
        }
        System.out.print(matrix[i][mid]);
        return false;
    }
}