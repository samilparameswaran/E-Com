package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface CategoryDao {
	
	public boolean insertOrUpdateCategory(Category category);
	public Category getCategory(int cat_id);
	public int getCategoryByPid(int pro_id);
	public List<Category> getCategoryDetails();
	public void deleteCategory(Category category);
	public List<Category> retrieve();
	public void deleteCat(int cat_id);
	
}
