package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Backenduser;
import com.entity.Datadictionary;

public interface BackendmsService {
	//��֤��¼
	public Backenduser dologin(String userCode,String userPassword);
	
	//��ѯ�����ͷ�ҳ
	public List<Appinfo> backlist(@Param("softwareName")String softwareName,
						@Param("flatformId")int flatformId,
						@Param("categoryLevel1")int categoryLevel1,
						@Param("categoryLevel2")int categoryLevel2,
						@Param("categoryLevel3")int categoryLevel3,
						@Param("pageindex")int pageindex,
						@Param("pagesize")int pagesize);
	//������
	public int Count();
	
	//ƽ̨
	public List<Datadictionary> selectpt();
	
	//һ���˵���ѯ
	public List<Appcategory> selectcd();
	
	//�����˵�
	public List<Appcategory> selectecd(int id);
	
	//ͨ��ID��ѯappinfo
	public Appinfo selectID(int aid);
	
	//ͨ��ID��ѯcategory
	public  Appversion selectversion(int id);
	
	//���
	public int checksave(Appinfo appinfo);
}
