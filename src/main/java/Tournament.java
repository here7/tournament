import java.util.HashMap;
import java.util.Map;


public class Tournament {
    public Map<String, Team> dataMap = new HashMap<String, Team>();


    String printTable() {
        return "PRINTING...";
    }

    public String applyResults(String resultString) {
        String[] arrData = resultString.split("\n");

        for(int i = 0; i < arrData.length; i++){
            String[] lineData = arrData[i].split(";");
            addResultTeam(lineData[0], lineData[1], lineData[2]);
        }

        dataMap.entrySet().stream()
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));

        return "HOLA";
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