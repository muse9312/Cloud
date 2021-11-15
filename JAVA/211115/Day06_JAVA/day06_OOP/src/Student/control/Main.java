package Student.control;

import Student.entity.Student;

public class Main {
    public static void main(String[] args) throws Exception {
        Student student = new Student();

        student.setNO(1);
        student.setName("홍길동");
        student.setKor(25);
        student.setEng(34);
        student.setMeth(56);
        student.sum();

        Student student2 = new Student();

        student2.setNO(2);
        student2.setName("김길동");
        student2.setKor(56);
        student2.setEng(78);
        student2.setMeth(34);
        student2.sum();

        Student student3 = new Student();

        student3.setNO(3);
        student3.setName("이길동");
        student3.setKor(78);
        student3.setEng(56);
        student3.setMeth(78);
        student3.sum();

        Student student4 = new Student();

        student4.setNO(4);
        student4.setName("박길동");
        student4.setKor(96);
        student4.setEng(89);
        student4.setMeth(87);
        student4.sum();

        Student student5 = new Student();

        student5.setNO(5);
        student5.setName("최길동");
        student5.setKor(78);
        student5.setEng(56);
        student5.setMeth(89);
        student5.sum();

        Student student6 = new Student();

        student6.setNO(6);
        student6.setName("한길동");
        student6.setKor(89);
        student6.setEng(56);
        student6.setMeth(66);
        student6.sum();

        System.out.printf("학번\t이름\t국어\t영어\t수학\t총점\n");

        System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d \n", student.getNO(), student.getName(), student.getKor(),
                student.getEng(), student.getMeth(), student.getSum());
        System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d \n", student2.getNO(), student2.getName(), student2.getKor(),
                student2.getEng(), student2.getMeth(), student2.getSum());
        System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d \n", student3.getNO(), student3.getName(), student3.getKor(),
                student3.getEng(), student3.getMeth(), student3.getSum());
        System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d \n", student4.getNO(), student4.getName(), student4.getKor(),
                student4.getEng(), student4.getMeth(), student4.getSum());
        System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d \n", student5.getNO(), student5.getName(), student5.getKor(),
                student5.getEng(), student5.getMeth(), student5.getSum());
        System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d \n", student6.getNO(), student6.getName(), student6.getKor(),
                student6.getEng(), student6.getMeth(), student6.getSum());
    }

}
