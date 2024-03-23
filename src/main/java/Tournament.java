import java.util.*;


public class Tournament {
    public LinkedHashMap<String, Team> dataMap = new LinkedHashMap<>();

    String printTable() {
        StringBuilder result = new StringBuilder("Team                           | MP |  W |  D |  L |  P\n");

        dataMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.getScore() - o1.getScore()))
                .forEach(o1 -> result.append(
                        String.format("%-30s", o1.getValue().getName()) +
                                String.format(" | %2d", (o1.getValue().getTotalWin() + o1.getValue().getTotalLoss() + o1.getValue().getTotalDraw())) +
                                String.format(" | %2d", o1.getValue().getTotalWin()) +
                                String.format(" | %2d", o1.getValue().getTotalDraw()) +
                                String.format(" | %2d", o1.getValue().getTotalLoss()) +
                                String.format(" | %2d", o1.getValue().getScore()) +
                                "\n"));

        return result.toString();
    }

    void applyResults(String resultString) {
        String[] arrData = resultString.split("\n");

        for(int i = 0; i < arrData.length; i++){
            String[] lineData = arrData[i].split(";");
            addResultTeam(lineData[0], lineData[1], lineData[2]);
        }
    }

     void addResultTeam(String firstTeam, String secondTeam, String resultGame){
        switch (resultGame){
            case "win":
                dataMap.computeIfAbsent(firstTeam, s -> new Team(firstTeam)).addWin();
                dataMap.computeIfAbsent(secondTeam, s -> new Team(secondTeam)).addLoss();
                break;
            case "loss":
                dataMap.computeIfAbsent(firstTeam, s -> new Team(firstTeam)).addLoss();
                dataMap.computeIfAbsent(secondTeam, s -> new Team(secondTeam)).addWin();
                break;
            case "draw":
                dataMap.computeIfAbsent(firstTeam, s -> new Team(firstTeam)).addDraw();
                dataMap.computeIfAbsent(secondTeam, s -> new Team(secondTeam)).addDraw();
                break;
        }
    }
}