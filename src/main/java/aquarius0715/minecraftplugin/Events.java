package aquarius0715.minecraftplugin;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class Events implements Listener {

    BlackJackCommand bc = new BlackJackCommand();
    BlackJackGameSystem bg = new BlackJackGameSystem();
    Data d = new Data();

    @EventHandler
    public void onClickGUI(InventoryClickEvent event) {
        bc.child = (Player) event.getWhoClicked();
        bc.parent = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == event.getWhoClicked().getInventory()) {
            if (!event.getInventory().equals(bg.inv)) return;
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            event.setCancelled(true);
            if (!event.getInventory().equals(bg.inv2)) return;
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            event.setCancelled(true);


            switch (event.getSlot()) {
                //HITボタンを押したときの処理を書く
                case 28:
                    d.HITParent();
                    break;
                case 29:
                    //TODO ここにスタンドボタンが押された時の処理を書く
                    break;

            }
            if (bg.parent_score > 21) {
                bg.BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
                bg.BUST.setItemMeta(bg.BUST_meta);
                bg.inv.setItem(31, bg.BUST);
            }
            if (bg.parent_score == 21) {
                bg.BLACKJACK_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "BLACKJACK");
                bg.BLACKJACK.setItemMeta(bg.BLACKJACK_meta);
                bg.inv.setItem(31, bg.BLACKJACK);
            }
            event.setCancelled(true);
        }
    }
}
