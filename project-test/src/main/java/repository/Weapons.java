package repository;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="weapons")
public class Weapons {
	
	@Column(name = "weapon_id")
	private int weapon_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "strength")
	private int strength;
	
	@Column(name = "cost")
	private int cost;
	
	
	public Weapons() {
	}


	public Weapons(int weapon_id, String name, int strength, int cost) {
		super();
		this.weapon_id = weapon_id;
		this.name = name;
		this.strength = strength;
		this.cost = cost;
	}


	public int getWeapon_id() {
		return weapon_id;
	}


	public void setWeapon_id(int weapon_id) {
		this.weapon_id = weapon_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Weapons [weapon_id=" + weapon_id + ", name=" + name + ", strength=" + strength + ", cost=" + cost + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cost, name, strength, weapon_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapons other = (Weapons) obj;
		return cost == other.cost && Objects.equals(name, other.name) && strength == other.strength
				&& weapon_id == other.weapon_id;
	}
	
}