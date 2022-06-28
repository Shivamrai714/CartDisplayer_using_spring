package cartdisplayer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import cartdisplayer.model.Product;

@Component
public class ProductDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	//1. create 
	
	@Transactional
	public void createProduct(Product p)
	{
		this.hibernateTemplate.saveOrUpdate(p);             //both save and update
	}
	
	
	//2 getAll
	
	public List<Product> getallProducts()
	{
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
	return products;
	}
	
	//3. getSingle product
	
	public Product getProduct(int pid)
	{
		Product product = this.hibernateTemplate.get(Product.class,pid );
	return product;
	}

     //4 delete product
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p = this.hibernateTemplate.get(Product.class, pid);
		this.hibernateTemplate.delete(p);	

	}
	
	//5 update product
	// here use the same create_priduct feature of save and update
   	



}
