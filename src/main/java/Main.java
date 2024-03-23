public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        tournament.applyResults("Blithering Badgers;Allegoric Alaskans;loss");

        tournament.printTable();
    }
}