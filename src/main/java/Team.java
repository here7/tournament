public class Team {
    private String name;
    private int win;
    private int loss;
    private int draw;

    public Team(String name) {
        this.name = name;
        win = loss = draw = 0;
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

    public int totalWinPoints(int numWins){
        return numWins * 3;
    }

    public int totalDrawPoints(int numDraws){
        return numDraws * 1;
    }
}
