import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    private final String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    private final String[] callings = {"kai", "kai", "mine", "mine"};

    public String[] getPlayers() {
        return players;
    }

    public String[] getCallings() {
        return callings;
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        for (String player : callings) {
            int ownRank = rankMap.get(player);
            if (ownRank == 0) {
                continue;
            }
            String beforePlayer = players[ownRank - 1];
            players[ownRank - 1] = player;
            players[ownRank] = beforePlayer;
            rankMap.put(player, ownRank - 1);
            rankMap.put(beforePlayer, ownRank);
        }
        return players;
    }
}
