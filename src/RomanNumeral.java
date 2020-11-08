enum RomanNumeral {
    I("I", 1), IV("IV", 4), V("V", 5),
    IX("IX", 9), X("X", 10), XL("XL", 40),
    L("L", 50), XC("XC", 90), C("C", 100);

    private String key;
    private int value;

    RomanNumeral(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    static String convertToRoman(int number){
        StringBuilder returnValue = new StringBuilder();
        String highestFound = "";
        while (number > 0) {
            for (RomanNumeral romanNumeral : RomanNumeral.values()) {
                if (romanNumeral.getValue() <= number) {
                    highestFound = romanNumeral.getKey();
                }
            }
            returnValue.append(RomanNumeral.valueOf(highestFound).getKey());
            number -= RomanNumeral.valueOf(highestFound).getValue();
        }
        return returnValue.toString();
    }

    static String convertToArab(String number) throws Exception {
        String foundNumber = "";
        for (int i = 0; i < 101; i++) {
            foundNumber = convertToRoman(i);
            if (number.equals(foundNumber)) {
                return Integer.toString(i);
            }
        }
        throw new Exception("incorrect numbers");
    }
}




