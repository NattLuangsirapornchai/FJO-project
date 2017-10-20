package model;


public abstract class Servant implements Attack, Comparable<Servant>{
	protected String name;
	protected int maxHp;
	protected int hp;
	protected int attack;
	protected int defense;
	protected String type ;
	
	public Servant(String name,String type,int maxHp,int attack,int defense) {
		this.name = name;
		this.type = type ;
		if (maxHp < 1) {
			this.maxHp = 1;
			this.hp = 1;
		} else {
			this.maxHp = maxHp;
			this.hp = maxHp;
		}
		this.attack = attack < 1 ? 1 : attack ;
		this.defense = defense < 1 ? 1 : defense ;
	}
	/*
	public String toString() {
		return name+" | Class : "+type+" | HP : "+hp+" | Atk : "+attack+" | Def : "+defense ;
	}
	*/
	
	public abstract void action(Servant opponent,char form); 
	
	@Override
	public String toString() {
		return "Servant [name=" + name + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", type=" + type
				+ "]";
	}

	public int compareTo (Servant other) {
		if((this instanceof Archer && other instanceof Archer) || 
			(this instanceof Saber && other instanceof Saber) ||
			(this instanceof Berserker && other instanceof Berserker)) {
			if (this.hp > other.hp) return 1 ;
			if (this.hp < other.hp) return -1 ;
			return this.name.compareTo(other.name) ;
		}
		if (this instanceof Archer && (other instanceof Saber || other instanceof Berserker)) return -1 ;
		else if (other instanceof Archer && (this instanceof Saber || this instanceof Berserker)) return 1 ;
		else if (this instanceof Saber || other instanceof Berserker) return -1 ;
		else if (this instanceof Berserker || other instanceof Saber) return 1 ;
		else return 0;
	}
	
	public void takeDamage(int damage) {
		hp -= damage < 1 ? 1 : damage;
		if(hp < 0) hp = 0;
	}
	
	public boolean isDefeated() {
		if(hp<=0) return true;
		return false;
	}
	
	public void restoreHp() {
		hp = maxHp;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHp(){
		return hp ;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}

}
