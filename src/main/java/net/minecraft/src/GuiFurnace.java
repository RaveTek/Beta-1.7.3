package net.minecraft.src;

import net.PeytonPlayz585.opengl.GL11;
import net.PeytonPlayz585.textures.TextureLocation;

public class GuiFurnace extends GuiContainer {
	
	private static final TextureLocation containerTexture = new TextureLocation("/gui/furnace.png");
	
	private TileEntityFurnace furnaceInventory;

	public GuiFurnace(InventoryPlayer var1, TileEntityFurnace var2) {
		super(new ContainerFurnace(var1, var2));
		this.furnaceInventory = var2;
	}

	protected void drawGuiContainerForegroundLayer() {
		this.fontRenderer.drawString("Furnace", 60, 6, 4210752);
		this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		containerTexture.bindTexture();
		int var3 = (this.width - this.xSize) / 2;
		int var4 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var3, var4, 0, 0, this.xSize, this.ySize);
		int var5;
		if(this.furnaceInventory.isBurning()) {
			var5 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(var3 + 56, var4 + 36 + 12 - var5, 176, 12 - var5, 14, var5 + 2);
		}

		var5 = this.furnaceInventory.getCookProgressScaled(24);
		this.drawTexturedModalRect(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
	}
}
