package repository;

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
	
	@Column(name = "element")
	private String element;
	
	public Weapons() {
		
	}

	public Weapons(int weapon_id, String name, int strength, int cost, String element) {
		super();
		this.weapon_id = weapon_id;
		this.name = name;
		this.strength = strength;
		this.cost = cost;
		this.element = element;
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

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "Weapons [weapon_id=" + weapon_id + ", name=" + name + ", strength=" + strength + ", cost=" + cost
				+ ", element=" + element + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + strength;
		result = prime * result + weapon_id;
		return result;
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
		if (cost != other.cost)
			return false;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strength != other.strength)
			return false;
		if (weapon_id != other.weapon_id)
			return false;
		return true;
	}
	
	

}
