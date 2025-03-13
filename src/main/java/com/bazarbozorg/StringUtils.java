package com.bazarbozorg;

public class StringUtils {

    public static String toCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("[ _-]+"); // Split on spaces, underscores, or dashes
        StringBuilder camelCaseString = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                camelCaseString.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());
            }
        }

        return camelCaseString.toString();
    }
}
