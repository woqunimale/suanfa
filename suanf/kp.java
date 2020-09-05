package suanf;

public class kp {
    private static void kp(int[] arr,int left,int right){
        int p = (left+right)/2;
        int l = left;
        int r = right;
        int jizhunzhi = arr[p];
        for(;l<r;){
            while(l<p && arr[l] < jizhunzhi){
                l++;
            }
            if(l<p){
                arr[p] = arr[l];
                p = l;
            }
            while(r>p && arr[r] >= jizhunzhi){
                r--;
            }
            if(r>p){
                arr[p] = arr[r];
                p = r;
            }
        }
        arr[p] = jizhunzhi;
        if(p - left > 1){
            kp(arr,left,p-1);
        }
        if(right - p > 1){
            kp(arr,p+1,right);
        }
    }

    public static void main(String[] args) {
        int[] brr = {8,7,6,5,49,43,12,1};
        kp(brr,0,brr.length-1);
        System.out.print("[");
        for(int i = 0;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
        System.out.print("]");
    }
}