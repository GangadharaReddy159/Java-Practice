
/**
 * StringUtils - a small collection of string utility functions for learning and for industry use.
 * All methods are static and null-safe where reasonable. Target: Java 8+
 */
public final class StringUtils {

    private StringUtils() { /* utility class - no instantiation */ }

    // ---------- Student / convenience helpers ----------

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNullOrBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean safeEquals(String a, String b) {
        return a == null ? b == null : a.equals(b);
    }

    public static String safeSubstring(String s, int start, int end) {
        if (s == null) return null;
        int len = s.length();
        int sIdx = Math.max(0, start);
        int eIdx = Math.min(len, end);
        if (sIdx >= eIdx) return "";
        return s.substring(sIdx, eIdx);
    }

    // ---------- Industry-grade helpers ----------

    public static String truncate(String s, int maxLength, String ellipsis) {
        if (s == null) return null;
        if (maxLength < 0) throw new IllegalArgumentException("maxLength must be >= 0");
        if (ellipsis == null) ellipsis = "";
        if (s.length() <= maxLength) return s;
        int keep = Math.max(0, maxLength - ellipsis.length());
        if (keep == 0) return ellipsis;
        return s.substring(0, keep) + ellipsis;
    }

    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        if (s.length() == 1) return s.toUpperCase();
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    public static String toTitleCase(String s) {
        if (s == null || s.isEmpty()) return s;
        String[] parts = s.split("\\s+");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].isEmpty()) continue;
            if (i > 0) sb.append(' ');
            sb.append(capitalize(parts[i].toLowerCase()));
        }
        return sb.toString();
    }

    public static String normalizeWhitespace(String s) {
        if (s == null) return null;
        return s.trim().replaceAll("\\s+", " ");
    }

    public static String joinNonEmpty(CharSequence delim, String... parts) {
        if (parts == null) return "";
        String d = delim == null ? "" : delim.toString();
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String p : parts) {
            if (p == null || p.isEmpty()) continue;
            if (!first) sb.append(d);
            sb.append(p);
            first = false;
        }
        return sb.toString();
    }

    public static String leftPad(String s, int size, char pad) {
        if (s == null) s = "";
        if (s.length() >= size) return s;
        StringBuilder sb = new StringBuilder(size);
        for (int i = s.length(); i < size; i++) sb.append(pad);
        sb.append(s);
        return sb.toString();
    }

    public static String rightPad(String s, int size, char pad) {
        if (s == null) s = "";
        if (s.length() >= size) return s;
        StringBuilder sb = new StringBuilder(size);
        sb.append(s);
        for (int i = s.length(); i < size; i++) sb.append(pad);
        return sb.toString();
    }

    public static String toSnakeCase(String s) {
        return separatorCase(s, '_');
    }

    public static String toKebabCase(String s) {
        return separatorCase(s, '-');
    }

    private static String separatorCase(String s, char sep) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder(s.length());
        boolean prevWasLowerOrDigit = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i != 0 && prevWasLowerOrDigit) sb.append(sep);
                sb.append(Character.toLowerCase(c));
                prevWasLowerOrDigit = false;
            } else if (Character.isLetterOrDigit(c)) {
                sb.append(c);
                prevWasLowerOrDigit = Character.isLowerCase(c) || Character.isDigit(c);
            } else {
                // treat other characters as separators
                if (sb.length() > 0 && sb.charAt(sb.length()-1) != sep) sb.append(sep);
                prevWasLowerOrDigit = false;
            }
        }
        // trim trailing separator
        int len = sb.length();
        if (len > 0 && sb.charAt(len-1) == sep) sb.deleteCharAt(len-1);
        return sb.toString();
    }

    // Levenshtein distance - classic dynamic programming implementation
    public static int levenshteinDistance(String a, String b) {
        if (a == null) a = "";
        if (b == null) b = "";
        int n = a.length();
        int m = b.length();
        if (n == 0) return m;
        if (m == 0) return n;
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int j = 0; j <= m; j++) prev[j] = j;
        for (int i = 1; i <= n; i++) {
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                cur[j] = Math.min(Math.min(cur[j - 1] + 1, prev[j] + 1), prev[j - 1] + cost);
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return prev[m];
    }

}

