package json.generator;

public class FormatUtility {
    private FormatUtility() {
    }

    public static String cleanHtmlFormatting(final String str) {
        final String replaced = str.replaceAll("\\<.*?>", "");
        return replaced.replaceAll("&nbsp;", "").replaceAll("\\r|\\n", "").
                replaceAll("&uuml;", "ü").replaceAll("&auml;", "ü").
                replaceAll("&ouml;", "ü");
    }
}
