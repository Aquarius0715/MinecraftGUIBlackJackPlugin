package aquarius0715.minecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class BlackJackGameSystem {

    public Inventory inv;
    public Inventory inv2;
    String prefix = ChatColor.AQUA + "" + ChatColor.BOLD + "[AquaBlackJack]";
    //アイテムの座標
    int coordinate = 45;
    int coordinate2 = 8;
    //GUIの根幹変数
    ItemStack card = new ItemStack(Material.PAPER);
    ItemMeta card_meta = card.getItemMeta();
    ItemStack GUI = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
    ItemMeta GUI_meta = GUI.getItemMeta();
    ItemStack HIT = new ItemStack(Material.REDSTONE_BLOCK);
    ItemMeta HIT_meta = HIT.getItemMeta();
    ItemStack STAND = new ItemStack(Material.LAPIS_BLOCK);
    ItemMeta STAND_meta = STAND.getItemMeta();
    ItemStack BUST = new ItemStack(Material.BARRIER);
    ItemMeta BUST_meta = BUST.getItemMeta();
    ItemStack BLACKJACK = new ItemStack((Material.END_CRYSTAL));
    ItemMeta BLACKJACK_meta = BLACKJACK.getItemMeta();
    //点数
    int my_score;
    int your_score;
    //自分のカード
    int card_number = new Random().nextInt(13);
    int card_number1 = new Random().nextInt(13);
    //相手のカード
    int card_number2 = new Random().nextInt(13);
    int card_number3 = new Random().nextInt(13);
    //文字のカード
    String card_number_word;
    String card_number_word1;
    String card_number_word2;
    String card_number_word3;


    @EventHandler()
    public void onClickGUI(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        event.setCancelled(true);

        switch (event.getSlot()) {
            //HITボタンを押したときの処理を書く
            case 28:
                //自分の点数が21を超えたらバスト
                if (my_score > 21) {
                    BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
                    BUST.setItemMeta(BUST_meta);
                    inv.setItem(31, BUST);
                    break;
                }
                //自分の点数が21だったらブラックジャック
                if (my_score == 21) {
                    BLACKJACK_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLACKJACK");
                    BLACKJACK.setItemMeta(BLACKJACK_meta);
                    inv.setItem(31, BLACKJACK);
                    break;
                }
                //新しいカードを引く処理
                int card_number = new Random().nextInt(13);
                if (card_number >= 10) {
                    card_number = 10;
                }
                String card_number_word = Integer.toString(card_number);
                card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
                card.setItemMeta(card_meta);
                coordinate++;
                inv.setItem(coordinate, card);
                this.my_score = my_score + card_number;
                card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + my_score);
                card.setItemMeta(card_meta);
                inv.setItem(31, card);
                break;

            case 29:
                //TODO ここにスタンドボタンが押された時の処理を書く
                break;

        }
        if (my_score > 21) {
            BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
            BUST.setItemMeta(BUST_meta);
            inv.setItem(31, BUST);
        }
        if (my_score == 21) {
            BLACKJACK_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLACKJACK");
            BLACKJACK.setItemMeta(BLACKJACK_meta);
            inv.setItem(31, BLACKJACK);
        }
    }

    public void onClickYourGUI(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv2)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        event.setCancelled(true);

        switch (event.getSlot()) {
        }
    }

    public void createMyInv() {

        //新しいインベントリを作成
        inv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "" + ChatColor.BOLD + "BLACKJACK");

        //GUIの作成

        GUI_meta.setDisplayName(" ");
        GUI.setItemMeta(GUI_meta);
        inv.setItem(18, GUI);
        inv.setItem(19, GUI);
        inv.setItem(20, GUI);
        inv.setItem(21, GUI);
        inv.setItem(22, GUI);
        inv.setItem(23, GUI);
        inv.setItem(24, GUI);
        inv.setItem(25, GUI);
        inv.setItem(26, GUI);
        inv.setItem(27, GUI);
        inv.setItem(30, GUI);
        inv.setItem(31, GUI);
        inv.setItem(32, GUI);
        inv.setItem(33, GUI);
        inv.setItem(34, GUI);
        inv.setItem(35, GUI);

        //自分のカードの作成


        if (card_number >= 10) {
            card_number = 10;
        }
        card_number_word = Integer.toString(card_number);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        card.setItemMeta(card_meta);
        inv.setItem(coordinate, card);


        if (card_number1 >= 10) {
            card_number = 10;
        }
        card_number_word1 = Integer.toString(card_number1);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word1);
        card.setItemMeta(card_meta);
        coordinate++;
        inv.setItem(coordinate, card);

        //相手のカードの作成

        if (card_number2 >= 10) {
            card_number2 = 10;
        }
        card_number_word2 = Integer.toString(card_number2);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word2);
        card.setItemMeta(card_meta);
        inv.setItem(coordinate2, card);

        if (card_number3 >= 10) {
            card_number3 = 10;
        }
        card_number_word3 = Integer.toString(card_number3);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word3);
        card.setItemMeta(card_meta);
        coordinate2--;
        inv.setItem(coordinate2, card);

        //自分のカードの合計を作成

        my_score = card_number + card_number1;
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + my_score);
        card.setItemMeta(card_meta);
        inv.setItem(31, card);

        //相手のカードの合計を作成
        your_score = card_number2 + card_number3;
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "相手のスコアは" + your_score);
        card.setItemMeta(card_meta);
        inv.setItem(22, card);

        //ヒット・スタンドボタンを作成

        HIT_meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "HIT");
        HIT.setItemMeta(HIT_meta);
        inv.setItem(28, HIT);

        STAND_meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "STAND");
        STAND.setItemMeta(STAND_meta);
        inv.setItem(29, STAND);


    }

    public void createYourInv() {
        //子のインベントリを作成
        inv2 = Bukkit.createInventory(null, 54, ChatColor.BLACK + "" + ChatColor.BOLD + "BLACKJACK");

        //GUIの作成

        GUI_meta.setDisplayName(" ");
        GUI.setItemMeta(GUI_meta);
        inv2.setItem(18, GUI);
        inv2.setItem(19, GUI);
        inv2.setItem(20, GUI);
        inv2.setItem(21, GUI);
        inv2.setItem(22, GUI);
        inv2.setItem(23, GUI);
        inv2.setItem(24, GUI);
        inv2.setItem(25, GUI);
        inv2.setItem(26, GUI);
        inv2.setItem(27, GUI);
        inv2.setItem(30, GUI);
        inv2.setItem(31, GUI);
        inv2.setItem(32, GUI);
        inv2.setItem(33, GUI);
        inv2.setItem(34, GUI);
        inv2.setItem(35, GUI);

        //自分のカードの作成

        if (card_number >= 10) {
            card_number = 10;
        }
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word2);
        card.setItemMeta(card_meta);
        coordinate = 45;
        inv2.setItem(coordinate, card);

        if (card_number >= 10) {
            card_number = 10;
        }
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word3);
        card.setItemMeta(card_meta);
        coordinate++;
        inv2.setItem(coordinate, card);

        if (card_number >= 10) {
            card_number = 10;
        }
        //相手のカードを作成
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        card.setItemMeta(card_meta);
        coordinate2 = 8;
        inv2.setItem(coordinate2, card);

        if (card_number1 >= 10) {
            card_number = 10;
        }
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word1);
        card.setItemMeta(card_meta);
        coordinate2--;
        inv2.setItem(coordinate2, card);

        //相手のカードの合計を作成
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "相手のスコアは" + my_score);
        card.setItemMeta(card_meta);
        inv2.setItem(22, card);

        //自分のカードの合計を作成
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + your_score);
        card.setItemMeta(card_meta);
        inv2.setItem(31, card);

        //ヒット・スタンドボタンを作成

        HIT_meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "HIT");
        HIT.setItemMeta(HIT_meta);
        inv2.setItem(28, HIT);

        STAND_meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "STAND");
        STAND.setItemMeta(STAND_meta);
        inv2.setItem(29, STAND);

    }

}
