package arrayDictionary;

public class Main {
    public static void main(String[] args) {
        ArrayDictionary<String, String> dictionary = new ArrayDictionary<>();

        dictionary.put("a", "apple");
        dictionary.put("a", "avocado");
        dictionary.put("b", "banana");

        System.out.println("Values for 'a': " + dictionary.get("a"));
        System.out.println("All keys: " + dictionary.keys());

        dictionary.remove("a", "apple");
        System.out.println("Values for 'a' after removal: " + dictionary.get("a"));
    }
}
