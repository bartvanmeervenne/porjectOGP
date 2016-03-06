package hillbillies.model;

import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * a class that holds the information of the units
 * @invar 	the maximal hitpoints a unit can have is a valid number of hitpoints
 * 			|isValidMaxHit(getMaxHitpoints())
 * @invar 	the current hitpoints of a unit must be a valid value 
 * 			|isValidHitpoints(getHitpoints(),getMaxHitpoints())
 * @invar 	the maximal stamina a unit can have is a valid number of stamina
 * 			|isValidMaxstam(getMaxStamina())
 * @invar 	the current stamina of a unit must be a valid value 
 * 			|isValidStamina(getStamina(),getMaxStamina())
 * @author rik
 *
 */
public class Unit {
	/**
	 * initializes a new unit with given position, name, weight, strength, agility, toughness
	 * @param position
	 * 			the position for this new unit
	 * @param name
	 * 			the name for this new unit
	 * @param weight
	 * 			the weight for this new unit
	 * @param strength
	 * 			the strength for this new unit
	 * @param agility
	 * 			the agility for this new unit
	 * @param toughness
	 * 			the toughness for this new unit
	 * @return 
	 * @post the position of the new unit is equal to the given position
	 * 			|new.position = position
	 * @post the name of the new unit is equal to the given position
	 * 			|new.position = position
	 * @post if the given weight, is greater then the maximum initial position the weight is 
	 * 			set to the maximum possible weight 
	 * 			|if (weight > getMaxInitialStat()){
	 *			|then	setWeight(getMaxInitialStat());
	 * @post if the given weight is smaller then the minimum initial position the weight is 
	 * 			set to the minimum possible weight 
	 * 			|if (weight > getMaxInitialStat()){
	 *			|then	setWeight(getMaxInitialStat());
	 * @post if the given weight is in between the minimum an maximum weight the weight 
	 * 			of the unit  will be set too the given weight
	 * 			|else:
	 * 			|setWeight(weight);
	 * @post for strength, agility, toughness the same goes as for weight
	 * @post the angle is set to pi/2
	 * 			|setAngle(pi/2)
	 * @post hitpoints is set to the maximum number of hitpoints a this unit can have
	 * 			|setHitpoints(getMaxHitpoint())
	 * @post stamina is set to the maximum number of stamina a this unit can have
	 * 			|setStamina(getMaxStamina())
	 */
	public  Unit(int[] position,String name,int weight,int strength,
			int agility,int toughness ){
		double[] pos = {position[0],position[1],position[2]};
		setPosition(pos);
		setName(name);
		if (strength > getMaxInitialStat()){
			setStrength(getMaxInitialStat());
		}
		if (strength < getMinInitialStat()){
			setStrength(getMinInitialStat());
		}
		else{
			setStrength(strength);
		}
		if (agility > getMaxInitialStat()){
			setAgility(getMaxInitialStat());
		}
		if (agility < getMinInitialStat()){
			setAgility(getMinInitialStat());
		}
		else{
			setAgility(agility);
		}
		if (toughness > getMaxInitialStat()){
			setToughness(getMaxInitialStat());
		}
		if (toughness < getMinInitialStat()){
			setToughness(getMinInitialStat());
		}
		else{
			setToughness(toughness);
		}
		if (weight > getMaxInitialStat()){
			setWeight(getMaxInitialStat());
		}
		if (weight < getMinInitialStat()){
			setWeight(getMinInitialStat());
		}
		else{
			setWeight(weight);
		}
		setAngle((float) (Math.PI / 2));
		setHitpoints(getMaxHitpoints());
		setStamina(getMaxStamina());
	}
			
		
	/**
	 * 
	 * @return the exact position of a unit
	 */
	@Basic @Raw
	public double[] getPosition(){
		double[] ret = {this.posX ,this.posY ,this.posZ};
		return ret;
	}

	
/**
 * 
 * @param 	posX
 * 			the x position of a unit
 * @param	posY
 *  		the y position of a unit
 * @param 	posZ
 *  		the z position of a unit
 * @post 	the new x position of the unit is equal to the given x position
 * 			|new.getposition[0] = posX
 * @post 	the new y position of the unit is equal to the given y position
 * 			|new.getposition[1] = posY
 * @post 	the new z position of the unit is equal to the given z position
 * 			|new.getposition[2] = posZ
 * @throws 	IllegalArgumentExeption
 * 			|!isValidPosition()
 */
	public void setPosition(double[] position)throws IllegalArgumentException{
		if (!isValidPosition(position)){
			throw new IllegalArgumentException();
		}
		this.posX = position[0];
		this.posY = position[1];
		this.posZ = position[2];
	}
	
	/**
	 * 
	 * @param Position
	 * 			the position of a unit
	 * @return true if end only if the given position is in the gameworld
	 * 			|result ==
	 * 			|((position[0] >= 0)&&(position[0] < 50)
	 * 			|&& (position[1] >= 0)&&(position[1] < 50)
	 * 			|&& (position[2] >= 0)&&(position[2] < 50))
	 */
	public boolean isValidPosition(double[] position){
		return ((position[0] >= 0)&&(position[0] < 50)
				&& (position[1] >= 0)&&(position[1] < 50)&& (position[2] >= 0)&&(position[2] < 50));
	}
	/**
	 * 
	 * @return the the position of the cube in witch a unit is
	 */
	public int[] getCubePosition(){
		int[] ret = {(int)this.posX,(int)this.posY ,(int)this.posZ};
		return ret;
	}
	private double posX;
	private double posY;
	private double posZ;
	/**
	 * naam defensief progr
	 */
	/**
	 * 
	 * @param 	name
	 * 			the name for the unit
	 * @post 	the new name of the unit is equal to the given name
	 * 			|new.getName() == name
	 * @throws illegalArgumentException()
	 * 			illigalArgumentException()
	 */
	public void setName(String name){
		if (!isValidName(name)){
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
	/**
	 * 
	 * @return the name of the unit
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * 
	 * @param name
	 * @return true if and only if the symbols used in name are all in an array of allowed symbols,
	 * 			and the first symbol is capital and the length is at least two
	 */
	public boolean isValidName(String name){
		String[] allowedsymb = {" ","\"" ,"\'","a","z","e","r","t","y","u","i","o","p","q"
				,"s","d","f","g","h","j","k","l","m","w","x","c","v","b","n","A","Z","E"
				,"R","T","Y","U","O","P","Q","S","D","F","G","H","J","K","L","M","W","X","C","V","B","N"};		
		String[] letters = name.split("");
		if (letters.length < 2){
			return false;
		}
		if (letters[0]!=letters[0].toUpperCase()){
			return false;
		}
		for(String i : letters){
			boolean contained = false;
				for (String j : allowedsymb){
					if (i.equals(j)){
						contained = true;
					}
				}
			if (!contained){
				return false;
			}
		}
		return true;
	}
	private String name;
	/**
	 * weight totaal progr
	 * returns the weight of the unit
	 */
	@Basic
	public int getWeight(){
		return this.weight;
	}
	/**
	 * 
	 * @return the lowest possible value of weight for all units is 
	 * 			(getStrength()+getAgility())/2
	 */
	@Basic
	public int getMinWeight(){
		return (int)(((getStrength()+getAgility())/2)+1);
	}
	/**
	 * 
	 * @return the highest possible value of weight is 200
	 * 			must be greater then getMinWeight() 
	 */
	@Basic
	public static int getMaxWeight(){
		return 200;
	}
	/**
	 * 
	 * @param weight
	 * 			the new weight for this unit
	 * @post if the given weight is equal to or greater then the minimum weight and equal too or smaller then maximum weight,
	 * 			the weight new of this unit is equal to the given weight
	 * 			| if ((weight >= getMinWeight())&&(weight <= getMaxWeight))
	 * 			|		then new.getWeight()= weight
	 * @post 	if the given weight is smaller then the minimum weight
	 * 			the new weight is set to the minimum weight
	 * 			|if (weight < getMinWeight())
	 * 			|	new.weight = getMinWeight()
	 * @post	if the given weight is greater then the maximum weight
	 * 			the new weight is set to the maximum weight
	 * 			|if (weight < getMaxWeight())
	 * 			|	new.weight = getMaxWeight()
	 * 
	 */
	public void setWeight(int weight){
		if (weight < getMinWeight()){
			this.weight = getMinWeight(); 
		}
		else if (weight > getMaxWeight()){
			this.weight = getMaxWeight();
		}
		else {
			this.weight = weight;
		}
	}
	private int weight;
	/**
	 * Strength totaal progr
	 * returns the strength of the unit
	 */
	public int getStrength(){
		return this.strength;
	}
	/**
	 * 
	 * @return the lowest possible value of strength of a unit is 1
	 */
	@Basic
	public static int getMinStrength(){
		return 1;
	}
	/**
	 * 
	 * @return the highest possible value of strength of a unit is 200
	 * 			must be greater then getMinStrentgh()
	 */
	@Basic
	public static int getMaxStrength(){
		return 200;
	}
	/**
	 * 
	 * @param strength
	 * 			the new strength for this unit
	 * @post if the given strength is equal to or greater then the minimum strength and equal too or smaller then maximum strength,
	 * 			the new strength of this unit is equal to the given strength
	 * 			| if ((strength >= getMinStrength())&&(strength <= getMaxStrength))
	 * 			|		then new.getStrength()= strength
	 * @post 	if the given strength is smaller then the minimum strength
	 * 			the new strength is set to the minimum strength
	 * 			|if (strength < getMinStrength())
	 * 			|	new.strength = getMinStrength()
	 * @post	if the given strength is greater then the maximum strength
	 * 			the new strength is set to the maximum strength
	 * 			|if (strength < getMaxStrength())
	 * 			|	new.strength = getMaxStrength()
	 * 
	 */
	public void setStrength(int strength){
		if (strength < getMinStrength()){
			this.strength = getMinStrength(); 
		}
		else if (strength > getMaxStrength()){
			this.strength = getMaxStrength();
		}
		else {
			this.strength = strength;
		}
	}
	private int strength;
	/**
	 * agility totaal progr
	 * returns the agility of the unit
	 */
	@Basic
	public int getAgility(){
		return this.agility;
	}
	/**
	 * 
	 * @return the lowest possible value of the agility of the unit is 1
	 */
	@Basic
	public static int getMinAgility(){
		return 1;
	}
	/**
	 * 
	 * @return the highest possible value of agility of the unit is 200
	 * 			must be greater then getMinAgiliy()
	 */
	@Basic
	public static int getMaxAgility(){
		return 200;
	}
	/**
	 * 
	 * @param agility
	 * 			the new agility for this unit
	 * @post if the given agility is equal to or greater then the minimum agility and equal too or smaller then maximum agility,
	 * 			the new agility of this unit is equal to the given agility
	 * 			| if ((agility >= getMinAgility())&&(agility <= getMaxAgility))
	 * 			|		then new.getAgility()= agility
	 * @post 	if the given agility is smaller then the minimum agility
	 * 			the new agility is set to the minimum agility
	 * 			|if (agility < getMinAgility())
	 * 			|	new.agility = getMinAgility()
	 * @post	if the given agility is greater then the maximum agility
	 * 			the new agility is set to the maximum agility
	 * 			|if (agility < getMaxAgility())
	 * 			|	new.agility = getMaxAgility()
	 * 
	 */
	public void setAgility(int agility){
		if (agility < getMinAgility()){
			this.agility = getMinAgility(); 
		}
		else if (agility > getMaxAgility()){
			this.agility = getMaxAgility();
		}
		else {
			this.agility = agility;
		}
	}
	private int agility;
	/**
	 * toughness totaal progr
	 * 
	 * returns the toughness of the unit
	 */
	@Basic
	public int getToughness(){
		return this.toughness;
	}
	/**
	 * 
	 * @return the lowest possible value of toughness of a unit is 1
	 */
	@Basic
	public static int getMinToughness(){
		return 1;
	}
	/**
	 * 
	 * @return the highest value of toughness of a unit is 200
	 */
	@Basic 
	public static int getMaxToughness(){
		return 200;
	}
	/**
	 * 
	 * @param toughness
	 * 			the new toughness for this unit
	 * @post if the given toughness is equal to or greater then the minimum toughness and equal too or smaller then maximum toughness,
	 * 			the new toughness of this unit is equal to the given toughness
	 * 			| if ((toughness >= getMinToughness())&&(toughness <= getMaxToughness))
	 * 			|		then new.getToughness()= toughness
	 * @post 	if the given toughness is smaller then the minimum toughness
	 * 			the new toughness is set to the minimum toughness
	 * 			|if (toughness < getMinToughness())
	 * 			|	new.toughness = getMinToughness()
	 * @post	if the given toughness is greater then the maximum toughness
	 * 			the new toughness is set to the maximum toughness
	 * 			|if (toughness < getMaxToughness())
	 * 			|	new.toughness = getMaxToughness()
	 */
	public void setToughness(int toughness){
		if (toughness < getMinToughness()){
			this.toughness = getMinToughness(); 
		}
		else if (toughness > getMaxToughness()){
			this.toughness = getMaxToughness();
		}
		else {
			this.toughness = toughness;
		}
	}
	private int toughness;
	public int getMaxInitialStat(){
		return 100;
	}
	public int getMinInitialStat(){
		return 25;
	}
	
	/**
	 *hitpoints nominaal progr
	 * return the maximal number of hitpoints a unit can have
	 */
	@Basic @Raw
	public int getMaxHitpoints(){
		maxhit = (int)(200*(getWeight()/100)*(getToughness()/100)+1);
		return maxhit;
	}
	/**
	 * @param maxhit
	 * 			the maximum hitpoints to check
	 * @return True if and only if the given maxhit is positive.
     *       | result == (maxhit > 0)	
	 */
	public boolean isValidMaxHit(int maxhit){
		return maxhit > 0;
	}
	private int maxhit;
	/**
	 * 
	 * @return the current amount of hitpoints of the unit
	 */
	@Basic @Raw
	public double getHitpoints(){
		return this.hitpoints;
	}
	/**
	 * 
	 * @param 	hitpoints
	 * 			the current 
	 * @param 	maxhit
	 * 			the maximum number of hitpoints a unit can have
	 * @return 	true if hitpoints is not negative and does not exceed the maximum number of hitpoints
	 * 			| result == (hitpoints >= 0)&&(hitpoints <= maxhit)
	 */
	public boolean isValidHitpoints(double hitpoints,float maxhit){
		return (hitpoints >= 0)&&(hitpoints <= maxhit);
	}
	/**
	 * 
	 * @param 	hitpoints
	 * 			the new number of hitpoints of a unit
	 * @pre 	the given hitpoints must be a valid number of hitpoints for the unit
	 * 			| isValidHitpoints(hitpoints,getMaxHitpoints())
	 * @post	The hitpoints of this unit is equal to the given
     * 		   	hitpoints.
     *       	| new.getHitpoints() == hitpoints
     * 
	 */
	public void setHitpoints(double hitpoints){
		assert isValidHitpoints(hitpoints,getMaxHitpoints());
		this.hitpoints = hitpoints;
	}
	private double hitpoints;
	/**
	 * stamina nominaal progr
	 * 
	 */
	@Basic 
	public int getMaxStamina(){
		maxstam = (int)(200*(getWeight()/100)*(getToughness()/100)+1);
		return maxstam;
	}
	/**
	 * @param maxstam
	 * 			the maximum stamina to check
	 * @return True if and only if the given maxstam is positive.
     *       | result == (maxstam > 0)	
	 */
	public boolean isValidMaxStam(int maxstam){
		return maxstam > 0;
	}
	private int maxstam;
	/**
	 * 
	 * @return the current amount of stamina of the unit
	 */
	@Basic @Raw
	public double getStamina(){
		return this.stamina;
	}
	/**
	 * 
	 * @param 	stamina
	 * 			the current 
	 * @param 	maxstam
	 * 			the maximum number of stamina a unit can have
	 * @return 	true if stamina is not negative and does not exceed the maximum number of stamina
	 * 			| result == (stamina >= 0)&&(stamina <= maxstam)
	 */
	public boolean isValidStamina(float stamina,float maxstam){
		return (stamina >= 0)&&(stamina <= maxstam);
	}
	/**
	 * 
	 * @param 	stamina
	 * 			the new number of stamina of a unit
	 * @pre 	the given stamina must be a valid number of stamina for the unit
	 * 			| isValidStamina(stamina,getMaxStamina())
	 * @post	The stamina of this unit is equal to the given
     * 		   	stamina.
     *       	| new.getStamina() == stamina
     * 
	 */
	public void setStamina(double stamina){
		assert isValidHitpoints(stamina,getMaxStamina());
		this.stamina = stamina;
	}
	private double stamina;
	/**
	 * totaal progr & float nrs
	 * returns the angle of orentation of a unit
	 */
	@Basic
	public float getAngle(){
		return this.angle;
	}
	/**
	 * 
	 * @return 	the lowest possible value an angle can have
	 * 			is -pi/2
	 * 			| result >= - pi/2
	 */
	public float getMinAngle(){
		return (float) ((Math.PI)*1/2.0);
	}
	/**
	 * 
	 * @returnthe 	highest possible value an angle can have
	 * 				is -3pi/2
	 * 				| result >=  5pi/2
	 */
	public float getMaxAngle(){
		return (float) (-3*(Math.PI)*1/2.0);
	}
	/**
	 * 
	 * @param 	atheta
	 * 			the new angle to be set
	 * @post 	if the given angle is between the mimimum and maximum angle 
	 * 			the angle of the unit is equal to the given angle
	 * 			|if ( (angle >= getMinAngle()) && (angle <= getMaxAngle()) )
	 *        	| 	then new.getAngle() == angle
	 * @post	if the given angle is greater then the maximum angle
	 * 			the angle of the unit is equal to 
	 * 			(angle - getMinAngle())%(getMaxAngle()-getMinAngle())+getMinAngle()
	 * 			|if angle > getMaxAngle
	 * 			| 		then new.angle= (angle - getMinAngle())%(getMaxAngle()-getMinAngle())+getMinAngle()
	 * @post	if the given angle is smaller then the minimum angle 
	 * 			the angle of the unit is equal to
	 * 			(angle - getMaxAngle())%(getMinAngle()-getMaxAngle())+getMaxAngle()
	 * 			|if angle < getMinAngle
	 * 			|		then new.angle= (angle - getMaxAngle())%(getMinAngle()-getMaxAngle())+getMaxAngle()
	 */
	public void setAngle(float atheta){
		if (atheta >= getMaxAngle()){
			atheta = (atheta - getMinAngle())%(getMaxAngle()-getMinAngle())+getMinAngle();
		}
		else if (atheta < getMinAngle()){
			atheta = (atheta - getMaxAngle())%(getMinAngle()-getMaxAngle())+getMaxAngle();
		}
		this.angle = atheta;
	}
	private float angle;

	/**
	 * 
	 * @param 	deltaT
	 * 			a given duration
	 * @post all the stats for the unit are updated to a new value depending on the time
	 * @throws IllegalArgumentException
	 * 			|(deltaT > 0.2 || deltaT < 0)
	 */
	public void advanceTime(double deltaT)throws IllegalArgumentException {
		if (deltaT > 0.2 || deltaT < 0){
			throw new IllegalArgumentException();
		}
		if (isMoving()){
			if (!isSprinting()){
				for (int i =0;i < 3; i++){
					if (velocity[i] < 0){
						if (getPosition()[i]+velocity[i]*deltaT < getDestination()[i]){
							setPosition(getDestination());
							double[] velo = {0,0,0};
							setVelocity(velo);
						}
						else {
							double[] newpos = getPosition();
							newpos[i] = getPosition()[i]+velocity[i]*deltaT;
							setPosition(newpos);			
						}
				}
					else if (velocity[i] > 0){
						if (getPosition()[i]+velocity[i]*deltaT > getDestination()[i]){
							setPosition(getDestination());
							double[] velo = {0,0,0};
							setVelocity(velo);
						}
						else {
							double[] newpos = getPosition();
							newpos[i] = getPosition()[i]+velocity[i]*deltaT;
							setPosition(newpos);
						}
					}
				}
			}
			else {
				double newstam = getStamina()- deltaT;
				if (newstam < 0){
					newstam = 0;
				}
				setStamina(newstam);
				for (int i =0;i < 3; i++){
					if (getVelocity()[i] < 0){
						if (getPosition()[i]+getVelocity()[i]*2*deltaT < getDestination()[i]){
							setPosition(getDestination());
							double[] velo = {0,0,0};
							setVelocity(velo);
						}
						else {
							double[] newpos = getPosition();
							newpos[i] = getPosition()[i]+getVelocity()[i]*2*deltaT;
							setPosition(newpos);			
						}
					}
					else if (getVelocity()[i] > 0){
						if (getPosition()[i]+getVelocity()[i]*2*deltaT > getDestination()[i]){
							setPosition(getDestination());
							double[] velo = {0,0,0};
							setVelocity(velo);
						}
						else {
							double[] newpos = getPosition();
							newpos[i] = getPosition()[i]+getVelocity()[i]*2*deltaT;
							setPosition(newpos);
						}	
					}
				}
			}
			
		}
		
		else if (isWorking()){
			if (this.activityStatus == "working"){
				double workTime;
				workTime = 0;
				while (workTime <= (500/this.strength)){
					gametime += deltaT;
					workTime += deltaT;
					double newstam = getStamina() - deltaT;
					if (newstam < 0)
						newstam = 0;
					setStamina(newstam);
					
						
					
				}
			}
			else this.activityStatus = "none";
		}
		else if (isAttacking()){
			double attackTime = 0;
			while (attackTime < 1)
				gametime += deltaT;
				attackTime += deltaT;
			double newstam = this.stamina - 1;
			if (newstam <= 0)
				newstam = 0;
				rest();
			setStamina(newstam);
				
		
			
				this.activityStatus = "none";
			
			
				
			
			
			
			
		}
		else if (isDefaultBehaving()){
			
			if (this.activityStatus == "working"){
			
				double newstam;
				newstam = this.stamina - deltaT;
				if (newstam < 0)
					newstam = 0;
					rest();
				setStamina(newstam);
				
				
		}
			if (this.activityStatus == "moving"){
				Random random = new Random();
				double pivot = random.nextDouble();
				if (pivot >= 0.5)
					startSprinting();
					if (this.stamina <= 0)
						stopSprinting();
						rest();
						
						
			}
			
		}
		
				
				
			
		
		else if (this.activityStatus == "none")
			startDefaultBehaviour();
		
		
		
		
		this.gametime += deltaT;
		
		
		if (gametime % 180.0 == 0.0)
			rest();
		
	}
		
	private double gametime ;
	
	/**
	 * beweging
	 */
	/**
	 * 
	 * @return the basespeed for a unit based on its strength agility and weight
	 */
	public double getBaseSpeed(){
		return 1.5*(getStrength()+getAgility())/((200*getWeight())/100);
	}
	/**
	 * 
	 * @param initial
	 * @param destination
	 * @return if the unit goes up the walkingspeed is 0.5 times the basespeed
	 * 			|if (initial[2]-destination[2] == -1)
	 *			|	return 0.5*getBaseSpeed()
	 * @return if the unit goes up the walkingspeed is 0.5 times the basespeed
	 * 			|if (initial[2]-destination[2] == 1)
	 *			|	return 1.2*getBaseSpeed()
	 * @return if the unit stays at the same level the walkingspeed is the basespeed
	 * 			|if (initial[2]-destination[2] == 0)
	 */
	public double getWalkingSpeed(double[]initial,double[]destination){
		if (initial[2]-destination[2] == -1){
			return 0.5*getBaseSpeed();
		}
		else if (initial[2]-destination[2] == 1){
			return 1.2*getBaseSpeed();
		}
		else{
			return getBaseSpeed();
		}
	}
	
/**
 * 
 * @param 	x
 * 			de x coordinaat van de positie naar waar de unit zich moet verplaatsten
 * @param 	y
 *  		de y coordinaat van de positie naar waar de unit zich moet verplaatsten
 * @param 	z
 *  		de z coordinaat van de positie naar waar de unit zich moet verplaatsten
 * @post	the detination is set to the given coordinates
 * 			|this.destination = {x,y,z}
 * @post 	the velocity is set to the correct speed s in the x, y and z directions		
 * 			|Vx = getWalkingSpeed(getPosition(),dest)*(x-getPosition()[0])/distance;
 *			|Vy = getWalkingSpeed(getPosition(),dest)*(x-getPosition()[0])/distance;
 *			|Vz = getWalkingSpeed(getPosition(),dest)*(x-getPosition()[0])/distance;
 * 			|this.velocity = {Vx,Vy,Vz}
 * @throws IllegalArgumentException if the given coordinates are not adjective to the curent position
 * 			| !isValidAdject()
 */
	public void moveToAdject(double dx, double dy, double dz)throws IllegalArgumentException{
		if (!isValidAdject(dx,dy,dz)){
			throw new IllegalArgumentException();
		}
		double[] dest = {getPosition()[0]+0.5+dx,getPosition()[1]+0.5+dy,getPosition()[2]+0.5+dz};
		double distance = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2)+
				Math.pow(dz,2));
		
		double Vx = getWalkingSpeed(getPosition(),dest)*(dx)/distance;
		double Vy = getWalkingSpeed(getPosition(),dest)*(dy)/distance;
		double Vz = getWalkingSpeed(getPosition(),dest)*(dz)/distance;
		double[] velo = {Vx,Vy,Vz};
		setVelocity(velo);
		setDestination (dest);
		setAngle((float) Math.atan2(getVelocity()[0],getVelocity()[1]));
		
	}
	/**
	 * 
	 * @param dx
	 * @param dy
	 * @param dz
	 * @return false if the distance from the initial positions square 
	 * 			to the destination square is greater then 1
	 * @return false if the destination position is an invalid position
	 */
	public boolean isValidAdject(double dx, double dy,double dz){ 
		if (((dx <=1) && (dx >= -1)) && ((dy <=1) && (dy >= -1)) && ((dz <=1) && (dz >= -1))){
			return true;
		}
		return false;
		
		
		
	}
	/**
	 *
	 * @post the new velocity of the unit is 2 times the walkingspeed of the unit
	 * 
	 * @return wether or not the unit is sprinting
	 *
	 *
	 */
	public void startSprinting(){
		if ((isMoving()) && (this.stamina > 0))
			this.activityStatus = "sprinting";	
			double[] sprint = this.velocity;
			sprint[0] *= 2;
			sprint[1] *= 2;
			sprint[2] *= 2;
			this.velocity = sprint; 
	}
	/**
	 * @post speed is equal to the normal walking speed of before
	 * 		|new.velocity[0] = this.velocity[0] / 2
	 * 		|new.velocity[1] = this.velocity[1] / 2
	 * 		|new.velocity[2] = this.velocity[2] / 2
	 */
		
	public void stopSprinting(){
		this.activityStatus = "walking";
		double walk[] = this.velocity;
		walk[0] /= 2;
		walk[1] /= 2;
		walk[2] /= 2;
		this.velocity = walk;
		
		
	}
	/**
	 * @return true if the unit is sprinting
	 * 		   false if the unit is not sprinting
	 * 
	 */
	public boolean isSprinting(){
		if (this.activityStatus == "sprinting")
			return true;
		return false;
	
	}
	
	
	private String activityStatus = "none" ;
	/**
	 * 
	 * @return the destination of a unit
	 */
	public double[] getDestination(){
		return this.destination;
	}
	/**
	 * 
	 * @param destination
	 * @post sets the new destination to the given destination
	 * 		|new.destination = destination
	 */
	public void setDestination(double[] destination){
		this.destination = destination;
		}
	private double[] destination = getPosition();
	/**
	 * 
	 * @return the velocity of a unit
	 */
	public double[] getVelocity(){
		return this.velocity;
	}
	public double getCurrentSpeed() {
		return Math.sqrt(Math.pow(getVelocity()[0],2)+Math.pow(getVelocity()[1],2)+
				Math.pow(getVelocity()[2],2));
	}
	/**
	 * 
	 * @param velocity
	 * @post the new velocity is equal to the given velocity
	 * 		|new.velocity = velocity
	 */
	public void setVelocity(double[] velocity){
		this.velocity = velocity;
	}
	private double[] velocity = {0,0,0} ;
	
	/**
	 * 
	 * @param cube
	 * @post the new position is equal to the given coordinates of the cube to where the unit is heading
	 * 		 |new.position = int[] cube
	 * @throws IllegalArgumentException if the given position of the new cube is not valid
	 * 			| if ((cube[0] >= XUPBOUND) || (cube[1] >= YUPBOUND) || (cube[2] >= ZUPBOUND))
	 * 			| 	throw IlegalArgumentException
	 * 
	 */
	public void moveTo( int[] cube) throws IllegalArgumentException{
		this.activityStatus= "moving";
		if ((cube[0] >= XUPBOUND) || (cube[1] >= YUPBOUND) || (cube[2] >= ZUPBOUND))
			throw new IllegalArgumentException();
		
		
		else {
			int[] list = getCubePosition();
		
			while ((list[0] != cube[0])&&(list[1] != cube[1]) && (list[2] != cube[2])){
				int x,y,z;
		
				if (list[0] == cube[0])
					x = 0;
				else if (list[0]<cube[0])
					x = 1;
				else x = -1;
				if (list[1] == cube[1])
					y = 0;
				else if (list[1]<cube[1])
					y = 1;
				else y = -1;
				if (list[2] == cube[2])
					z = 0;
				else if (list[2]<cube[2])
					z = 1;
				else z = -1;
				moveToAdject(x, y, z);
			}
			// throws exception if moveToAdject(x,y,z) is not valid
		}
		this.activityStatus = "none";
	}
	
	/**
	 * 
	 * @return true if the unit is moving
	 * 		   false if the unit is not moving
	 */
	public boolean isMoving(){
		if (this.activityStatus == "moving")
			return true;
		else return false;
		
	}
	
	
	//working
	
	
	/**
	 * 
	 * 
	 * 
	 */
	public void work(){
		this.activityStatus = "working";
		
		
		
	}
	
	public void stopWorking(){
		this.activityStatus = "none";
	}
	
	public boolean working = false;
	
	/**
	 * 
	 * @return true if unit is working
	 * 		   false if unit is not working
	 */
	public boolean isWorking() {
		if (this.activityStatus == "working"){
			return true;
		}
		else return false;
	}

	// fighting//

	/**
	 * 
	 * @param defender, the unit that will defend the attack of the current unit
	 * 
	 *@post if the defender is not in an adjacent position, the unit moves to the cube of the defender to attack it
	 *		| if ((defender.getCubePosition()[0] != getCubePosition())[0] || (defender.getCubePosition()[0] != getCubePosition()[0] + 1) || (defender.getCubePosition()[0] != getCubePosition()[0] - 1))
	 *		|		moveTo(defender.getCubePosition())
	 *		| if ((defender.getCubePosition()[1] != getCubePosition())[1] || (defender.getCubePosition()[1] != getCubePosition()[1] + 1) || (defender.getCubePosition()[1] != getCubePosition()[1] - 1))
	 *		|		moveTo(defender.getCubePosition())
	 *		| if ((defender.getCubePosition()[2] != getCubePosition())[2] || (defender.getCubePosition()[2] != getCubePosition()[2] + 1) || (defender.getCubePosition()[2] != getCubePosition()[2] - 1))
	 *		|		moveTo(defender.getCubePosition())
	 *
	 *
	 *
	 */
	public void attack(Unit defender) {
		this.activityStatus = "attacking";
		int[] attack = getCubePosition();
		int[] defense = defender.getCubePosition();
		if (!((attack[0] == defense[0]) || (attack[0] == (defense[0]) - 1) ||  (attack[0] == (defense[0]) + 1)))
			moveTo(defender.getCubePosition());
		if (!((attack[1] == defense[1]) || (attack[1] == (defense[1]) - 1) ||  (attack[1] == (defense[1]) + 1)))
			moveTo(defender.getCubePosition());
		if (!((attack[2] == defense[2]) || (attack[2] == (defense[2]) - 1) ||  (attack[2] == (defense[2]) + 1)))
			
		
		defender.defend(this);
		
		
		this.activityStatus = "none";
		
		
	}

	
	
	
	/**
	 * 
	 * @return true if the unit is attacking
	 * 		   false if the unit is defending
	 */
	public boolean isAttacking(){
		if (this.activityStatus == "attacking")
			return true;
		else return false;
	}
	/**
	 * 
	 * @param attacker, the unit that will affect this unit by attacking it
	 * @post  the attacked unit has dodged the attack, so it has a new position
	 * 		  | new.position[0] = position[0] + 0.1 ||
	 * 		  | new.position[0] = position[0] - 0.1
	 * 		  | new.position[1] = position[1] + 0.1 ||
	 * 		  | new.position[1] = position[1] - 0.1 
	 * 		  | new.position[2] = position[2] + 0.1 ||
	 * 		  | new.position[2] = position[2] - 0.1 
	 * 
	 * @post  the attacked unit has blocked the attack so it suffers no damage
	 * 		  | new.currentHitPoints() = this.currentHitPoints()
	 * 
	 * @post  the attacked unit has failed to either dodge or block the attack so it suffers damage
	 * 		  | new.currentHitPoints() = this.currentHitPoints() - strikepoints
	 * 
	 * @post the attacked unit and the attacker's orientation are updated so they face each other while fighting
	 * 		  | attacker.Angle = Math.atan2((this.Ypos - attacker.Ypos),(this.Xpos - attacker.Xpos))
	 * 		  | new.Angle = Math.atan2((attacker.Ypos - this.Ypos),(attacker.Xpos - this.Xpos))
	 * 		  
	 * 
	 * 
	 */
	public void defend(Unit attacker){
		assert this.activityStatus == "attacking";
		boolean dodged = dodging(attacker);
		boolean blocked = blocking(attacker);
		if (dodged == true)
			this.setPosition(positionAfterDodged());
		else if (dodged == false)
			if (blocked == true)
				strikepoints = 0;
			else strikepoints = attacker.getStrength()/10;
		
		takingDamage(strikepoints);
		UpdateOrientation(attacker);
		
					
				
				
			
	}
	/**
	 * 
	 * @param strikepoints the value which indicates how much damage the defending unit has taken
	 * @throws IllegalArgumentException if strikepoints is lower than zero
	 * 		   | if (strikepoints < 0)
	 * 		   | 	throw exception
	 * @post the new hitpoints of a unit are the current hitpoints minus the strikepoints
	 * 		   | new.hitpoints = this.hitpoints - strikepoints
	 */
	public void takingDamage(double strikepoints) throws IllegalArgumentException{
		if(strikepoints < 0)
			throw new IllegalArgumentException();
		if (getHitpoints()- strikepoints < 0)
			setHitpoints(0);
		else setHitpoints(getHitpoints()- strikepoints);
		
	}
	
	/**
	 * 
	 * @param attacker who affects the chance of dodging the attack
	 * @return true if the unit has successfully dodged the attack
	 * @return false if the unit hasn't dodged the attack
	 * 
	 */
	public boolean dodging(Unit attacker){
		Random random = new Random();
		double chance = 0.20 * (getAgility() / attacker.getAgility());
		double pivot = random.nextDouble();
		if (pivot <= chance)
			return true;
		else return false;
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @return list position for which each element is added by 0.1 or substracted by 0.1
	 * @post   the new coordinates of the unit are added or substracted by 0.1
	 * 		   | new.posX = this.posX + 0.1||
	 * 		   | new.posX = this.posX - 0.1
	 * 		   | new.posY = this.posY + 0.1||
	 * 		   | new.posY = this.posY - 0.1
	 * 		   | new.posZ = this.posZ + 0.1||
	 * 		   | new.posZ = this.posZ - 0.1
	 * 
	 * 
	 */
	public double[] positionAfterDodged(){
		double position[] = getPosition();
		assert ((position[0] + 0.1 <= XUPBOUND-1) && (position[0] - 0.1 >= XLOWBOUND ));
		assert ((position[1] + 0.1 <= YUPBOUND-1) && (position[1] - 0.1 >= YLOWBOUND ));
		assert ((position[2] + 0.1 <= ZUPBOUND-1) && (position[2] - 0.1 >= ZLOWBOUND ));
		
		Random random = new Random();
		double pivot;
		for (int i = 0; i < position.length - 1; i++){
			pivot = random.nextDouble();
			if (pivot >= 0.5)
				position[i] += 0.1;
			else position[i] += -0.1;
		}
		return position;
	}
	/**
	 * 
	 * @param attacker unit which attacks the current unit
	 * @return true if the current unit has successfully blocked the attack
	 * @return false if the current unit failed to block the attack
	 */
	public boolean blocking(Unit attacker){
		Random random = new Random();
		double chance = 0.25 * ((getStrength() + getAgility())/(attacker.getStrength()+ attacker.getAgility()));
		double pivot = random.nextDouble();
		if (pivot <= chance)
			return true;
		else return false;
		
	
	}
	private double strikepoints = 0;
	
	
	/**
	 * 
	 * @param attacker unit that attacks current unit
	 * @post  the orientation of both units is updated so they face each other while fighting
	 * 		  |attacker.Angle = math.atan2((this.Ypos - attacker.Ypos),(this.Xpos - attacker.Xpos))
	 *		  |new.Angle = Math.atan2((attacker.Ypos - this.Ypos),(attacker.Xpos - this.Xpos))
	 *
	 *
	 */
	public void UpdateOrientation(Unit attacker) {
		double defense[] = getPosition();
		double attack[] = attacker.getPosition();
		
		double atheta = Math.atan2((defense[1] - attack[1]),(defense[0] - attack[0]));
		double dtheta = Math.atan2((attack[1] - defense[1]),(attack[0] - defense[0]));
		
		setAngle((float)dtheta);
		attacker.setAngle((float)atheta);
	
	}
	
	
	
	
	/**
	 * @pre stamina has to be lower than the max value
	 * 		|this.stamina < this.getMaxStamina()
	 * @post hitpoints have recovered until a new action has begun or it has fully recovered
	 * 		|while (this.activityStatus = "none")
	 * 		| 	new.hitpoints = getHitpoints() + (getToughness / 200)
	 * @post stamina has recovered until a new action was started or it fully recovered
	 * 		|while (this.activityStatus = "none")
	 * 		|	new.stamina = getStamina() + (getToughness / 100)
	 * 
	 */
	public void rest(){
		assert this.stamina <= getStamina();
		this.activityStatus = "resting";
		
		if (this.activityStatus == "resting")
			while (this.hitpoints < getMaxHitpoints())
				setHitpoints(getHitpoints() + (getToughness()/200));
		
	    		if (this.hitpoints > getMaxHitpoints())
	    			setHitpoints(getMaxHitpoints());
		
		
			while(this.stamina < getMaxStamina())
				
				setStamina(getStamina() + (getToughness()/100));
				
				if (this.stamina > getMaxStamina())
					setStamina(getMaxStamina());
		
		
	}

	/**
	 * 
	 * @return true if the unit is resting
	 * @return false if the unit is not resting
	 */
	
	
	public boolean isResting(){
		if (this.activityStatus == "resting")
			return true;
		else return false;
	}
	

	/**
	 * @post the unit is doing a random activity
	 * 		|this.defaultBehaving = true
	 * 
	 * @post the unit has started moving to a random position 
	 * 		| this.isMoving = true		 
	 * 
	 * @post the unit has started working
	 * 		|this.isWorking = true
	 * 
	 * @post the unit has started resting
	 * 		|this.isResting = true
	 * 		
	 * 
	 * 
	 */
	public void startDefaultBehaviour(){
		this.activityStatus = "none";
		this.defaultbehaving = true;
		Random random = new Random();
		double a;
		
		int cubePosition[] = new int[3];
		if (this.defaultbehaving == true){
			
			a = random.nextDouble();
			if (a <= 0.333){
				for (int i = 0; i < 3; i++){
					cubePosition[i] = random.nextInt(XUPBOUND);
				}
				moveTo(cubePosition); // random kiezen om te sprinten in moveTo zelf
				
			}
			else if ((a > 0.333) && (a <= 0.666)){
				work();
				
				}
			else { 
				rest();
				
			}
		}
	}
	/**
	 * @post the unit has stopped doing a random activity
	 * 		|this.defaultBehaving = false
	 * @post the unit is doing nothing
	 * 		|this.activityStatus = "none"
	 * 
	 * 
	 */
	public void stopDefaultBehaviour(){
		this.defaultbehaving = false;
	}
	/**
	 * 
	 * @return the value of the variable defaultBehaving whether it is true or false
	 */
	public boolean isDefaultBehaving(){
		if (this.defaultbehaving = true)
			return true;
		else return false;
	}
	public boolean defaultbehaving = false;
	
	/**
	 * 
	 * @return
	 */
	public boolean getDefaultBehaviour(){
		if (this.defaultbehaving == true)
			return true;
		else return false;
	}
	
	private static int XUPBOUND = 50;
	private static int YUPBOUND = 50;
	private static int ZUPBOUND = 50;
	private static int XLOWBOUND = 0;
	private static int YLOWBOUND = 0;
	private static int ZLOWBOUND = 0;
	
		
	
}



