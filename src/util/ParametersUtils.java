package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametersUtils {
    public static String[] getMethodParams(String input) {
        String[] params = new String[]{};
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String parametersString = matcher.group(1);
            String[] parameters = parametersString.split(",\\s*");

            params = new String[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                params[i] = parameters[i].trim();
            }
        }
        return params;
    }

    public static String removeStringMarks(String str) {
        return str.substring(1, str.length() -1);
    }

    public static boolean stringHasMarks(String str) {
        return str.startsWith("\"") && str.endsWith("\"");
    }

    public static String getTypeOfVar(String value) {
        return value.matches("\\d+") ? "int" : "string";
    }

    public static boolean isVariable(String arg) {
        return !stringHasMarks(arg) && !getTypeOfVar(arg).equals("int");
    }
}
