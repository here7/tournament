import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TeamTests {
    private Team team;
    private Player player;

    @BeforeEach
    public void setUp(){ team = new Team(null); }

    @Test
    public void addPlayer(){
        Player player = new Player("Daniel", "Heredia", 34, 23);

        assertThat(team.addPlayer(player)).isEqualTo("23. Heredia, Daniel (34 years old)");
    }

    @Test
    public void getStringListTeamMembers(){
        List<String> listExpected = Arrays.asList("23. Heredia, Daniel (34 years old)", "11. Garcia, George (25 years old)");
        team.addPlayer( new Player("Daniel", "Heredia", 34, 23));
        team.addPlayer( new Player("George", "Garcia", 25, 11));

        assertThat(team.getStringListTeamMembers()).isEqualTo(listExpected.toString());
    }
}
