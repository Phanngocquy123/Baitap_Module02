import java.util.ArrayList;
import java.util.List;

public class GiftHistoryManager {
    List<GiftHistory> giftHistories;
    public GiftHistoryManager(){
        this.giftHistories = new ArrayList<>();
    }

    public void add(String gift, String player){
        GiftHistory obj = new GiftHistory(gift,player);
        this.giftHistories.add(obj);
    }

    public void show(){
        giftHistories.forEach(x -> System.out.printf("Gift Code: %-3s || Player Code: %-3s\n", x.getGiftCode(),x.getPlayerCode()));
    }
}
