public class Chapter1 {

    public String reverseString(String iniString) {
        if (iniString == null) {
            return iniString;
        }
        int len = iniString.length();
        for (int i = 0; i < len / 2; ++i) {
            iniString = iniString.charAt(len - 1 - i) + iniString.substring(i + 1, len - 1 - i) + iniString.charAt(i);
        }
        return iniString;
    }

}
