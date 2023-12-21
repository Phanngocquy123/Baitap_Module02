import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<GiftConfig> giftConfigs = new ArrayList<>();
//        List<Player> players = new ArrayList<>();
        PlayerManager playerManager = new PlayerManager();
        GiftConfigManager giftConfigManager = new GiftConfigManager();
        GiftHistoryManager giftHistoryManager = new GiftHistoryManager();

        GiftConfig gift1 = new GiftConfig("M01","Xoài",2.3,true,5,3);
        GiftConfig gift2 = new GiftConfig("M02","Ổi",2.3,false,10,3);
        GiftConfig gift3 = new GiftConfig("M03","Cóc",2.3,false,15,3);
        GiftConfig gift4 = new GiftConfig("M04","Nhãn",2.3,false,5,3);
        GiftConfig gift5 = new GiftConfig("M05","Bưởi",2.3,true,10,3);
        GiftConfig gift6 = new GiftConfig("M06","Bưởi",2.3,true,5,3);

        giftConfigManager.add(gift1);
        giftConfigManager.add(gift2);
        giftConfigManager.add(gift3);
        giftConfigManager.add(gift4);
        giftConfigManager.add(gift5);
        giftConfigManager.add(gift6);

        Player player1 = new Player("BH01","Nam");
        Player player2 = new Player("BH02","Hoàn");
        Player player3 = new Player("BH03","Long");

        playerManager.add(player1);
        playerManager.add(player2);
        playerManager.add(player3);
        int choose;
        do {
            System.out.println("1- Nhập mã người chơi (playerCode)");
            System.out.println("2- Nhập player code để xem quà đã nhận");
            System.out.println("3- Thoát");
            System.out.print("Nhập choose: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    System.out.print("Nhập mã người chơi (playerCode): ");
                    String playerCodeInput = sc.nextLine();
                    //Player player = playerManager.checkPlayercode(playerCodeInput);
                    if (playerManager.checkPlayercode(playerCodeInput) == null){
                        System.out.println("PlayerCode không tồn tại");
                    } else {
                        System.out.println("Tiến hành phát quà");
                        String giftCode = giftConfigManager.give().getGiftCode();

                        giftHistoryManager.add(giftCode,playerCodeInput);                           // trả về lịch sử trao quà
                        playerManager.addGiftOfPlayer(playerCodeInput,giftCode,1);   // trả về quà nhận của người chơi

                        System.out.println("---> Danh sách quà còn lại:");
                        giftConfigManager.show();
                        System.out.println("---> Lịch sử trao quà:");
                        giftHistoryManager.show();
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã người chơi kiểm tra (playerCode): ");
                    playerCodeInput = sc.nextLine();
                    //player = playerManager.checkPlayercode(playerCodeInput);
                    if (playerManager.checkPlayercode(playerCodeInput) == null){
                        System.out.println("---> PlayerCode không tồn tại");
                        break;
                    }
                    if (!playerManager.checkExistPlayerCodeGaveGift(playerCodeInput)){
                        System.out.println("---> PlayerCode chưa nhận được quà");
                        break;
                    }
                    playerManager.showAll();
                    System.out.println("------------");
                    playerManager.showGiftOfPlayer(playerCodeInput);

                    break;
                default:
            }
        } while (choose != 3);

    }
}
