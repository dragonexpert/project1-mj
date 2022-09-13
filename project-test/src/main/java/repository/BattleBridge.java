package repository;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="battle_bridge")
public class BattleBridge {
	
	@Column(name = "character_id")
	private int character_id;
	
	@Column(name = "enemy_id")
	private int enemy_id;
	
	@Column(name = "char_won")
	private int char_won;
	
	public BattleBridge() {
		
	}

	public BattleBridge(int character_id, int enemy_id, int char_won) {
		super();
		this.character_id = character_id;
		this.enemy_id = enemy_id;
		this.char_won = char_won;
	}

	public int getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}

	public int getEnemy_id() {
		return enemy_id;
	}

	public void setEnemy_id(int enemy_id) {
		this.enemy_id = enemy_id;
	}

	public int getChar_won() {
		return char_won;
	}

	public void setChar_won(int char_won) {
		this.char_won = char_won;
	}

	@Override
	public String toString() {
		return "BattleBridge [character_id=" + character_id + ", enemy_id=" + enemy_id + ", char_won=" + char_won + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(char_won, character_id, enemy_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BattleBridge other = (BattleBridge) obj;
		return char_won == other.char_won && character_id == other.character_id && enemy_id == other.enemy_id;
	}
	

}
