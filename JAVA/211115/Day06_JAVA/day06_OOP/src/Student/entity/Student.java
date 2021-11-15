package Student.entity;

public class Student {

    public Student() {

    }

    int NO;
    String Name;
    int Kor;
    int Eng;
    int Meth;
    int Sum;

    public int getNO() {
        return this.NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getKor() {
        return this.Kor;
    }

    public void setKor(int Kor) {
        this.Kor = Kor;
    }

    public int getEng() {
        return this.Eng;
    }

    public void setEng(int Eng) {
        this.Eng = Eng;
    }

    public int getMeth() {
        return this.Meth;
    }

    public void setMeth(int Meth) {
        this.Meth = Meth;
    }

    public int getSum() {
        return this.Sum;
    }

    public void setSum(int Sum) {
        this.Sum = Sum;
    }

    public void sum() {
        this.Sum = Kor + Eng + Meth;
    }

}
