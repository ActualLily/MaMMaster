package lily;

public class Main {
    public static void main(String[] args) {
        System.out.println(CardParser.getCard("src/main/resources/World Ender.xml")
                .getDefinitions().getDescription());
    }
}
