import java.util.Arrays;

public class ReverseOdd {
    /*1,6,4,3,7,8 => 7,6,4,3,1,8
    * solution: use two pointers i and j, which is the first odd number at two end
    * swap them once both of them found an odd number
    * time:O(n) space:O(1)
    * */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,6,4,3,7,8};
        int[] arr2 = new int[]{1,3};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{2,4,6,8};
        System.out.println(Arrays.toString(reverseOdd(arr1)));
        System.out.println(Arrays.toString(reverseOdd(arr2)));
        System.out.println(Arrays.toString(reverseOdd(arr3)));
        System.out.println(Arrays.toString(reverseOdd(arr4)));
    }
    public static int[] reverseOdd(int[] arr){
        //base and corner case
        if(arr == null || arr.length == 0){
            return arr;
        }
        int i = 0;
        int j = arr.length - 1;
        while(i <= j){
            while(i < j && arr[i] %2 == 0){
                i++;
            }
            if(i >= j){
                break;
            }
            while(j > i && arr[j]%2 == 0){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(arr,i, j);
            i++;
            j--;
        }
        return arr;
    }
    private static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
