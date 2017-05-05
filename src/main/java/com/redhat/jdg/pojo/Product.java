package com.redhat.jdg.pojo;
/**
* Maps a relational database table Contract to a java object, Contract
*
* 
*
* @author	ReverseEngineer
*/
import java.io.Serializable;
import org.infinispan.protostream.annotations.ProtoField;

public class Product implements Serializable {


	
	public java.lang.Long product_id;
	
	public java.lang.Long category_id;

	public java.lang.String name;
	
	public java.lang.String description;
	
	public java.lang.Double price;
	
	public java.lang.String image;


	@ProtoField(number = 1, required = true)
	public java.lang.Long getProductid( ) { 
		return this.product_id;
	}

	public void setProductid( java.lang.Long Productid) { 
		 this.product_id = Productid; 
	}
	
	@ProtoField(number = 2, required = true)
	public java.lang.Long getCategoryid( ) { 
		return this.category_id;
	}

	public void setCategoryid( java.lang.Long Categoryid) { 
		 this.category_id = Categoryid; 
	}

	@ProtoField(number = 3, required = true)
	public java.lang.String getName( ) { 
		return this.name;
	}

	public void setName( java.lang.String Name) { 
		 this.name = Name; 
	}

	@ProtoField(number = 4, required = false)
	public java.lang.String getDescription( ) { 
		return this.description;
	}

	public void setDescription( java.lang.String Description) { 
		 this.description = Description; 
	}

	@ProtoField(number = 5, required = true)
	public java.lang.Double getPrice( ) { 
		return this.price;
	}

	public void setPrice( java.lang.Double Price) { 
		 this.price = Price; 
	}
	
	@ProtoField(number = 6, required = false)
	public java.lang.String getImage( ) { 
		return this.image;
	}

	public void setImage( java.lang.String Image) { 
		 this.image = Image; 
	}


	public String toString()  {
		StringBuffer output = new StringBuffer();
		output.append("Productid:");
		output.append(getProductid());
		output.append("\n");
		output.append("Categoryid:");
		output.append(getCategoryid());
		output.append("\n");
		output.append("Name:");
		output.append(getName());
		output.append("\n");
		output.append("Description:");
		output.append(getDescription());
		output.append("\n");
		output.append("Price:");
		output.append(getPrice());
		output.append("\n");
		output.append("Image:");
		output.append(getImage());
		output.append("\n");
		return output.toString();
	}

} // class Contract
