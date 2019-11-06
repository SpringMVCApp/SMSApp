package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Backenduser;
import com.entity.Datadictionary;

public interface BackendMapper {
	//��֤��¼
	public Backenduser dologin(@Param("userCode")String userCode,@Param("userPassword")String userPassword);
	
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
	public List<Appcategory> selectecd(@Param("id")int id);
	
	//ͨ��ID��ѯappinfo
	public Appinfo selectID(@Param("aid")int aid);
	
	//ͨ��ID��ѯcategory
	public Appversion selectversion(@Param("id")int id);
	
	//���
	public int checksave(Appinfo appinfo);
}