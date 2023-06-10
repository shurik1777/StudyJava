public class Task2 {
    public static String compressString(String input) {
        StringBuilder output = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {

                output.append(input.charAt(i)).append(count);
                count = 1;
            } else {
                count++;
            }
        }

        return output.toString();
    }
}