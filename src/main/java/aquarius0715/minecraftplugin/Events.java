package aquarius0715.minecraftplugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class Events implements Listener {

    BlackJackGameSystem b = new BlackJackGameSystem();
    Data d = new Data();

    @EventHandler
    public void onClickMyGUI(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == event.getWhoClicked().getInventory()) {
            return;
        }
        switch (event.getSlot()) {
            //HITボタンを押したときの処理を書く
            case 28:
                d.HITParent();
                break;
            case 29:
                //TODO ここにスタンドボタンが押された時の処理を書く
                break;

        }
        if (b.parent_score > 21) {
            b.BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
            b.BUST.setItemMeta(b.BUST_meta);
            b.inv.setItem(31, b.BUST);
        }
        if (b.parent_score == 21) {
            b.BLACKJACK_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLACKJACK");
            b.BLACKJACK.setItemMeta(b.BLACKJACK_meta);
            b.inv.setItem(31, b.BLACKJACK);
        }
    }
}
