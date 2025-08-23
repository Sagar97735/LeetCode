class Solution {
    public int minimumSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        return cal(grid,3,0,n-1,0,m-1);
    }
    int cal(int[][] grid,int parts,int u,int d,int l,int r){
        if(u>d||l>r)return 0;
        if(parts==1){
            return minRect(grid,u,d,l,r);
        }
        // horizontal
        int ans=10000000;
        for(int i=u;i<=d;i++){
            for(int x=1;x<parts;x++){
                ans=Math.min(ans,cal(grid,x,u,i,l,r)+cal(grid,parts-x,i+1,d,l,r));
            }
        }
        // vertical
        for(int i=l;i<=r;i++){
            for(int x=1;x<parts;x++){
                ans=Math.min(ans,cal(grid,x,u,d,l,i)+cal(grid,parts-x,u,d,i+1,r));
            }
        }
        return ans;
    }
    int minRect(int[][] grid,int u,int d,int l,int r){
        int xl=r;
        int xr=l;
        int yu=d;
        int yd=u;
        boolean found=false;
        for(int i=u;i<=d;i++){
            for(int j=l;j<=r;j++){
                if(grid[i][j]==1){
                    found=true;
                    xl=Math.min(xl,j);
                    xr=Math.max(xr,j);
                    yu=Math.min(yu,i);
                    yd=Math.max(yd,i);
                }
            }
        }
        if(!found)return 0;
        return (xr-xl+1)*(yd-yu+1);
    }
}
// 000
// 000
// 001
// 110