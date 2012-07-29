package us.hinchy.SpikeBlocks;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.block.SpoutBlock;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.CustomBlock;
import org.getspout.spoutapi.material.MaterialData;
import org.getspout.spoutapi.sound.SoundEffect;

public class SpikeBlocks extends JavaPlugin implements Listener {

	public static CustomBlock spikeBlock;
	
	public static GenericBlockDesign spikeBlockDesign = new GenericBlockDesign();
	
	Logger log = Logger.getLogger("Minecraft");
	
	public static Texture spikeBlockTexture;
	
	public void onEnable() {		
		this.getConfig();
		
		if (this.getConfig().isSet("spikeblock.damage") == false) {
			this.saveDefaultConfig();
			log.info("[SpikeBlocks] Config did not exist or was invalid, default config saved.");
		}
		
		spikeBlockTexture = new Texture(this, getConfig().getString("spikeblock.texture"), getConfig().getInt("spikeblock.size")*2, getConfig().getInt("spikeblock.size"), getConfig().getInt("spikeblock.size"));
		
		spikeBlockDesign.setTexture(this, spikeBlockTexture);
		
		spikeBlockDesign.setQuadNumber(54);
		
		//main body
		
		spikeBlockDesign.setQuad(0,
				(float) 0.25, (float) 0.25, (float) 0.25,
				6, 6,
				(float) 0.25, (float) 0.75, (float) 0.25,
				6, 16,
				(float) 0.75, (float) 0.75, (float) 0.25,
				16, 16,
				(float) 0.75, (float) 0.25, (float) 0.25,
				16, 6,
				16, 16);
		
		spikeBlockDesign.setQuad(1,
				(float) 0.75, (float) 0.25, (float) 0.75,
				6, 6,
				(float) 0.75, (float) 0.75, (float) 0.75,
				6, 16,
				(float) 0.25, (float) 0.75, (float) 0.75,
				16, 16,
				(float) 0.25, (float) 0.25, (float) 0.75,
				16, 6,
				16, 16);
		
		spikeBlockDesign.setQuad(2,
				(float) 0.25, (float) 0.25, (float) 0.75,
				6, 6,
				(float) 0.25, (float) 0.25, (float) 0.25,
				6, 16,
				(float) 0.75, (float) 0.25, (float) 0.25,
				16, 16,
				(float) 0.75, (float) 0.25, (float) 0.75,
				16, 6,
				16, 16);
		
		spikeBlockDesign.setQuad(3,
				(float) 0.25, (float) 0.75, (float) 0.25,
				6, 6,
				(float) 0.25, (float) 0.75, (float) 0.75,
				6, 16,
				(float) 0.75, (float) 0.75, (float) 0.75,
				16, 16,
				(float) 0.75, (float) 0.75, (float) 0.25,
				16, 6,
				16, 16);
		
		spikeBlockDesign.setQuad(4,
				(float) 0.25, (float) 0.25, (float) 0.75,
				6, 6,
				(float) 0.25, (float) 0.75, (float) 0.75,
				6, 16,
				(float) 0.25, (float) 0.75, (float) 0.25,
				16, 16,
				(float) 0.25, (float) 0.25, (float) 0.25,
				16, 6,
				16, 16);
		
		spikeBlockDesign.setQuad(5,
				(float) 0.75, (float) 0.25, (float) 0.25,
				6, 6,
				(float) 0.75, (float) 0.75, (float) 0.25,
				6, 16,
				(float) 0.75, (float) 0.75, (float) 0.75,
				16, 16,
				(float) 0.75, (float) 0.25, (float) 0.75,
				16, 6,
				16, 16);
		
		// corner spike 1
		
		spikeBlockDesign.setQuad(6,
				(float) 0.25, (float) 0.25, (float) 0.40,
				0, 6,
				(float) 0.25, (float) 0.40, (float) 0.25,
				0, 16,
				(float) 0.1, (float) 0.1, (float) 0.1,
				6, 16,
				(float) 0.1, (float) 0.1, (float) 0.1,
				6, 6,
				16, 16);

		int foox1 = 10;
		int foox2 = 0;
		
		int fooy1 = 0;
		int fooy2 = 6;
		
		// corner spike 1
		
		spikeBlockDesign.setQuad(6,
				(float) 0.25, (float) 0.25, (float) 0.40,
				foox1, fooy1,
				(float) 0.25, (float) 0.40, (float) 0.25,
				foox1, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.1,
				foox2, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(7,
				(float) 0.25, (float) 0.40, (float) 0.25,
				foox1, fooy1,
				(float) 0.40, (float) 0.25, (float) 0.25,
				foox1, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.1,
				foox2, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(8,
				(float) 0.40, (float) 0.25, (float) 0.25,
				foox1, fooy1,
				(float) 0.25, (float) 0.25, (float) 0.40,
				foox1, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.1,
				foox2, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		// corner spike 2
		
		spikeBlockDesign.setQuad(9,
				(float) 0.25, (float) 0.60, (float) 0.25,
				foox1, fooy1,
				(float) 0.25, (float) 0.75, (float) 0.40,
				foox1, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.1,
				foox2, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(10,
				(float) 0.40, (float) 0.75, (float) 0.25,
				foox1, fooy1,
				(float) 0.25, (float) 0.60, (float) 0.25,
				foox1, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.1,
				foox2, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(11,
				(float) 0.25, (float) 0.75, (float) 0.40,
				foox1, fooy1,
				(float) 0.40, (float) 0.75, (float) 0.25,
				foox1, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.1,
				foox2, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		// corner spike 3
		
		spikeBlockDesign.setQuad(12,
				(float) 0.75, (float) 0.75, (float) 0.40,
				foox1, fooy1,
				(float) 0.75, (float) 0.60, (float) 0.25,
				foox1, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.1,
				foox2, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(13,
				(float) 0.75, (float) 0.60, (float) 0.25,
				foox1, fooy1,
				(float) 0.60, (float) 0.75, (float) 0.25,
				foox1, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.1,
				foox2, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(14,
				(float) 0.60, (float) 0.75, (float) 0.25,
				foox1, fooy1,
				(float) 0.75, (float) 0.75, (float) 0.40,
				foox1, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.1,
				foox2, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		// corner spike 4
		
		spikeBlockDesign.setQuad(15,
				(float) 0.75, (float) 0.40, (float) 0.25,
				foox1, fooy1,
				(float) 0.75, (float) 0.25, (float) 0.40,
				foox1, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.1,
				foox2, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(16,
				(float) 0.60, (float) 0.25, (float) 0.25,
				foox1, fooy1,
				(float) 0.75, (float) 0.40, (float) 0.25,
				foox1, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.1,
				foox2, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(17,
				(float) 0.75, (float) 0.25, (float) 0.40,
				foox1, fooy1,
				(float) 0.60, (float) 0.25, (float) 0.25,
				foox1, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.1,
				foox2, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.1,
				foox2, fooy1,
				16, 16);
		
		// corner spike 5
		
		spikeBlockDesign.setQuad(18,
				(float) 0.25, (float) 0.40, (float) 0.75,
				foox1, fooy1,
				(float) 0.25, (float) 0.25, (float) 0.60,
				foox1, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.9,
				foox2, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(19,
				(float) 0.40, (float) 0.25, (float) 0.75,
				foox1, fooy1,
				(float) 0.25, (float) 0.40, (float) 0.75,
				foox1, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.9,
				foox2, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(20,
				(float) 0.25, (float) 0.25, (float) 0.60,
				foox1, fooy1,
				(float) 0.40, (float) 0.25, (float) 0.75,
				foox1, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.9,
				foox2, fooy2,
				(float) 0.1, (float) 0.1, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		// corner spike 6
		
		spikeBlockDesign.setQuad(21,
				(float) 0.25, (float) 0.75, (float) 0.60,
				foox1, fooy1,
				(float) 0.25, (float) 0.60, (float) 0.75,
				foox1, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.9,
				foox2, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(22,
				(float) 0.25, (float) 0.60, (float) 0.75,
				foox1, fooy1,
				(float) 0.40, (float) 0.75, (float) 0.75,
				foox1, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.9,
				foox2, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(23,
				(float) 0.40, (float) 0.75, (float) 0.75,
				foox1, fooy1,
				(float) 0.25, (float) 0.75, (float) 0.60,
				foox1, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.9,
				foox2, fooy2,
				(float) 0.1, (float) 0.9, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		// corner spike 7
		
		spikeBlockDesign.setQuad(24,
				(float) 0.75, (float) 0.60, (float) 0.75,
				foox1, fooy1,
				(float) 0.75, (float) 0.75, (float) 0.60,
				foox1, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.9,
				foox2, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(25,
				(float) 0.60, (float) 0.75, (float) 0.75,
				foox1, fooy1,
				(float) 0.75, (float) 0.60, (float) 0.75,
				foox1, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.9,
				foox2, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(26,
				(float) 0.75, (float) 0.75, (float) 0.60,
				foox1, fooy1,
				(float) 0.60, (float) 0.75, (float) 0.75,
				foox1, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.9,
				foox2, fooy2,
				(float) 0.9, (float) 0.9, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		// corner spike 8
		
		spikeBlockDesign.setQuad(27,
				(float) 0.75, (float) 0.25, (float) 0.60,
				foox1, fooy1,
				(float) 0.75, (float) 0.40, (float) 0.75,
				foox1, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.9,
				foox2, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(28,
				(float) 0.75, (float) 0.40, (float) 0.75,
				foox1, fooy1,
				(float) 0.60, (float) 0.25, (float) 0.75,
				foox1, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.9,
				foox2, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		spikeBlockDesign.setQuad(29,
				(float) 0.60, (float) 0.25, (float) 0.75,
				foox1, fooy1,
				(float) 0.75, (float) 0.25, (float) 0.60,
				foox1, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.9,
				foox2, fooy2,
				(float) 0.9, (float) 0.1, (float) 0.9,
				foox2, fooy1,
				16, 16);
		
		// side spike 1

		spikeBlockDesign.setQuad(30,
				(float) 0.60, (float) 0.40, (float) 0.25,
				foox1, fooy1,
				(float) 0.40, (float) 0.40, (float) 0.25,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(31,
				(float) 0.40, (float) 0.40, (float) 0.25,
				foox1, fooy1,
				(float) 0.40, (float) 0.60, (float) 0.25,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(32,
				(float) 0.60, (float) 0.60, (float) 0.25,
				foox1, fooy1,
				(float) 0.60, (float) 0.40, (float) 0.25,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(33,
				(float) 0.40, (float) 0.60, (float) 0.25,
				foox1, fooy1,
				(float) 0.60, (float) 0.60, (float) 0.25,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 0,
				foox2, fooy1,
				16, 16);
		
		// side spike 2

		spikeBlockDesign.setQuad(34,
				(float) 0.40, (float) 0.40, (float) 0.75,
				foox1, fooy1,
				(float) 0.60, (float) 0.40, (float) 0.75,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(35,
				(float) 0.40, (float) 0.60, (float) 0.75,
				foox1, fooy1,
				(float) 0.40, (float) 0.40, (float) 0.75,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(36,
				(float) 0.60, (float) 0.40, (float) 0.75,
				foox1, fooy1,
				(float) 0.60, (float) 0.60, (float) 0.75,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(37,
				(float) 0.60, (float) 0.60, (float) 0.75,
				foox1, fooy1,
				(float) 0.40, (float) 0.60, (float) 0.75,
				foox1, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy2,
				(float) 0.5, (float) 0.5, 1,
				foox2, fooy1,
				16, 16);
		
		// side spike 3

		spikeBlockDesign.setQuad(38,
				(float) 0.40, (float) 0.25, (float) 0.40, 
				foox1, fooy1,
				(float) 0.60, (float) 0.25, (float) 0.40,
				foox1, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(39,
				(float) 0.40, (float) 0.25, (float) 0.60,
				foox1, fooy1,
				(float) 0.40, (float) 0.25, (float) 0.40,
				foox1, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(40,
				(float) 0.60, (float) 0.25, (float) 0.40,
				foox1, fooy1,
				(float) 0.60, (float) 0.25, (float) 0.60,
				foox1, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(41,
				(float) 0.60, (float) 0.25, (float) 0.60,
				foox1, fooy1,
				(float) 0.40, (float) 0.25, (float) 0.60,
				foox1, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 0, (float) 0.5,
				foox2, fooy1,
				16, 16);
		
		// side spike 4

		spikeBlockDesign.setQuad(42,
				(float) 0.60, (float) 0.75, (float) 0.40,
				foox1, fooy1,
				(float) 0.40, (float) 0.75, (float) 0.40, 
				foox1, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(43,
				(float) 0.40, (float) 0.75, (float) 0.40,
				foox1, fooy1,
				(float) 0.40, (float) 0.75, (float) 0.60,
				foox1, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(44,
				(float) 0.60, (float) 0.75, (float) 0.60,
				foox1, fooy1,
				(float) 0.60, (float) 0.75, (float) 0.40,
				foox1, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(45,
				(float) 0.40, (float) 0.75, (float) 0.60,
				foox1, fooy1,
				(float) 0.60, (float) 0.75, (float) 0.60,
				foox1, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy2,
				(float) 0.5, 1, (float) 0.5,
				foox2, fooy1,
				16, 16);
		
		// side spike 5

		spikeBlockDesign.setQuad(46,
				(float) 0.25, (float) 0.60, (float) 0.40,
				foox1, fooy1,
				(float) 0.25, (float) 0.40, (float) 0.40,
				foox1, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(47,
				(float) 0.25, (float) 0.40, (float) 0.40,
				foox1, fooy1,
				(float) 0.25, (float) 0.40, (float) 0.60,
				foox1, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(48,
				(float) 0.25, (float) 0.60, (float) 0.60,
				foox1, fooy1,
				(float) 0.25, (float) 0.60, (float) 0.40,
				foox1, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(49,
				(float) 0.25, (float) 0.40, (float) 0.60,
				foox1, fooy1,
				(float) 0.25, (float) 0.60, (float) 0.60,
				foox1, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				0, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);
		
		// side spike 6

		spikeBlockDesign.setQuad(50,
				(float) 0.75, (float) 0.40, (float) 0.40,
				foox1, fooy1,
				(float) 0.75, (float) 0.60, (float) 0.40,
				foox1, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(51,
				(float) 0.75, (float) 0.40, (float) 0.60,
				foox1, fooy1,
				(float) 0.75, (float) 0.40, (float) 0.40,
				foox1, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(52,
				(float) 0.75, (float) 0.60, (float) 0.40,
				foox1, fooy1,
				(float) 0.75, (float) 0.60, (float) 0.60,
				foox1, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);

		spikeBlockDesign.setQuad(53,
				(float) 0.75, (float) 0.60, (float) 0.60,
				foox1, fooy1,
				(float) 0.75, (float) 0.40, (float) 0.60,
				foox1, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy2,
				1, (float) 0.5, (float) 0.5,
				foox2, fooy1,
				16, 16);
	
		spikeBlock = new SpikeBlock(this,spikeBlockDesign,spikeBlockTexture);
		spikeBlock.setLightLevel(0).setStepSound(SoundEffect.HURT).setHardness((float) 0.5);
		
        SpoutShapedRecipe recipe = new SpoutShapedRecipe(new SpoutItemStack(spikeBlock, 4));
        recipe.shape("I I", " O ", "I I");
        recipe.setIngredient('I', MaterialData.ironIngot);
        recipe.setIngredient('O', MaterialData.obsidian);
        SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
        
        getServer().getPluginManager().registerEvents(this, this);
		
		log.info("[SpikeBlocks] Version 1.0.0 by Zach Hinchy (http://hinchy.us/) enabled.");
	}
	
	public void onDisable() {
		log.info("[SpikeBlocks] SpikeBlocks has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (cmd.getName().equalsIgnoreCase("spikereload")) {
			this.reloadConfig();
			sender.sendMessage("SpikeBlocks configuration reloaded.");
			return true;
		}
		return false; 
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		boolean doHurt = false;
		
		SpoutBlock sb = (SpoutBlock) event.getPlayer().getLocation().add(0,-1,0).getBlock();
		
		if (sb.getCustomBlock() != null) {
    		if (sb.getCustomBlock() instanceof SpikeBlock) {
    			doHurt = true;
    		}
    	} 
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0,0,0.5).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0,0,-0.5).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0.5,0,0).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(-0.5,0,0).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0,1,0.5).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	} 
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0,1,-0.5).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0.5,1,0).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(-0.5,1,0).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
		if (!doHurt) {
			sb = (SpoutBlock) event.getPlayer().getLocation().add(0,1.8,0).getBlock();
			
			if (sb.getCustomBlock() != null) {
	    		if (sb.getCustomBlock() instanceof SpikeBlock) {
	    			doHurt = true;
	    		}
	    	}
		}
		
	    if (doHurt) event.getPlayer().damage(getConfig().getInt("spikeblock.damage"));
	}
}
