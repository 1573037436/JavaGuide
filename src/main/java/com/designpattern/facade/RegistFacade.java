package com.designpattern.facade;
/**
 * 办理注册公司流程的门面对象
 * @author zhoucheng
 *
 */
public class RegistFacade {
	public void regist(){
		Gongshang gongshang=new HaidianGongshang();
		gongshang.checkName();
		ZhiJian zhiJian=new HaidianZhiJian();
		zhiJian.orgCodeCertificate();
		ShuiWu shuiWu=new HaidianShuiWu();
		shuiWu.jiaoShui();
		Bank bank=new haiDianBank();
		bank.kaiHu();	
	}
}
