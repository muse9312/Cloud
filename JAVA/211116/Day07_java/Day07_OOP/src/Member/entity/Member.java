package Member.entity;

public class Member {
    private int MemberId;
    private String memberName;
    private String registeredDate;
    private int noOfPurchase;
    private int point;
    private String grade;

    public Member() {
        calculatePoint();
        calculateGrade();
    }

    public Member(int memberId, String memberName, String registeredDate, int noOfPurchase) {
        this.MemberId = memberId;
        this.memberName = memberName;
        this.registeredDate = registeredDate;
        this.noOfPurchase = noOfPurchase;
        calculatePoint();
        calculateGrade();
    }

    public int purchase() {
        this.noOfPurchase += 1;
        return this.noOfPurchase;
    }

    public int getPoint() {
        return point;
    }

    public int calculatePoint() {
        // 3회 미만이면 횟수*20, 3회이상이면 횟수*30, 5회이상이면 횟수*50, 10회 이상이면 횟수*100
        int point = 0;
        int portion = 0;

        if (this.noOfPurchase >= 10) {
            portion = 100;
        } else if (this.noOfPurchase >= 5) {
            portion = 50;
        } else if (this.noOfPurchase >= 3) {
            portion = 30;
        } else if (this.noOfPurchase < 3) {
            portion = 20;
        }

        point = this.noOfPurchase * portion;
        this.point = point;
        return point;
    }

    public String getGrade() {
        return grade;
    }

    public void calculateGrade() {
        // 누적 포인트가 100점 미만이면 Family, 100~300이면 Gold, 300~500이면 VIP, 그 이상 VVIP
        String grade = "Family";
        if (this.point > 100 && this.point < 300) {
            grade = "Gold";
        } else if (this.point >= 300 && this.point < 500) {
            grade = "VIP";
        } else if (this.point >= 500) {
            grade = "VVIP";
        }
        this.grade = grade;
    }

    public void showMemberInfo() {
        String year = this.registeredDate.substring(0, 4);
        String month = this.registeredDate.substring(4, 6);
        String date = this.registeredDate.substring(6, 8);
        System.out.println(String.format(" 회원%s 의 등록날짜는 %s년 %s월 %s일 이고, 구매횟수는 %d 번이고, 보유점수는 %d 점이고, 회원등급은 %s 등급이다. ",
                this.MemberId, year, month, date, this.noOfPurchase, this.point, this.grade));
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        MemberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

}
