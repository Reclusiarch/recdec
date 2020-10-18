package com.bixel.rec.client.gui;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.container.VillageBarrelContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class VillageBarrelScreen extends ContainerScreen<VillageBarrelContainer>
{
	private static final ResourceLocation BACKGROUND_TEXTURE = RecDecMod.loc("textures/gui/example_chest.png");
	
	public VillageBarrelScreen(VillageBarrelContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) 
	{
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 175;
		this.ySize = 183;
	}
	
	@Override
	public void render(MatrixStack p_230430_1_, int mouseX, int mouseY, float partialTicks) 
	{
		//draw background
		this.renderBackground(p_230430_1_);
		//render
		super.render(p_230430_1_, mouseX, mouseY, partialTicks);
		//draw tooltip
		this.renderHoveredTooltip(p_230430_1_, mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) 
	{
		//super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY); 
		//this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 4210752);
		this.font.drawString(matrixStack, this.getTitle().getUnformattedComponentText(), 8.0f, 8.0f, 0x404040);
		//this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 90.0f, 4210752);
		this.font.drawString(matrixStack, this.playerInventory.getDisplayName().getString(), 8.0f, 91.0f, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) 
	{
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		int size_x = (this.width - this.xSize) / 2;
		int size_y = (this.height - this.ySize) / 2;
		blit(matrixStack,size_x, size_y, 0, 0, this.xSize, this.ySize);
	}
}
