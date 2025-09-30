package entity.enums;

public enum Position {
    RECEPTIONIST("Lễ tân"),
    WAITER("Phục vụ"),
    SPECIALIST("Chuyên viên"),
    SUPERVISOR("Giám sát"),
    MANAGER("Quản lý"),
    DIRECTOR("Giám đốc");

    private final String displayName;

    Position(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}