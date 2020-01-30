package aquarius0715.minecraftplugin;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class Events implements Listener {

    BlackJackCommand bc = new BlackJackCommand();
    BlackJackGameSystem bg = new BlackJackGameSystem();

    @EventHandler
    public void onClickGUI(InventoryClickEvent event) {
        if (!event.getInventory().equals(bg.inv)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (!event.getInventory().equals(bg.inv2)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        event.setCancelled(true);
    }
}
