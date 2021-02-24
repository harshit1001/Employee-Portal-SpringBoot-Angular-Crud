package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String code;
   
    public String description;
    public String name;
    public int value;

    public Product() {
    }


    public Product(int id, String code,
                   String name, String description,
                   int value) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.value = value;
    }

  
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getcode() {
		return code;
	}


	public void setcode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	@Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", id=" + id +
                '}';
    }
}
