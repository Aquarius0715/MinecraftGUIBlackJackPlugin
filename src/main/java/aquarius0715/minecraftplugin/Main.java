package aquarius0715.minecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class Main extends JavaPlugin implements Listener {


    public Inventory inv;
    //アイテムの座標
    public int coordinate = 45;
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
    //点数
    int my_score;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        createInv();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("blackjack")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
            }
            Player player = (Player) sender;
            player.openInventory(inv);
            return true;
        }
        return false;
    }

    @EventHandler()
    public void onClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        switch (event.getSlot()) {

            case 28:
                if (my_score > 21) {
                    BUST_meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "バスト");
                    BUST.setItemMeta(BUST_meta);
                    inv.setItem(31, BUST);
                    break;
                }
                int card_number = new Random().nextInt(13);
                String card_number_word = Integer.toString(card_number + 1);
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

                break;

        }
    }

    public void createInv() {


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

        int card_number = new Random().nextInt(13);
        String card_number_word = Integer.toString(card_number + 1);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word);
        card.setItemMeta(card_meta);
        inv.setItem(coordinate, card);

        int card_number1 = new Random().nextInt(13);
        String card_number_word1 = Integer.toString(card_number1 + 1);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word1);
        card.setItemMeta(card_meta);
        coordinate++;
        inv.setItem(coordinate, card);

        //相手のカードの作成

        int card_number2 = new Random().nextInt(13);
        String card_number_word2 = Integer.toString(card_number2 + 1);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word2);
        card.setItemMeta(card_meta);
        inv.setItem(8, card);

        int card_number3 = new Random().nextInt(13);
        String card_number_word3 = Integer.toString(card_number3 + 1);
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + card_number_word3);
        card.setItemMeta(card_meta);
        inv.setItem(7, card);

        //自分のカードの合計を作成
        my_score = card_number + card_number1;
        card_meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "自分のスコアは" + my_score);
        card.setItemMeta(card_meta);
        inv.setItem(31, card);

        //相手のカードの合計を作成

        int your_score = card_number2 + card_number3;
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

}
