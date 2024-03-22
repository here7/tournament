import java.util.HashMap;
import java.util.Map;


public class Tournament {
    public Map<String, Team> dataMap = new HashMap<String, Team>();

    String printTable() {
        String result = "Team       | MP |  W |  D |  L |  P";
        System.out.println(result);
        dataMap.entrySet().stream()
                .forEach(entry -> System.out.println(
                        entry.getKey() +
                        "| " + (entry.getValue().getTotalWin() + entry.getValue().getTotalLoss() + entry.getValue().getTotalDraw()) +
                        "| " + entry.getValue().getTotalWin() +
                        "| " + entry.getValue().getTotalLoss() +
                        "| " + entry.getValue().getTotalDraw() +
                        "| " + entry.getValue().totalPoints(entry.getValue().getTotalWin())
                ));

        return result;
    }

    void applyResults(String resultString) {
        String[] arrData = resultString.split("\n");

        for(int i = 0; i < arrData.length; i++){
            String[] lineData = arrData[i].split(";");
            addResultTeam(lineData[0], lineData[1], lineData[2]);
        }
    }

    public void addResultTeam(String firstTeam, String secondTeam, String resultGame){
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