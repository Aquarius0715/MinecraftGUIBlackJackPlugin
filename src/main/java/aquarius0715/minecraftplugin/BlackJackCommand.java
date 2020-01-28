package aquarius0715.minecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class BlackJackCommand implements CommandExecutor {

    Player parent;
    Player child;

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
                Bukkit.broadcastMessage(player.getDisplayName() + "さんがブラックジャックを募集しています");
                this.parent = player;


            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("join")) {
                    Player player = (Player) sender;
                    Bukkit.broadcastMessage(player.getDisplayName() + "さんが参加しました");
                    this.child = player;
                }

                BlackJackGameSystem b = new BlackJackGameSystem();
                b.createMyInv();
                b.createYourInv();
                parent.openInventory(b.inv);
                child.openInventory(b.inv2);


            }
        }
        return false;
    }
}
