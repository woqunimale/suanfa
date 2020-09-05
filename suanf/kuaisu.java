package suanf;

public class kuaisu {
    private static void kuai(int[] arr,int left,int right){
        //先找中间下标
        int p = (left+right)/2;
        //找基准值
        int jizhunzhi = arr[p];
        //判断元素应该放左边还是右边，并且需要给左右两边元素找替身，方便递归确定左右下标
        int l = left;
        int r = right;
        //先确定左右两边都有元素，用下标比较，有元素才可以比较
        for(;l<r;){
            //先确定左边有元素(是否存在下标)，并且左边元素小于基准值
            while (l<p && arr[l] < jizhunzhi){
                l++;
            }
            //反之，左边有元素，并且左边元素大于基准值
            if(l<p){
                //先把值交换
                arr[p] = arr[l];
                //下标交换
                p = l;
            }
            //右边类似，先确定右边有元素(通过下标是否存在)，并且右边元素大于基准值
            while (r>p && arr[r] >= jizhunzhi){
                r--;
            }
            //反之，右边有元素，元素小于基准值
            if(r>p){
                //先交换元素值
                arr[p] = arr[r];
                //交换下标
                p = r;
            }
        }
        //把基准值放到p下标位置
        arr[p] = jizhunzhi;
        //判断左边元素个数是否大于一，有没有必要在递归
        if(p - left > 1){
            kuai(arr,left,p-1);
        }
        //判断右边元素个数是否大于一，有没有必要在递归
        if(right - p > 1){
            kuai(arr,p+1,right);
        }
    }

    public static void main(String[] args) {
        int[] brr = {9,8,7,6,5,4,3,2,1};
        kuai(brr,0,8);
        System.out.print("使用快排的结果是：");
        for(int i = 0;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
    }
}
