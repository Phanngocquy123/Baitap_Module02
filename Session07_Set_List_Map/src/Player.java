public class Player {
    private String playerCode;
    private String playerName;
    private String playerGiftCode;
    private int playerGiftQuantity;

    public Player() {
    }

    public Player(String playerCode, String playerName) {
        this.playerCode = playerCode;
        this.playerName = playerName;
    }

    public Player(String playerCode, String playerGiftCode, int playerGiftQuantity) {
        this.playerCode = playerCode;
        this.playerGiftCode = playerGiftCode;
        this.playerGiftQuantity = playerGiftQuantity;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerGiftCode() {
        return playerGiftCode;
    }

    public void setPlayerGiftCode(String playerGiftCode) {
        this.playerGiftCode = playerGiftCode;
    }

    public int getPlayerGiftQuantity() {
        return playerGiftQuantity;
    }

    public void setPlayerGiftQuantity(int playerGiftQuantity) {
        this.playerGiftQuantity = playerGiftQuantity;
    }
}
