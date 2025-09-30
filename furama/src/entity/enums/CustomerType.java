package entity.enums;

public enum CustomerType {
    DIAMOND("Diamond"),
    PLATINUM("Platinum"),
    GOLD("Gold"),
    SILVER("Silver"),
    MEMBER("Member");

    private final String displayName;

    CustomerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
