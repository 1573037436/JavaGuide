package com.zzj.javaSE.model;

public class Address implements Cloneable{
	private String state;//国家
	private String province;//省
	private String city;//市

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address(String state, String province, String city) {
		super();
		this.state = state;
		this.province = province;
		this.city = city;
	}

	public Address() {
		super();
	}
	
	// 实现浅克隆
	@Override
	public Object clone(){
		Address address = null;
		try {
			address = (Address) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return address;
	}


	@Override
	public String toString() {
		return "Address [state=" + state + ", province=" + province + ", city=" + city + "]";
	}

	
}
