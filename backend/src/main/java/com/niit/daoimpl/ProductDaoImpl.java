package com.niit.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean insertOrUpdateProduct(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public Product getProduct(int pro_id) {
		
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, pro_id);
		session.close();
		return product;
	}

	public List<Product> getProductDetails() {

		Session session = sessionFactory.openSession();
		List<Product> productList = session.createQuery("from Product").list();
		session.close();
		return productList;
	}

	public List<Product> getProductCatWise(Category category) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where category=:category");
		query.setParameter("category", category);
		List<Product> catWiseProdList = query.list();
		return catWiseProdList;
	}

	public void deleteProduct(Product product) {
		
		sessionFactory.getCurrentSession().delete(product);
	}
	
	public List<Product> retrieve()
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> li = session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;
	}
	
	
	public Product findByPID(int pro_id)
	{
		Session session = sessionFactory.openSession();
		Product p = null;
		try 
		{
			session.beginTransaction();
			p=session.get(Product.class, pro_id);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	}
	@Transactional
	public List<Product> getProductByCatID(int cid) 
	{
		
		Session session = sessionFactory.getCurrentSession();
		List<Product> c = null;
		try
		{
			
			c = session.createQuery("from Product where cid=:cid").setInteger("cid", cid).list();
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			
		}
		return c;
	}
	

	public void deleteProd(int pro_id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product p = (Product)session.get(Product.class, pro_id);
		session.delete(p);
		session.getTransaction().commit();
	}

	public int getProductIdByProductName(String pro_name) {
		Session session = sessionFactory.getCurrentSession();
		int pid = 0;
		try
		{
			
			System.out.println("PRODUCT NAME----"+pro_name);
			
			pid = (Integer) session.createSQLQuery("select pro_id from Product where pro_name=:pro_name").setString("pro_name", pro_name).setMaxResults(1).uniqueResult();
			
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			
		}
		return pid;
	}

	
	
}
