import java.util.Arrays;

public class Day02_array {
    public static void main(String[] args) throws Exception {
        // int x = 0;
        // int y = 0;
        // int max = 0;

        // x = 100;
        // y = 200;
        // getMax(x, y);

        // x = 789;
        // y = 358;
        // getMax(x, y);

        // 함수를 이용해 다음 조건을 만족하는 static 함수를 선언하시오.
        // 70점 이상인 학생만의 합계
        // 전체 학생의 평균을 구하는 함수를 작성

        int kors[] = { 78, 65, 49, 88, 94, 92, 68 };

        getSum(kors);
        getArg(kors);

    }// main

    // 70점 이상인 학생 합계

    static void getSum(int[] args) {
        int sum = 0;
        sum = Arrays.stream(args).filter(score -> score >= 70).sum();
        // for (int i = 0; i < args.length; i++) {
        // // if (args[i] >= 70) {
        // // sum = Arrays.stream(args).sum(); // 요소 총합
        // // sum += args[i]; // 70이상 합

        // // }

        // }
        System.out.println("합계 : " + sum);

    }

    // 전체 평균

    static void getArg(int args[]) {

        double average = Arrays.stream(args).average().orElse(0);
        System.out.println("평균 : " + (String.format("%.2f", average)));

    }

    // static int getMax(int gx, int gy) {
    // int max = gx;
    // if (gx > max)

    // max = gy;

    // }
    // return max;
    // }

}
