import java.util.*;

public class GiftConfigManager {
    List<GiftConfig> giftConfigsTrue;
    List<GiftConfig> giftConfigsFalse;

    public GiftConfigManager() {
        this.giftConfigsTrue = new ArrayList<>();
        this.giftConfigsFalse = new ArrayList<>();
    }

    public void add(GiftConfig giftConfig) {
        if (!giftConfig.isFree()){
            this.giftConfigsFalse.add(giftConfig);
        } else {
            this.giftConfigsTrue.add(giftConfig);
        }
    }

    public void show(){
        System.out.println("Quà có giá trị: ");
        giftConfigsFalse.forEach(x -> System.out.printf("Gift Code: %-3s || Limit Total: %-2d\n",x.getGiftCode(),x.getLimitTotal()));
        System.out.println("");
        System.out.println("Quà không có giá trị");
        giftConfigsTrue.forEach(y -> System.out.printf("Gift Code: %-3s || Limit Total: %-2d\n",y.getGiftCode(),y.getLimitTotal()));
    }


    public GiftConfig give() {
            int totalFalse = 0;   // tổng số lượng quà có giá trị
            int totalTrue = 0;    // tổng số lượng quà không có giá trị
            Random generator = new Random();
            int rdIndex;

            for (GiftConfig element1 : giftConfigsFalse){
                totalFalse += element1.getLimitTotal();
            }
            for (GiftConfig element2 : giftConfigsTrue){
                totalTrue += element2.getLimitTotal();
            }
            if (totalFalse == 0 && totalTrue ==0){
                System.out.println("Không còn quà để tặng");
                return null;
            }

            if (totalFalse != 0){
                rdIndex = generator.nextInt(giftConfigsFalse.size());    //  0 đến < maxNumber
                System.out.println("(Quà có giá trị) random: " + rdIndex);

                if (giftConfigsFalse.get(rdIndex).getLimitTotal() == 0){
                    giftConfigsFalse.remove(rdIndex);
                    rdIndex = generator.nextInt(giftConfigsFalse.size());  // SỬA LẠI ĐOẠN NÀY
                }
                int a = giftConfigsFalse.get(rdIndex).getLimitTotal() - 1;
                giftConfigsFalse.get(rdIndex).setLimitTotal(a);
                System.out.println("Quà nhận được: " + giftConfigsFalse.get(rdIndex).getGiftCode());
                return giftConfigsFalse.get(rdIndex);
            } else {
                rdIndex = generator.nextInt(giftConfigsTrue.size());    //  0 đến < maxNumber
                System.out.println("(Quà không có giá trị) random: " + rdIndex);
                if (giftConfigsTrue.get(rdIndex).getLimitTotal() == 0){
                    giftConfigsTrue.remove(rdIndex);
                    rdIndex = generator.nextInt(giftConfigsTrue.size());
                }
                int b = giftConfigsTrue.get(rdIndex).getLimitTotal() - 1;
                giftConfigsTrue.get(rdIndex).setLimitTotal(b);
                System.out.println("Quà nhận được: " + giftConfigsTrue.get(rdIndex).getGiftCode());
                return giftConfigsTrue.get(rdIndex);
            }
    }


}
