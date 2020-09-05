package suanf;

public class maopao {
    public static void mp(int[] arr){
        for(int i = 1;i<arr.length;i++){
            boolean flag = true;
            for(int j = 0;j<arr.length-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag) break;
        }
    }

    public static void main(String[] args) {
        int[] brr = {1,3,2,5,6,7,83,2,3};
        mp(brr);
        System.out.print("[");
        for(int i  = 0;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
        System.out.print("]");
    }
}
