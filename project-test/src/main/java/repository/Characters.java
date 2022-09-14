package repository;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="character_sheet")
public class Characters {
	
	@Column(name = "character_id")
	private int character_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gold")
	private int gold;
	
	@Column(name = "weapon_id")
	private int weapon_id;
	
	@Column(name = "armor_id")
	private int armor_id;
	
	@Column(name = "health")
	private int health;
	
	@Column(name = "user_id")
	private int user_id;
	
	public Characters() {
		
	}

	public Characters(int character_id, String name, int gold, int weapon_id, int armor_id, int health, int user_id) {
		super();
		this.character_id = character_id;
		this.name = name;
		this.gold = gold;
		this.weapon_id = weapon_id;
		this.armor_id = armor_id;
		this.health = health;
		this.user_id = user_id;
	}

	public int getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Characters [character_id=" + character_id + ", name=" + name + ", gold=" + gold + ", weapon_id="
				+ weapon_id + ", armor_id=" + armor_id + ", health=" + health + ", user_id=" + user_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(armor_id, character_id, gold, health, name, user_id, weapon_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Characters other = (Characters) obj;
		return armor_id == other.armor_id && character_id == other.character_id && gold == other.gold
				&& health == other.health && Objects.equals(name, other.name) && user_id == other.user_id
				&& weapon_id == other.weapon_id;
	}
}

	