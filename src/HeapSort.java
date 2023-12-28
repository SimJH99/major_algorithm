import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,7};
        int n = arr.length;
//        최초 힙구성 : n / 2번 만큼 heapify수행
        for (int i = arr.length/2-1; i >= 0  ; i--){
            heapify(arr, arr.length, i);
        }

        //최초 힙구성 이후에 최대(root노드)힙과 마지막 노드와 change
        for(int i = 0; i < n; i++){
            int temp = arr[0];
            arr[0] = arr[n-1-i];
            arr[n-1-i] = temp;
            heapify(arr, n-1-i ,0);
        }
        System.out.println(Arrays.toString(arr));

    }

    static void heapify(int[] arr,int length ,int root){
//        xx조건의 경우에 change로직 : left와 right비교해서 자리 change
        int max_index = root;
        int left = root*2 + 1;
        int right = root*2 + 2;
        if(left<length && arr[max_index] < arr[left]){
            max_index = left;
        }
        if(right<length && arr[max_index] < arr[right]){
            max_index = right;
        }
        if(max_index != root){
            int temp = arr[root];
            arr[root] = arr[max_index];
            arr[max_index] = temp;
            heapify(arr,length, max_index);
        }
    }

//    static  void heapify(int[] arr,int length, int root){
////        xx조건의 경우에 change로직 : left 와 right 비교해서 자리 change
////        &&로 비교할 때, 자식 노드가 arr.length+1 보다 크면 안된다. 재귀가 종료되는 로직 작성
//        int maxIndex = root;
//        int leftIndex = (2*root)+1;
//        int rightIndex = (2*root)+2;
//
//
//        //최대 깊이 체크
//        if(leftIndex > length || rightIndex > length){
//            return;
//        }
//            //부모노드와 자식노드를 비교해 부모가 자식보다 작으면 위치 체인지
//            //두 자식노드의 수를 비교해 둘 중에 더 큰 값을 부모와 비교
//        if(arr[leftIndex] > arr[rightIndex]){//왼쪽이 오른쪽 값보다 클 때, 부모노드와 왼쪽 자식노드의 값 체인지
//            int rootNum = arr[root];
//            int leftNum = arr[leftIndex];
//            int maxValue = leftNum;
//            if (maxValue > rootNum){
//                int temp = 0;
//                temp = arr[root];
//                arr[root] = arr[leftIndex];
//                arr[leftIndex] = temp;
//                heapify(arr,length,leftIndex);
//            }
//        } else if(arr[leftIndex] < arr[rightIndex]){//오른쪽이 왼쪽 값보다 크거나 같을 때, 부모노드와 오른쪽 자식노드의 값 체인지
//            int rootNum = arr[root];
//            int rightNum = arr[rightIndex];
//            int maxValue = rightNum;
//            if (maxValue > rootNum){
//                int temp = 0;
//                temp = arr[root];
//                arr[root] = arr[rightIndex];
//                arr[rightIndex] = temp;
//                heapify(arr,length,rightIndex);
//            }
//        }
//
//    }
}
