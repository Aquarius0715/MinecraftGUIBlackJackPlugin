package aquarius0715.minecraftplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class Events implements Listener {

    BlackJackCommand b = new BlackJackCommand();

    @EventHandler
    public void onClickGUI(InventoryClickEvent event) {
        b.child = (Player) event.getWhoClicked();
        b.parent = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == event.getWhoClicked().getInventory()) {
            return;
        }
        event.setCancelled(true);
    }
}
