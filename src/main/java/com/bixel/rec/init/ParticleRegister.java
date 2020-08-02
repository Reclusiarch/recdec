package com.bixel.rec.init;

import com.bixel.rec.RecDecMod;
import com.bixel.rec.objects.particles.ColouredParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleRegister 
{
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RecDecMod.MOD_ID);
	/*
	public static final RegistryObject<ParticleType<ColouredParticleData>> CANDLE_FLAME_PARTICLE = PARTICLES.create("candle_flame_particle", () -> 
		new ParticleType<ColouredParticleData>(false, ColouredParticleData.DESERIALIZER));
	
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event)
	{
		Minecraft.getInstance().particles.registerFactory(ParticleRegister.CANDLE_FLAME_PARTICLE.get(), ColouredParticle.Factory::new);
	}*/
}
