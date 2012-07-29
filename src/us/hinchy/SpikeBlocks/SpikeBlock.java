package us.hinchy.SpikeBlocks;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.BlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class SpikeBlock extends GenericCustomBlock {
    public SpikeBlock(Plugin plugin, BlockDesign design, Texture texture) {
        super(plugin, "Spike Block", 20, design.setRenderPass(1));
    }
}