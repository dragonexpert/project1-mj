package repository;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="armor")
public class Armor {
	
	@Column(name ="armor_id")
	private int armorid;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="defense")
	private int defense;
	
	@Column(name ="cost")
	private int cost;

	public Armor() {
		
	}

	public Armor(int armorid, String name, int defense, int cost) {
		super();
		this.armorid = armorid;
		this.name = name;
		this.defense = defense;
		this.cost = cost;
	}

	public int getArmorid() {
		return armorid;
	}

	public void setArmorid(int armorid) {
		this.armorid = armorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Armor [armorid=" + armorid + ", name=" + name + ", defense=" + defense + ", cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(armorid, cost, defense, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Armor other = (Armor) obj;
		return armorid == other.armorid && cost == other.cost && defense == other.defense
				&& Objects.equals(name, other.name);
	}
}