public class Main2 {
    public static void main(String[] args) throws Exception {
        // Data 준비 = 변수
        int x = 10; // integer : 정수, 4byte
        int y = 20;

        int z = x + y;

        System.out.println("z = " + z);

        // 문제 1) 주머니에 3000이상이면, 택시를 타고 돈도없고 카드도 없으면 걸어가라

        int money = 2000;
        boolean card = true;

        if (money >= 3000 || card) {
            System.out.println("택시타");
        } else if (money <= 3000 || !card) {
            System.out.println("걸어가");
        }

    }
}
