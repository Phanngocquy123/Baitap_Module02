import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    List<Player> players;
    List<Player> playersGift;
    public PlayerManager(){
        this.players = new ArrayList<>();
        this.playersGift = new ArrayList<>();
    }

    public void  add(Player player){
        this.players.add(player);
    }

    public Player checkPlayercode(String playerCode){
        return this.players.stream().filter(player -> player.getPlayerCode().equals(playerCode)).findFirst().orElse(null);
    }

    public boolean checkExistPlayerCodeGaveGift(String playerCode){
        for (int i = 0; i < playersGift.size(); i++){
            if (playersGift.get(i).getPlayerCode().equals(playerCode)){
                return true;
            }
        }
        return false;
    }
    public void addGiftOfPlayer(String playerCode, String playerGiftCode, int playerGiftQuantity){
        if (checkExistPlayerCodeGaveGift(playerCode)){
            for (int i = 0; i < playersGift.size(); i++){
                if (playersGift.get(i).getPlayerCode().equals(playerCode)){
                    if (playersGift.get(i).getPlayerGiftCode().equals(playerGiftCode) && playersGift.get(i).getPlayerGiftQuantity() != 0){
                        int a = playersGift.get(i).getPlayerGiftQuantity();
                        playersGift.get(i).setPlayerGiftQuantity(a+1);
                        return;
                    }
                }
            }
        }
        Player playerGift = new Player(playerCode, playerGiftCode,playerGiftQuantity);
        this.playersGift.add(playerGift);
    }

    public void showGiftOfPlayer(String playerCode){
        for (int i = 0; i < playersGift.size(); i++){
            if (playersGift.get(i).getPlayerCode().equals(playerCode)){
                System.out.printf("Player Code: %-3s || Player Gift Code: %-3s || Quantity: %-2d\n",
                        playersGift.get(i).getPlayerCode(),
                        playersGift.get(i).getPlayerGiftCode(),
                        playersGift.get(i).getPlayerGiftQuantity());
            }
        }
    }

    public void showAll(){
        playersGift.forEach(x -> System.out.printf("Player Code: %-3s || Player Gift Code: %-3s || Quantity: %-2d\n",
                x.getPlayerCode(),
                x.getPlayerGiftCode(),
                x.getPlayerGiftQuantity()));
    }

}
