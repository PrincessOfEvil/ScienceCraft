package lazmod.EMS;

import lazmod.ScienceCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EnergyMatterSystem
{
	/* Amounts
	 * Ingot  - 144
	 * Nugget - 144 / 9
	 * Block  - 144 * 9
	 */
	// Energy
	private int energy;		// Generated ONLY by fusion
	// Matter
	private int casing;		// Iron, Steel
	private int conductor;	// Copper, Silver, Gold
	private int core;		// Sand, Glass, Obsidian
	private int carbon;		// Coal, Diamond
	private int omnimatter;	// Can substitute anything
	
	private int maxEnergy;
	private int maxCasing;
	private int maxConductor;
	private int maxCore;
	private int maxCarbon;
	private int maxOmnimatter;
	
	/*
	 * Ctrl+C Ctrl+V
	energy
	casing
	conductor
	core
	carbon
	omnimatter
	
	maxEnergy
	maxCasing
	maxConductor
	maxCore
	maxCarbon
	maxOmnimatter
	
	switch (type)
		{
		case ENERGY		: energy;
		case CASING		: casing;
		case CONDUCTOR	: conductor;
		case CORE		: core;
		case CARBON		: carbon;
		case OMNIMATTER	: omnimatter;
		}
	 */
	
	public static enum EMSType {ENERGY, CASING, CONDUCTOR, CORE, CARBON, OMNIMATTER}
	
	private EntityPlayer player;
		
	public EnergyMatterSystem(EntityPlayer cPlayer, int[] EMS)
		{
		player			= cPlayer;
		
		energy			= EMS[0];
		casing			= EMS[1];
		conductor		= EMS[2];
		core			= EMS[3];
		carbon			= EMS[4];
		omnimatter		= EMS[5];
		
		addToList(cPlayer);
		}
	
	public EnergyMatterSystem(EntityPlayer cPlayer)
		{
		this(cPlayer, new int[]{0,0,0,0,0,0});
		}
	
	private void addToList(EntityPlayer cPlayer)
		{
		ScienceCraft.DateHandler.EMS.put(cPlayer.username, this);
		EMSWaveShooter shooter = new EMSWaveShooter(cPlayer);
		}
	
	public void add(EMSType type, int amount)
		{
		switch (type)
			{
			case ENERGY		: energy	 += amount; if (energy		> maxEnergy		) {energy		= maxEnergy		;} break;
			case CASING		: casing	 += amount; if (casing		> maxCasing		) {casing		= maxCasing		;} break;
			case CONDUCTOR	: conductor	 += amount; if (conductor	> maxConductor	) {conductor	= maxConductor	;} break;
			case CORE		: core		 += amount; if (core		> maxCore		) {core			= maxCore		;} break;
			case CARBON		: carbon	 += amount; if (carbon		> maxCarbon		) {carbon		= maxCarbon		;} break;
			case OMNIMATTER	: omnimatter += amount; if (omnimatter	> maxOmnimatter	) {omnimatter	= maxOmnimatter	;} break;
			}
		}
	public int get(EMSType type)
		{
		switch (type)
			{
			case ENERGY		: return energy;
			case CASING		: return casing;
			case CONDUCTOR	: return conductor;
			case CORE		: return core;
			case CARBON		: return carbon;
			case OMNIMATTER	: return omnimatter;
			}
		return energy;
		}
	public int[] get()
		{
		return new int[]{energy, casing, conductor, core, carbon, omnimatter, maxEnergy, maxCasing, maxConductor, maxCore, maxCarbon, maxOmnimatter};
		}
	public void addMax(EMSType type, int amount)
		{
		switch (type)
			{
			case ENERGY		: maxEnergy		+= amount; break;
			case CASING		: maxCasing		+= amount; break;
			case CONDUCTOR	: maxConductor	+= amount; break;
			case CORE		: maxCore		+= amount; break;
			case CARBON		: maxCarbon		+= amount; break;
			case OMNIMATTER	: maxOmnimatter	+= amount; break;
			}
		}
	public int getMax(EMSType type)
		{
		switch (type)
			{
			case ENERGY		: return maxEnergy;
			case CASING		: return maxCasing;
			case CONDUCTOR	: return maxConductor;
			case CORE		: return maxCore;
			case CARBON		: return maxCarbon;
			case OMNIMATTER	: return maxOmnimatter;
			}
		return energy;
		}
	}