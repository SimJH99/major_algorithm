public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int amount = 99;
//        최소 동전의 개수 산출
        int count = 0;
        int price = amount;

        int count25 = amount / 25;  // 3개 24원
        int price25 = amount - (coins[3] * count25);

        int count10 = price25 / 10; // 2개 4원
        int price10 = price25 - (coins[2] * count10);

        int count5 = price10 / 5;   // 0개 4원
        int price5 = price10 - (coins[1] * count5);

        int count1 = price5 / 1;    // 4개 0원
        int price1 = price5 - (coins[0] * count1);

        count = count25 + count10 + count5 + count1;

        System.out.println(count);
    }
}
