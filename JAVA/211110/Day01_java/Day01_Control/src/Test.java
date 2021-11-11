public class Test {
    public static void main(String[] args) throws Exception {
        // 문제 2 : 돈이 있으면 택시를 타고가고 돈이 없으면 걸어가라

        boolean money = false;

        if (money) {
            System.out.println("택시타");
        } else {
            System.out.println("걸어가");
        }

        // 문제 2-1 : 돈이랑 카드 중 하나라도 있으면 택시타고 가세요 (논리연산자)

        Boolean money2 = true;
        boolean card = false;

        if (money2 || card) {
            System.out.println("택시타");
        }

        // 문제 3-1 최종점수가 100~90이면 A학점 , 89~80이면 B학점, 79~70 이면 C학점
        int score = 78;

        switch (score / 10) {
        case 10:
        case 9:
            System.out.println("A학점");
            break;
        case 8:
            System.out.println("B학점");
            break;
        case 7:
            System.out.println("C학점");
            break;
        case 6:
            System.out.println("D학점");
            break;
        default:
            System.out.println("F학점");
            break;
        }

    }
}
