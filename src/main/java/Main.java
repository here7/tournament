public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        tournament.applyResults("Allegoric Alaskans;Blithering Badgers;win\n" +
                "Devastating Donkeys;Courageous Californians;draw\n" +
                "Devastating Donkeys;Allegoric Alaskans;win\n" +
                "Courageous Californians;Blithering Badgers;loss\n" +
                "Blithering Badgers;Devastating Donkeys;loss\n" +
                "Allegoric Alaskans;Courageous Californians;win");

        tournament.printTable();
    }
}