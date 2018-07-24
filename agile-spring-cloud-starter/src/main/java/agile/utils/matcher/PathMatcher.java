package agile.utils.matcher;

import java.util.regex.Pattern;

public class PathMatcher {

    public static boolean matches(String chainUri, String requestUri) {
        String regex = chainUri;

        if (regex.indexOf("**") > -1) {
            regex = regex.replaceAll("\\*\\*", "([\\\\w-/]){0,}");
        }

        if (regex.indexOf("*") > -1) {
            regex = regex.replaceAll("\\*", "([\\\\w-]){0,}");
        }

        // FIXME 支持 {id[uuid]} {id[int]} {id[int]16} {id[string]:8}
        if (regex.indexOf("{") > -1 && regex.indexOf("}") > -1) {
            regex = regex.replaceAll("\\{[\\w-]+\\}", "[\\\\w-]+");
        }

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(requestUri).matches();
    }

}
