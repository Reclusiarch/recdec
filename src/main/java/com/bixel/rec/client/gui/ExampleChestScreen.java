package com.bixel.rec.client.gui;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.container.ExampleChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ExampleChestScreen extends ContainerScreen<ExampleChestContainer>
{
	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(RecDecMod.MOD_ID, "textures/gui/example_chest.png");
	
	public ExampleChestScreen(ExampleChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) 
	{
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 175;
		this.ySize = 183;
	}
	
	//render
	@Override
	public void func_230430_a_(MatrixStack p_230430_1_, final int p_230450_2_, final int p_230450_3_, final float p_230450_4_)
	{
		//draw background
		this.func_230446_a_(p_230430_1_);
		//render
		super.func_230430_a_(p_230430_1_, p_230450_2_, p_230450_3_, p_230450_4_);
		//draw tooltip
		this.func_230451_b_(p_230430_1_, p_230450_2_, p_230450_3_);
	}
	
	//protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	@Override
	protected void func_230459_a_(MatrixStack p_230430_1_, final int p_230450_2_, final int p_230450_3_)
	{
		super.func_230459_a_(p_230430_1_, p_230450_2_, p_230450_3_);
		//this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 4210752);
		this.field_230712_o_.func_238407_a_(p_230430_1_, this.field_230704_d_.func_230531_f_(), 8.0f, 6.0f, 4210752);
		//this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 90.0f, 4210752);
		this.field_230712_o_.func_238407_a_(p_230430_1_, this.playerInventory.getDisplayName().func_230531_f_(), 8.0f, 90.0f, 4210752);
	}

	//protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	@Override
	protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) 
	{
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		//this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		this.field_230706_i_.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		int x = (this.field_230708_k_ - this.xSize) / 2;
		int y = (this.field_230709_l_ - this.ySize) / 2;
		this.func_238468_a_(p_230450_1_, x, y, 0, 0, this.xSize, this.ySize);
	}
}
