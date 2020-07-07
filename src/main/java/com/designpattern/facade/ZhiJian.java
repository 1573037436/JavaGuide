package com.designpattern.facade;

public interface ZhiJian {
	void orgCodeCertificate();//办理组织机构代码证
}
class HaidianZhiJian implements ZhiJian{

	@Override
	public void orgCodeCertificate() {
		
		System.out.println("到海淀区质监局办理组织机构代码证");
	}
	
}