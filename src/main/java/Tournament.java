import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Tournament {
 //   public Map<String, Team> dataMap = new HashMap<>();
    public LinkedHashMap<String, Team> dataMap = new LinkedHashMap<>();

    String printTable() {
        StringBuilder result = new StringBuilder("Team                           | MP |  W |  D |  L |  P\n");

        dataMap.entrySet().stream()
                .forEach(entry -> result.append(
                        String.format("%-30s",entry.getKey()) +
                        String.format(" | %2d",(entry.getValue().getTotalWin() + entry.getValue().getTotalLoss() + entry.getValue().getTotalDraw())) +
                        String.format(" | %2d", entry.getValue().getTotalWin()) +
                        String.format(" | %2d", entry.getValue().getTotalDraw()) +
                        String.format(" | %2d", entry.getValue().getTotalLoss()) +
                        String.format(" | %2d", entry.getValue().totalWinPoints(entry.getValue().getTotalWin()) +
                                                entry.getValue().totalDrawPoints(entry.getValue().getTotalDraw())) +
                        "\n"
                ));
        //System.out.println(result.toString().trim());
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
                dataMap.computeIfAbsent(secondTeam, s -> new Team(secondTeam)).addWin();
                dataMap.computeIfAbsent(firstTeam, s -> new Team(firstTeam)).addLoss();
                break;
            case "draw":
                dataMap.computeIfAbsent(firstTeam, s -> new Team(firstTeam)).addDraw();
                dataMap.computeIfAbsent(secondTeam, s -> new Team(secondTeam)).addDraw();
                break;
        }
    }
}