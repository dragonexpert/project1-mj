package repository;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="character_sheet")
public class Character {
	
	@Column(name = "character_id")
	private int characterid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gold")
	private int gold;
	
	@Column(name = "weapon_id")
	private int weapon_id;
	
	@Column(name = "character_id")
	private int character_id;
	
	@Column(name = "armor_id")
	private int armor_id;
	
	@Column(name = "health")
	private int health;
	
	Character(){
	}

	public Character(int characterid, String name, int gold, int weapon_id, int character_id, int armor_id,
			int health) {
		super();
		this.characterid = characterid;
		this.name = name;
		this.gold = gold;
		this.weapon_id = weapon_id;
		this.character_id = character_id;
		this.armor_id = armor_id;
		this.health = health;
	}

	public int getCharacterid() {
		return characterid;
	}

	public void setCharacterid(int characterid) {
		this.characterid = characterid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getWeapon_id() {
		return weapon_id;
	}

	public void setWeapon_id(int weapon_id) {
		this.weapon_id = weapon_id;
	}

	public int getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}

	public int getArmor_id() {
		return armor_id;
	}

	public void setArmor_id(int armor_id) {
		this.armor_id = armor_id;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "Character [characterid=" + characterid + ", name=" + name + ", gold=" + gold + ", weapon_id="
				+ weapon_id + ", character_id=" + character_id + ", armor_id=" + armor_id + ", health=" + health + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(armor_id, character_id, characterid, gold, health, name, weapon_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return armor_id == other.armor_id && character_id == other.character_id && characterid == other.characterid
				&& gold == other.gold && health == other.health && Objects.equals(name, other.name)
				&& weapon_id == other.weapon_id;
	}
	

}
