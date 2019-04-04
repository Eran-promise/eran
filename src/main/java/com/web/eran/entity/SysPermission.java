package com.web.eran.entity;

/**
 * sys_permission
 */
 
 
public class SysPermission{
	//主键 : id 	
	private Long id; 
	
	//资源名称 : name 	
	private String name; 
	
	//资源类型：menu,button, : type 	
	private String type; 
	
	//访问url地址 : url 	
	private String url; 
	
	//权限代码字符串 : percode 	
	private String percode; 
	
	//父结点id : parentid 	
	private String parentid; 
	
	//父结点id列表串 : parentids 	
	private String parentids; 
	
	//排序号 : sortstring 	
	private String sortstring; 
	
	//是否可用,1：可用，0不可用 : available 	
	private String available; 
	

	/**
	 * 主键 : id
	 * 
	 * @return 
	 */
	public Long getId () {
		return id;
	}
	
	/**
	 * 主键 : id
	 * 
	 * @return 
	 */
	public void setId (Long id) {
		this.id = id;
	}
	/**
	 * 资源名称 : name
	 * 
	 * @return 
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * 资源名称 : name
	 * 
	 * @return 
	 */
	public void setName (String name) {
		this.name = name;
	}
	/**
	 * 资源类型：menu,button, : type
	 * 
	 * @return 
	 */
	public String getType () {
		return type;
	}
	
	/**
	 * 资源类型：menu,button, : type
	 * 
	 * @return 
	 */
	public void setType (String type) {
		this.type = type;
	}
	/**
	 * 访问url地址 : url
	 * 
	 * @return 
	 */
	public String getUrl () {
		return url;
	}
	
	/**
	 * 访问url地址 : url
	 * 
	 * @return 
	 */
	public void setUrl (String url) {
		this.url = url;
	}
	/**
	 * 权限代码字符串 : percode
	 * 
	 * @return 
	 */
	public String getPercode () {
		return percode;
	}
	
	/**
	 * 权限代码字符串 : percode
	 * 
	 * @return 
	 */
	public void setPercode (String percode) {
		this.percode = percode;
	}
	/**
	 * 父结点id : parentid
	 * 
	 * @return 
	 */
	public String getParentid () {
		return parentid;
	}
	
	/**
	 * 父结点id : parentid
	 * 
	 * @return 
	 */
	public void setParentid (String parentid) {
		this.parentid = parentid;
	}
	/**
	 * 父结点id列表串 : parentids
	 * 
	 * @return 
	 */
	public String getParentids () {
		return parentids;
	}
	
	/**
	 * 父结点id列表串 : parentids
	 * 
	 * @return 
	 */
	public void setParentids (String parentids) {
		this.parentids = parentids;
	}
	/**
	 * 排序号 : sortstring
	 * 
	 * @return 
	 */
	public String getSortstring () {
		return sortstring;
	}
	
	/**
	 * 排序号 : sortstring
	 * 
	 * @return 
	 */
	public void setSortstring (String sortstring) {
		this.sortstring = sortstring;
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
			return "SysPermission ["+
						"id=" + id +
								",name=" + name +
								",type=" + type +
								",url=" + url +
								",percode=" + percode +
								",parentid=" + parentid +
								",parentids=" + parentids +
								",sortstring=" + sortstring +
								",available=" + available +
							"]";
	}

 
}
