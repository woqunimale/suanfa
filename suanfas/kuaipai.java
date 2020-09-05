package suanfas;

public class kuaipai {
    private static void kp(int[] arr,int left,int right){
        int p = (left+right)/2;
        int jizhunzhi = arr[p];
        int l = left;
        int r = right;
        for(;l<r;){
            while(l<p && arr[l] <jizhunzhi){
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
        if(right-p>1){
            kp(arr,p+1,right);
        }
    }

    public static void main(String[] args) {
        int[] brr = {1,5,2,7,4,8,4,8,4,9,6,3,2};
        kp(brr,0,12);
        for(int i = 0;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
    }
}
