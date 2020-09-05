package suanfas;

public class maopao {
    private static void mp(int[] arr){
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
        int[] brr = {1,2,65,4,3,7,5,3,4,5};
        mp(brr);
        for(int i = 0;i<brr.length;i++){
            System.out.print(brr[i]+" ");
        }
    }
}
