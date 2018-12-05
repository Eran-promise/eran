package com.web.eran.entity;

/**
 * sys_role
 */
 
 
public class SysRole{
	// : id 	
	private Long id; 
	
	// : name 	
	private String name; 
	
	//是否可用,1：可用，0不可用 : available 	
	private String available; 
	

	/**
	 *  : id
	 * 
	 * @return 
	 */
	public Long getId () {
		return id;
	}
	
	/**
	 *  : id
	 * 
	 * @return 
	 */
	public void setId (Long id) {
		this.id = id;
	}
	/**
	 *  : name
	 * 
	 * @return 
	 */
	public String getName () {
		return name;
	}
	
	/**
	 *  : name
	 * 
	 * @return 
	 */
	public void setName (String name) {
		this.name = name;
	}
	/**
	 * 是否可用,1：可用，0不可用 : available
	 * 
	 * @return 
	 */
	public String getAvailable () {
		return available;
	}
	
	/**
	 * 是否可用,1：可用，0不可用 : available
	 * 
	 * @return 
	 */
	public void setAvailable (String available) {
		this.available = available;
	}

	@Override
	public String toString() {
			return "SysRole ["+
						"id=" + id +
								",name=" + name +
								",available=" + available +
							"]";
	}

 
}
