package com.dzwz.shop.action;


import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dzwz.shop.dao.CategoryDao;
import com.dzwz.shop.service.CategoryService;
import com.dzwz.shop.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Action基本类实现RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T>接口
 * 
 * @Time 2015-08-17
 * @author zrui
 *
 * @param <T>
 */


public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Map<String,Object> request;
	public Map<String,Object> session;
	public Map<String,Object> application;
	
	public T model;
	
	public UserService userService;
	
	public CategoryService  categoryService;
	
	public InputStream inputStream;
	
	//分页属性
	public int page;
	public int rows;
	
	public Map<String,Object> resultMap;
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
    
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//获取application
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;

	}
	//获取session
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	//获取session
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	/**
	 * 利用泛型实例化getModel方法
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();   //获取父类的泛型
		Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];	 //获取类型中的对应的类型的的class
		try {
			model =  clazz.newInstance();		//使用反射对model实例化
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}

}
