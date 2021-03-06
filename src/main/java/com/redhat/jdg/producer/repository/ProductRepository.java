package com.redhat.jdg.producer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.jdg.pojo.Product;
import com.redhat.jdg.producer.db.DbConnectionFactory;

/**
 * Repository for {@link Product Product}.
 * 
 * @author <a href="mailto:duncan.doyle@redhat.com">Duncan Doyle</a>
 * @author <a href="mailto:cojan.van.ballegooijen@redhat.com">Cojan van Ballegooijen</a>
 */
public class ProductRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

	private static final DbConnectionFactory dbConnectionFactory = new DbConnectionFactory();

	/**
	 * Retrieves the {@link Product} from the database.
	 * 
	 * @param connection
	 *            the {@link Connection} to use.
	 * @return a {@link Map} of {@link Product Product}.
	 */
	public Map<String, Product> getProduct() {

		Map<String, Product> products = new HashMap<>();

		String select = "SELECT * FROM PRODUCTS";

		try (Connection connection = dbConnectionFactory.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(select);
			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {
					Product p = new Product();

					long productid = rs.getLong("PRODUCT_ID");
					p.setProductid(productid);

					long categoryid = rs.getLong("PRODUCT_CATEGORY_ID");
					p.setCategoryid(categoryid);
					
					String name = rs.getString("PRODUCT_NAME");	
					p.setName(name);				

					String description = rs.getString("PRODUCT_DESCRIPTION");	
					p.setDescription(description);

					Double price = rs.getDouble("PRODUCT_PRICE");
					p.setPrice(price);
					
					String image = rs.getString("PRODUCT_IMAGE");	
					p.setImage(image);
					
					products.put(String.valueOf(productid), p);
				}
			}

		} catch (SQLException sqle) {
			String message = "Error while fetching data.";
			LOGGER.error(message, sqle);
			throw new RuntimeException(message, sqle);
		}

		return products;
	}
}
