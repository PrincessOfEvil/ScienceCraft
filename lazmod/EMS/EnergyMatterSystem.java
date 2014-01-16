package lazmod.EMS;

import lazmod.ScienceCraft;
import net.minecraft.entity.player.EntityPlayer;

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
	
	enum EMSType {ENERGY, CASING, CONDUCTOR, CORE, CARBON, OMNIMATTER}
	
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
		
		maxEnergy		= EMS[6];
		maxCasing		= EMS[7];
		maxConductor	= EMS[8];
		maxCore			= EMS[9];
		maxCarbon		= EMS[10];
		maxOmnimatter	= EMS[11];
		
		addToList(cPlayer);
		}
	
	public EnergyMatterSystem(EntityPlayer cPlayer)
		{
		this(cPlayer, new int[]{0,0,0,0,0,0, 0,0,0,0,0,0});
		}
	
	private void addToList(EntityPlayer cPlayer)
		{
		ScienceCraft.DateHandler.EMS.put(cPlayer.username, this);
		}
	
	public void add(EMSType type, int amount)
		{
		switch (type)
			{
			case ENERGY		: energy	 += amount; break;
			case CASING		: casing	 += amount; break;
			case CONDUCTOR	: conductor	 += amount; break;
			case CORE		: core		 += amount; break;
			case CARBON		: carbon	 += amount; break;
			case OMNIMATTER	: omnimatter += amount; break;
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