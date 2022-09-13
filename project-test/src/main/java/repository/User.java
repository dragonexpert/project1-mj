package repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="game_user")
public class User
{
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "character_id")
    private int character_id;


    public User()
    {
    }


    public User(int user_id, String username, String password, int character_id)
    {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.character_id = character_id;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int userid)
    {
        this.user_id = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public int getCharacter_id() {
		return character_id;
	}


	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}


	public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


	@Override
	public String toString() {
		return "User [userid=" + user_id + ", username=" + username + ", password=" + password + ", character_id="
				+ character_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + character_id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (character_id != other.character_id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
