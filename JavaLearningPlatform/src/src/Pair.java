package src;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pair {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

	Integer left;
	String Right;
	
	public Pair() {
		super();
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}

	public String getRight() {
		return Right;
	}

	public void setRight(String right) {
		Right = right;
	}
	
	
}
