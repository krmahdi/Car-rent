package com.epam.carrental.model.dao;

import java.util.List;

public interface genericDao<T> {

	
	//create
	int insertItem (T item);
	//Read
	List<T> getAllItems();
	T getItemById(long id);
	//update
	int updateItem(T item);
	//delete
	int deleteItem(long id);
	
	
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            