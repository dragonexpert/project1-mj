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
	
	@Column(name ="element")
	private String element;
	
	public Armor() {
		
	}

	public Armor(int armorid, String name, int defense, int cost, String element) {
		super();
		this.armorid = armorid;
		this.name = name;
		this.defense = defense;
		this.cost = cost;
		this.element = element;
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

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "Armor [armorid=" + armorid + ", name=" + name + ", defense=" + defense + ", cost=" + cost + ", element="
				+ element + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(armorid, cost, defense, element, name);
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
				&& Objects.equals(element, other.element) && Objects.equals(name, other.name);
	}
	

}
