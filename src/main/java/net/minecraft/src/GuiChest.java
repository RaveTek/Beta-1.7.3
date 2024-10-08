package net.minecraft.src;

import net.PeytonPlayz585.opengl.GL11;
import net.PeytonPlayz585.textures.TextureLocation;

public class GuiChest extends GuiContainer {
	
	private static final TextureLocation containerTexture = new TextureLocation("/gui/container.png");
	
	private IInventory upperChestInventory;
	private IInventory lowerChestInventory;
	private int inventoryRows = 0;

	public GuiChest(IInventory var1, IInventory var2) {
		super(new ContainerChest(var1, var2));
		this.upperChestInventory = var1;
		this.lowerChestInventory = var2;
		this.field_948_f = false;
		short var3 = 222;
		int var4 = var3 - 108;
		this.inventoryRows = var2.getSizeInventory() / 9;
		this.ySize = var4 + this.inventoryRows * 18;
	}

	protected void drawGuiContainerForegroundLayer() {
		this.fontRenderer.drawString(this.lowerChestInventory.getInvName(), 8, 6, 4210752);
		this.fontRenderer.drawString(this.upperChestInventory.getInvName(), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float var1) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		containerTexture.bindTexture();
		int var3 = (this.width - this.xSize) / 2;
		int var4 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var3, var4, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.drawTexturedModalRect(var3, var4 + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
	}
}
