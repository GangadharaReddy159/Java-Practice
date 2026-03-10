public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //basic class instance
        Person venkat = new Person("Venkat", 24, "Vijayawada");
        System.out.println(venkat);

        //Strings
        String s= "Welcome to Java Programming!";
        System.out.println(s);

        System.out.println(s.charAt(6));
        System.out.println(s.indexOf('a'));
        System.out.println(s.lastIndexOf('a'));
        System.out.println(s.substring(11,15));
        String a = s.split(" ")[3];
        System.out.println(a);
        System.out.println(s.isEmpty());

        System.out.println("\n--- Running API Examples ---");
        runApiExamples();

        System.out.println("\n--- Running StringUtils Demonstrations ---");
        runUtilitiesDemo();
    }

    private static void runApiExamples() {
        String t = "  Hello, World!  ";
        System.out.println("Original: '" + t + "'");
        System.out.println("trim(): '" + t.trim() + "'");
        System.out.println("toUpperCase(): '" + t.toUpperCase() + "'");
        System.out.println("toLowerCase(): '" + t.toLowerCase() + "'");
        System.out.println("length(): " + t.length());
        System.out.println("charAt(2): " + t.charAt(2));
        System.out.println("indexOf(','): " + t.indexOf(','));
        System.out.println("lastIndexOf('l'): " + t.lastIndexOf('l'));
        System.out.println("substring(2,7): '" + t.substring(2,7) + "'");
        String[] parts = t.trim().split("\\s+");
        System.out.println("split by whitespace: " + java.util.Arrays.toString(parts));
        System.out.println("contains('World'): " + t.contains("World"));
        System.out.println("startsWith('  He'): " + t.startsWith("  He"));
        System.out.println("endsWith('ld!  '): " + t.endsWith("ld!  "));
        System.out.println("equalsIgnoreCase('  hello, world!  '): " + t.equalsIgnoreCase("  hello, world!  "));
        System.out.println("replace('World','Java'): '" + t.replace("World","Java") + "'");
        System.out.println("matches '.*World.*': " + t.matches(".*World.*"));
        System.out.println("format example: " + String.format("%s - %d", "Count", 5));
    }

    private static void runUtilitiesDemo() {
        System.out.println("isNullOrEmpty(null): " + StringUtils.isNullOrEmpty(null));
        System.out.println("isNullOrEmpty(''): " + StringUtils.isNullOrEmpty(""));
        System.out.println("isNullOrBlank('   '): " + StringUtils.isNullOrBlank("   "));
        System.out.println("safeEquals(null, null): " + StringUtils.safeEquals(null, null));
        System.out.println("safeEquals('a', 'A'): " + StringUtils.safeEquals("a", "A"));
        System.out.println("safeSubstring('Hello', 1, 3): '" + StringUtils.safeSubstring("Hello",1,3) + "'");
        System.out.println("truncate('This is a very long text', 10, '...'): '" + StringUtils.truncate("This is a very long text", 10, "...") + "'");
        System.out.println("capitalize('java'): '" + StringUtils.capitalize("java") + "'");
        System.out.println("toTitleCase('hello world from java'): '" + StringUtils.toTitleCase("hello world from java") + "'");
        System.out.println("normalizeWhitespace('  a   b\t\n c  '): '" + StringUtils.normalizeWhitespace("  a   b\t\n c  ") + "'");
        System.out.println("joinNonEmpty(', ', 'a', '', null, 'b'): '" + StringUtils.joinNonEmpty(", ", "a", "", null, "b") + "'");
        System.out.println("leftPad('7', 3, '0'): '" + StringUtils.leftPad("7",3,'0') + "'");
        System.out.println("rightPad('7', 3, '*'): '" + StringUtils.rightPad("7",3,'*') + "'");
        System.out.println("toSnakeCase('HelloWorld Test'): '" + StringUtils.toSnakeCase("HelloWorld Test") + "'");
        System.out.println("toKebabCase('HelloWorld Test'): '" + StringUtils.toKebabCase("HelloWorld Test") + "'");
        System.out.println("levenshteinDistance('kitten','sitting'): " + StringUtils.levenshteinDistance("kitten","sitting"));
    }
}