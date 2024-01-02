public class BaseProblem {
    public static void main(String[] args) {
//        프로그래머스 문제 3진법 뒤집기
        int n = 125;
        int answer = 0;
        String temp = "";

        while (n > 0){
            temp += Integer.toString(n % 3);
            n /= 3;
        }

        int temp_length = temp.length()-1;

        for(int i =0; i< temp_length; i++){
            answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * (int)Math.pow(3, temp_length);
            temp_length--;
        }

        System.out.println(answer);
    }
}
