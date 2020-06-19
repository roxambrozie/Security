package substringsearchalgorithm;

public class BruteForceSubstringSearchAlgorithm {

    public static void main(String[] args) {
        System.out.println(search("This is Roxana", "Roxana"));
    }


    public static String search(String text, String pattern) {
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();

        for (int i = 0; i <= lengthOfText - lengthOfPattern; i++) {
            int j;
            for (j = 0; j < lengthOfPattern; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == lengthOfPattern) return pattern;
        }
        return text;
    }


}
