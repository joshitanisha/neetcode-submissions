class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length())
                   .append('#')
                   .append(str);
        }

        return encoded.toString();
    }

    // Decodes a single string back to the original list.
    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {

            // Find the delimiter '#'
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }

            // Length of current string
            int length = Integer.parseInt(s.substring(i, j));

            // Extract the actual string
            String word = s.substring(j + 1, j + 1 + length);
            result.add(word);

            // Move to next encoded string
            i = j + 1 + length;
        }

        return result;
    }
}
