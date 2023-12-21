public class GiftHistory {
    private String giftCode;
    private String playerCode;

    public GiftHistory() {
    }

    public GiftHistory(String giftCode, String playerCode) {
        this.giftCode = giftCode;
        this.playerCode = playerCode;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }
}
