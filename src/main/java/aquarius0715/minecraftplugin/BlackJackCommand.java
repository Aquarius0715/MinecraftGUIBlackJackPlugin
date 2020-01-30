package aquarius0715.minecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;


public class BlackJackCommand implements CommandExecutor {

    Player parent;
    Player child;
    UUID parent_uuid;
    UUID child_uuid;

    BlackJackGameSystem b = new BlackJackGameSystem();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("blackjack")) {
            if (!(sender instanceof Player)) {
                Player player = (Player) sender;
                sender.sendMessage("You cannot do this!");
                return true;
            }

            if (args.length == 0) {
                Player player = (Player) sender;
                this.parent = player;
            }
            if (((parent_uuid == null))) {
                parent_uuid = parent.getUniqueId();
                Bukkit.broadcastMessage(parent.getDisplayName() + "さんがブラックジャックを募集しています");
                return true;
            }
            if (((Player) sender).getUniqueId() == parent_uuid) {
                parent.sendMessage("あなたはすでに参加しています");
                return true;
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("join")) {
                    Player player = (Player) sender;
                    this.child = player;
                }
                if (((parent_uuid == null))) {
                    child.sendMessage("まだブラックジャックは開始されていません");
                    return true;
                }
                if (((Player) sender).getUniqueId() == child_uuid) {
                    child.sendMessage("あなたはすでに参加しています");
                    return true;
                }
                if (parent_uuid == parent_uuid) {
                    Bukkit.broadcastMessage(child.getDisplayName() + "さんが参加しました");
                    child_uuid = parent.getUniqueId();
                    b.createInv();
                    parent.openInventory(b.inv);
                    child.openInventory(b.inv2);
                }

                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("open")) {
                        Player player = (Player) sender;
                        if (player.getUniqueId() == parent_uuid) {
                            parent.openInventory(b.inv);
                        }
                        if (player.getUniqueId() == child_uuid) {
                            child.openInventory(b.inv2);
                        }
                    }
                }
            }
        }
        return false;
    }
}