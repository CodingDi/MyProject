public class MissingBinarySearch {

    //sorted array, from 1-n find the one that is missing from the array
    public int findMissing(int[] arr){
        if(arr == null|| arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(arr[mid] == mid + 1){
                left = mid;
            }else{
                right = mid;
            }
        }
        //post-processing
        if(arr[left] != left + 1){
            return left + 1;
        }
        if(arr[right] != right + 1){
            return right + 1;
        }
        return right + 2;//!!!IMPORTANT
        //0 1 2
        //1 2 3   ->return 4
    }
}
