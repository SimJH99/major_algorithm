import java.util.Arrays;

public class GreedyCoinProblem2 {
    public static void main(String[] args) {
//        점화식을 세워라
//        배열에 메모리제이션을 하라 (효율성)

//        1,4,5원 동전이 있을 때, 13원이 되게 하는 최소의 동전의 개수
//        탐욕법 : 5개, 최적의 방법 : 4 + 4 + 5 / 3개
//        12원이 되게하는 최소 동전수, 9원이 되게하는 최소 동전수, 8원이 되게하는 최소 동전수 각 경우에서 coin +1하면 13원이 된다.
//        식 f(n) = min(f(n-a)) : for a in coins) + 1

//        강사님 풀이
        int[] coins = {1,4,5};
        int price = 13;
        int[] memory = new int[price];

        int answer = 0;
        int [] arr = new int[price+1];
        arr[1] = 1;
        for(int i =2; i<= price; i++){
            int min = price;
            for(int c : coins){
                if(i-c <0) continue;
                if(min > arr[i-c]){
                    min = arr[i-c];
                }
            }
            arr[i] = min +1;
        }

        System.out.println(Arrays.toString(arr));

//        나의 풀이
//        memory[0] = 1; // 1원 일때
//        memory[1] = 2; // 2원 일때
//        memory[2] = 3; // 3원 일때
//        memory[3] = 1; // 4원 일때
//        memory[4] = 1; // 5원 일때
//
//        //6원 일때 부터 1원전, 4원전, 5원전 동전 수를 비교
//        for(int i = 6; i<= price; i++){
//            int value = i; // 현재 i원
//
//            int count1 = memory[value-2]; //1원 전에
//            int count4 = memory[value-5]; // 4원 전에
//            int count5 = memory[value-6]; // 5원 전에
//
//            if(count1 < count4 && count1 < count5){ // 1원 전이 동전 수가 작을 때
//                memory[value-1] = count1 + 1;
//            } else if (count4 < count1 && count4 < count5) { // 4원 전이 동전 수가 제일 적을 떄
//                memory[value-1] = count4 + 1;
//            } else if (count5 < count1 && count5 < count4){ // 5원 전이 동전 수가 제일 적을 때
//                memory[value-1] = count5 + 1;
//            } else {    // 초반 5원까지 동전의 수가 1로 동일 할 때,
//                memory[value-1] = count5 + 1;
//            }
//        }
//
//        System.out.println(memory[12]);
    }
}
