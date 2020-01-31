package aquarius0715.minecraftplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Random;

public class Data implements Listener {

    BlackJackGameSystem b = new BlackJackGameSystem();
    BlackJackCommand bc = new BlackJackCommand();

    public void HITChild() {
        //自分の点数が21を超えたらバスト
        if (b.child_score > 21) {
            b.BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
            b.BUST.setItemMeta(b.BUST_meta);
            b.inv2.setItem(31, b.BUST);
            return;
        }
        //自分の点数が21だったらブラックジャック
        if (b.child_score == 21) {
            b.BLACKJACK_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLACKJACK");
            b.BLACKJACK.setItemMeta(b.BLACKJACK_meta);
            b.inv2.setItem(31, b.BLACKJACK);
            return;
        }

        //新しいカードを引く処理
        int card_number = new Random().nextInt(13 + 1);
        if (card_number >= 10) {
            card_number = 10;
        }
        String card_number_word = Integer.toString(card_number);
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        b.card.setItemMeta(b.card_meta);
        //GUIの座標を計算
        b.coordinate++;
        b.coordinate2++;
        //GUIにカードを配置
        b.inv2.setItem(b.coordinate, b.card);
        b.inv.setItem(b.coordinate2, b.card);
        //最終スコアを計算
        b.child_score = b.child_score + card_number;
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + b.child_score);
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "相手のスコアは" + b.child_score);
        b.card.setItemMeta(b.card_meta);
        //カードを配置
        b.inv2.setItem(31, b.card);
        b.inv.setItem(22, b.card);
        return;
    }

    public void HITParent() {
        //自分の点数が21を超えたらバスト
        if (b.parent_score > 21) {
            b.BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
            b.BUST.setItemMeta(b.BUST_meta);
            b.inv.setItem(31, b.BUST);
            return;
        }
        //自分の点数が21だったらブラックジャック
        if (b.parent_score == 21) {
            b.BLACKJACK_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLACKJACK");
            b.BLACKJACK.setItemMeta(b.BLACKJACK_meta);
            b.inv.setItem(31, b.BLACKJACK);
            return;
        }
        //新しいカードを引く処理
        int card_number = new Random().nextInt(13 + 1);
        if (card_number >= 10) {
            card_number = 10;
        }
        String card_number_word = Integer.toString(card_number);
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        b.card.setItemMeta(b.card_meta);
        //GUIの座標を計算
        b.coordinate++;
        b.coordinate2--;
        //GUIに引いたカードをセット
        b.inv.setItem(b.coordinate, b.card);
        b.inv2.setItem(b.coordinate2, b.card);
        //最終スコアを計算
        b.parent_score = b.parent_score + card_number;
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + b.parent_score);
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "相手のスコアは" + b.parent_score);
        b.card.setItemMeta(b.card_meta);
        //カードを配置
        b.inv.setItem(31, b.card);
        b.inv2.setItem(22, b.card);
        return;

    }

    public void STANDChild() {

    }

    public void STANDParent() {

        b.inv.setItem(28, b.GUI);
        b.inv.setItem(29, b.GUI);

        b.HIT_meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "HIT");
        b.HIT.setItemMeta(b.HIT_meta);
        b.inv2.setItem(28, b.HIT);

        b.STAND_meta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "STAND");
        b.STAND.setItemMeta(b.STAND_meta);
        b.inv2.setItem(29, b.STAND);
    }

    public void Help(Player player) {
        player.sendMessage("/blackjack ブラックジャックを親として開始します");
        player.sendMessage("/blackjack join 開始されたゲームに参加します");
        player.sendMessage("/blackjack open ゲームのGUIを開きます");
    }
}
