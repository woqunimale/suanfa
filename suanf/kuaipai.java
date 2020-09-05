package suanf;

public class kuaipai {
    private static void kp(int[] arr, int left, int right) {
        int p = (left + right)/2;
        int jizhunzhi = arr[p];
        int l = left;
        int r = right;
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
        if(p-left > 1){
            kp(arr,left,p-1);
        }
        if(right - p > 1){
            kp(arr,p+1,right);
        }
    }

    public static void main(String[] args) {
        int[] brr = {1,4,2,7,2,7,4,8,5,9,99};
        kp(brr,0,brr.length-1);
        for(int i = 0;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
    }
}