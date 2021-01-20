import java.math.BigInteger;
import java.util.regex.Pattern;

public class Tasks {
    StringBuilder sb;
    public final static String REGEX_FOR_HEX = "^\\p{XDigit}+$";
    public final static String REGEX_FOR_PH_NUMBER = "^(\\+\\d{1,4}( )?)?((\\(\\d{1,3}\\))( )\\d{3})(-)?\\d{2}(-)?\\d{2}$";

    //Task 1
    public int[] sortArrayUsingBubbleSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        if (array.length < 2) {
            return new int[0];
        }
        int numberCounter, number, saveNumber;
        for (numberCounter = 0; numberCounter < array.length; numberCounter++) {
            for (number = 0; number < array.length - numberCounter - 1; number++) {
                if (array[number] > array[number + 1]) {
                    saveNumber = array[number];
                    array[number] = array[number + 1];
                    array[number + 1] = saveNumber;
                }
            }
        }
        return array;
    }

    //Task2
    public int searchNumberUsingBinaryMethod1(int[] array, int number) {
        if (array.length < 1) {
            return 0;
        }
        array = sortArrayUsingBubbleSort(array);
        int start = 0, end = array.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == number) {
                return array[mid];
            }
            if (array[mid] < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return array[mid] > number ? array[mid - 1] : array[mid + 1];
    }
    public int searchNumberUsingBinary(int[] array, int number) {
        if (array.length < 1) {
            return 0;
        }
        array = sortArrayUsingBubbleSort(array);
        int start = 0, end = array.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == number) {
                return mid;
            }
            if (array[mid] < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    //Task3
    public int [] searchNumberUsingBinaryMethod2(int[] array, int number) {
        int[] resultArray = new int[2];
        resultArray[0] = searchNumberUsingBinary(array, number);
        if (resultArray[0] == -1) {
            resultArray = new int[2];
            return resultArray;
        }
        array = sortArrayUsingBubbleSort(array);
        if (array[resultArray[0]] != number) {
            resultArray = new int[2];
            return resultArray;
        }
        int count = 1;
        while (array[resultArray[0]] == array[resultArray[0] + count]) {
            count++;
            resultArray[1] = resultArray[0] + count;
        }
        return resultArray;
    }

    private String convertNumberToBinaryString(long number) {
        String str = Long.toBinaryString(number);
        if (str.length() <= 7) {
            int length = 7 - str.length();
            for (int i = 0; i < length; i++)
                sb.insert(0, 0);
        }
        return str;
    }

    //Task4
    public boolean isAllBitsSelected(long number, byte[] bitPositions) {
        String str = convertNumberToBinaryString(number);
        sb = new StringBuilder(str);
        for (int i = 0; i < bitPositions.length; i++) {
            if (sb.charAt(bitPositions[i]) != 49) {
                return false;
            }
        }
        return true;
    }

    //Task5
    public boolean isAnyBitSelected(long number, byte[] bitPositions) {
        String str = convertNumberToBinaryString(number);
        sb = new StringBuilder(str);
        for (byte bitPosition : bitPositions) {
            if (sb.charAt(bitPosition) == 49) {
                return true;
            }
        }
        return false;
    }

    //Task6
    public String selectAnyBitSelected(long number, byte[] bitPositions) {
        String str = convertNumberToBinaryString(number);
        sb = new StringBuilder(str);
        for (int i = 0; i < bitPositions.length - 1; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(bitPositions[i]) != 49) {
                    sb.insert(bitPositions[i], 1).deleteCharAt(bitPositions[i] + 1);
                }
            }

        }
        return sb.toString();
    }

    //Task7
    public String deselectAnyBitSelected(long number, byte[] bitPositions) {
        String str = convertNumberToBinaryString(number);
        sb = new StringBuilder(str);
        for (int i = 0; i < bitPositions.length - 1; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(bitPositions[i]) != 49) {
                    sb.insert(bitPositions[i], 0).deleteCharAt(bitPositions[i] + 1);
                }
            }

        }
        return sb.toString();
    }

    //Task 8
    public long invertBit(long numb, int position) {
        String binary = Long.toBinaryString(numb);
        char[] oneAndZero = binary.toCharArray();
        if (numb == 0) {
            return 0;
        } else if ((position > binary.length() - 1)) {
            System.out.println("Такой позиции не существует");
            return numb;
        }
        if (oneAndZero[position] == '0') {
            oneAndZero[position] = '1';
        } else {
            oneAndZero[position] = '0';
        }
        return new BigInteger(String.valueOf(oneAndZero), 2).longValue();
    }

    //Task9
    public boolean isHex(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Empty string.");
        }
        String inputWithoutUnnecessarySpaces = input.trim().replaceAll("\\s", "");
        final Pattern REGEX_PATTERN = Pattern.compile(REGEX_FOR_HEX);
        return REGEX_PATTERN.matcher(inputWithoutUnnecessarySpaces).matches();
    }

    //Task10
    public boolean isPhoneNumber(String numb) {
        if (numb == null) {
            throw new IllegalArgumentException("Empty string.");
        }
        String inputWithoutUnnecessarySpaces = numb.trim().replaceAll("\\s{2,}", "");
        return inputWithoutUnnecessarySpaces.matches(REGEX_FOR_PH_NUMBER);
    }
    //Task11
}
