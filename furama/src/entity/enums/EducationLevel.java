package entity.enums;

public enum EducationLevel {
    INTERMEDIATE("Trung cấp"),
    COLLEGE("Cao đẳng"),
    UNIVERSITY("Đại học"),
    POSTGRADUATE("Sau đại học");

    private final String displayName;

    EducationLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
