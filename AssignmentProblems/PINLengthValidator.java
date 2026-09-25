public class PINLengthValidator {
    public static void main(String[] args) {
        // Test sample inputs
        checkPinLength("482");
        checkPinLength("4820");
    }

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println(pin + " = Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println(pin + " = PIN length OK.");
        }
    }
}