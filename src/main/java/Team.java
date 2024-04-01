import java.util.*;

public class Team {
    private String name;
    private int win;
    private int loss;
    private int draw;
    private List<Player> listPlayer;
    private Player player;

    public Team(String name) {
        this.name = name;
        listPlayer = new ArrayList<>();
        win = loss = draw = 0;
    }

    public String addPlayer(Player player){
        listPlayer.add(player);
        return String.format("%d. %s, %s (%d years old)", player.getDorsal(), player.getLastName(), player.getFirstName(), player.getAge());
    }
    public String getStringListTeamMembers(){
        //StringBuilder teamList = new StringBuilder();
        List<String> teamList = new ArrayList<>();

        if(listPlayer.size() > 0){
            listPlayer.stream().forEach((player) -> teamList.add(
                                                    String.format("%d. %s, %s (%d years old)",
                                                            player.getDorsal(),
                                                            player.getLastName(), player.getFirstName(), player.getAge())));
        }

        return teamList.toString();
    }

    public List<Player> getListTeamMembers(){
        return new ArrayList<>();
    }

    // Dorsal + rest of Data
    public HashMap<Integer,String> getMapTeamMembers(){
        return new HashMap<Integer,String>();
    }

    public String getName() {
        return name;
    }

    public void addWin(){
        win += 1;
    }

    public void addLoss(){
        loss += 1;
    }

    public void addDraw(){
        draw += 1;
    }

    public int getTotalWin(){
        return this.win;
    }
    public int getTotalLoss(){
        return this.loss;
    }
    public int getTotalDraw(){
        return this.draw;
    }

    public int getScore(){
        return (this.win * 3) + (this.draw * 1);
    }
}
