package sample.controller.config;

public enum Difficulties {
    EASY (300),
    MEDIUM (100),
    HARD (25);

    private int startingMoney;

    Difficulties(int startingMoney) {
        this.startingMoney = startingMoney;
    }

    public int getStartingMoney() {
        return startingMoney;
    }
}
