package aquarius0715.minecraftplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

import java.util.Random;

public class Data implements Listener {

    BlackJackGameSystem b = new BlackJackGameSystem();

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
        int card_number = new Random().nextInt(13);
        if (card_number >= 10) {
            card_number = 10;
        }
        String card_number_word = Integer.toString(card_number);
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        b.card.setItemMeta(b.card_meta);
        b.coordinate++;
        b.inv2.setItem(b.coordinate, b.card);
        this.b.child_score = b.child_score + card_number;
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + b.child_score);
        b.card.setItemMeta(b.card_meta);
        b.inv2.setItem(31, b.card);
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
        int card_number = new Random().nextInt(13);
        if (card_number >= 10) {
            card_number = 10;
        }
        String card_number_word = Integer.toString(card_number);
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        b.card.setItemMeta(b.card_meta);
        b.coordinate++;
        b.inv.setItem(b.coordinate, b.card);
        this.b.parent_score = b.parent_score + card_number;
        b.card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + b.parent_score);
        b.card.setItemMeta(b.card_meta);
        b.inv.setItem(31, b.card);
        return;

    }

    public void STANDChild() {

    }

    public void STANDParent() {

    }
}
