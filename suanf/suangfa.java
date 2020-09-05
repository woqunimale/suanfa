package suanf;

public class suangfa {
 private static void kp(int[] arr,int left,int right) {
     int p = (left+right)/2;
     int j = arr[p];
     int l = left;
     int r = right;
     for(;l<r;){
         while(l<p && arr[l] <j){
             l++;
         }
         if(l<p){
             arr[p] = arr[l];
             p = l;
         }
         while(r>p && arr[r] >= j){
             r--;
         }
         if(r>p){
             arr[p] = arr[r];
             p = r;
         }

     }
     arr[p] = j;
     if(p-left > 1){
         kp(arr,left,p-1);
     }
     if(right-p > 1){
         kp(arr,p+1,right);
     }
 }

    public static void main(String[] args) {
        int[] brr = {1,5,4,8,2,9,3,8,3};
        kp(brr,0,brr.length-1);
        for(int i = 0 ;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
    }
}
