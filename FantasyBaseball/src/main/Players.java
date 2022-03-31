package main;

public class Players {
    private String catcher;
    private String firstBaseman;
    private String secondBaseman;
    private String thirdBaseman;
    private String shortStop;
    private String leftFielder;
    private String rightFielder;
    private String centerFielder;
    private String pitcher1, pitcher2, pitcher3, pitcher4, pitcher5;

    public Players(String catcher, String firstBaseman, String secondBaseman, String thirdBaseman, String shortStop, String leftFielder, String rightFielder, String centerFielder, String pitcher1, String pitcher2, String pitcher3, String pitcher4, String pitcher5) {
        this.catcher = catcher;
        this.firstBaseman = firstBaseman;
        this.secondBaseman = secondBaseman;
        this.thirdBaseman = thirdBaseman;
        this.shortStop = shortStop;
        this.leftFielder = leftFielder;
        this.rightFielder = rightFielder;
        this.centerFielder = centerFielder;
        this.pitcher1 = pitcher1;
        this.pitcher2 = pitcher2;
        this.pitcher3 = pitcher3;
        this.pitcher4 = pitcher4;
        this.pitcher5 = pitcher5;
    }



    public Players() {
    }

    public String getCatcher() {
        return catcher;
    }

    public void setCatcher(String catcher) {
        this.catcher = catcher;
    }

    public String getFirstBaseman() {
        return firstBaseman;
    }

    public void setFirstBaseman(String firstBaseman) {
        this.firstBaseman = firstBaseman;
    }

    public String getSecondBaseman() {
        return secondBaseman;
    }

    public void setSecondBaseman(String secondBaseman) {
        this.secondBaseman = secondBaseman;
    }

    public String getThirdBaseman() {
        return thirdBaseman;
    }

    public void setThirdBaseman(String thirdBaseman) {
        this.thirdBaseman = thirdBaseman;
    }

    public String getShortStop() {
        return shortStop;
    }

    public void setShortStop(String shortStop) {
        this.shortStop = shortStop;
    }

    public String getLeftFielder() {
        return leftFielder;
    }

    public void setLeftFielder(String leftFielder) {
        this.leftFielder = leftFielder;
    }

    public String getRightFielder() {
        return rightFielder;
    }

    public void setRightFielder(String rightFielder) {
        this.rightFielder = rightFielder;
    }

    public String getCenterFielder() {
        return centerFielder;
    }

    public void setCenterFielder(String centerFielder) {
        this.centerFielder = centerFielder;
    }

    public String getPitcher1() {
        return pitcher1;
    }

    public void setPitcher1(String pitcher1) {
        this.pitcher1 = pitcher1;
    }

    public String getPitcher2() {
        return pitcher2;
    }

    public void setPitcher2(String pitcher2) {
        this.pitcher2 = pitcher2;
    }

    public String getPitcher3() {
        return pitcher3;
    }

    public void setPitcher3(String pitcher3) {
        this.pitcher3 = pitcher3;
    }

    public String getPitcher4() {
        return pitcher4;
    }

    public void setPitcher4(String pitcher4) {
        this.pitcher4 = pitcher4;
    }

    public String getPitcher5() {
        return pitcher5;
    }

    public void setPitcher5(String pitcher5) {
        this.pitcher5 = pitcher5;
    }
}
