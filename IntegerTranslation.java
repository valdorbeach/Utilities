public class IntegerTranslation {

    private static final String[] SPECIAL       = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] INTEGERS_MAP  = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TEENS_MAP     = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String   ZERO          = "zero";

    public static String ConvertIntegerToWords (int input) {
        String answer = "";

        // we only accept numbers from 0-999
        if (input >= 0 && input < 1000 ) {
            if (input == 0) {
                answer = ZERO;
            } else {
                // handle the first two digits
                int digits    = input  % 100;
                int onesDigit = digits % 10;

                if (digits > 9 && digits < 20) {
                    // this is the special case where input ends with 10, 11, 12, ..., 19
                    answer = SPECIAL[onesDigit];
                } else {
                    if (onesDigit != 0) {
                        answer = INTEGERS_MAP[onesDigit];
                    }
                    // isolate the digit in the tens position
                    digits = digits / 10;
                    if (digits != 0) {
                        answer = TEENS_MAP[digits] + " " + answer;
                    }
                }

                // handle the case where input > 99
                digits = input / 100;
                if (digits != 0) {
                    answer = INTEGERS_MAP[digits] + " hundred " + answer;
                }
            }
        }
        return answer;
    }

    public static void main (String[] args) {

        int testNumbers[] = {0, 1, 7, 10, 13, 17, 20, 24, 37, 50, 60, 74, 100, 110, 113, 200, 250, 261, 900, 901, 913, 919, 920, 999};

        for (int i = 0; i < testNumbers.length; i++) {

            System.out.println(testNumbers[i] + " = " + ConvertIntegerToWords(testNumbers[i]));
        }
    }
}
