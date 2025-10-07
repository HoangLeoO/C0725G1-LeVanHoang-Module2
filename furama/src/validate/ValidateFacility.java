package validate;

public class ValidateFacility {
    private static final String SERVICE_CODE = "^SV(VL|HO|RO)-\\d{4}$";
    private static final String SERVICE_NAME = "^[A-Z][a-z]*(\\s*[A-Z][a-z]*)*$";
    private static final String AREA = "^\\d+(\\.\\d+)?$";
    private static final String PRICE = "^\\d+(\\.\\d+)?$";
    private static final String NUMBER_PEOPLE = "^[1-9]\\d*$";   // ít nhất 1
    private static final String NUMBER_FLOORS = "^[1-9]\\d*$";   // ít nhất 1

    // ---- Service code ----
    public static boolean isValidServiceCode(String code) {
        return code != null && code.matches(SERVICE_CODE);
    }

    // ---- Service name ----
    public static boolean isValidServiceName(String name) {
        return name != null && name.matches(SERVICE_NAME);
    }

    // ---- Area (phải > 30) ----
    public static boolean isValidArea(String area) {
        if (area == null || !area.matches(AREA)) {
            return false;
        }
        double value = Double.parseDouble(area);
        return value > 30;
    }

    // ---- Price (phải > 0) ----
    public static boolean isValidPrice(String price) {
        if (price == null || !price.matches(PRICE)) {
            return false;
        }
        double value = Double.parseDouble(price);
        return value > 0;
    }

    // ---- Number of people ----
    public static boolean isValidNumberPeople(String number) {
        return number != null && number.matches(NUMBER_PEOPLE);
    }

    // ---- Number of floors ----
    public static boolean isValidNumberFloors(String number) {
        return number != null && number.matches(NUMBER_FLOORS);
    }
}
