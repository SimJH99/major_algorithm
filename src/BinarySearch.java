public class BinarySearch {
    public static void main(String[] args) {
        //정렬이 되어있어야 이분 탐색 가능
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int start = 0;
        int end = arr.length-1;

        int find = 5;

        int answer = 0;

        while (start <= end){
            int middle = (start + end) / 2;
            if(find == arr[middle]){
                answer = middle;
                System.out.println(answer);
                break;
            }

            if(arr[middle] > find){
                end = middle-1;
            }else if(arr[middle] < find){
                start = middle+1;
            }
        }
    }
}
