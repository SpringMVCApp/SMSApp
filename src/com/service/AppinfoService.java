package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;

public interface AppinfoService {
	//��ѯ�����ͷ�ҳ
	public List<Appinfo> selectAll(String softwareName,int status,int flatformId,int categoryLevel1,int categoryLevel2,int categoryLevel3,int pageindex,int pagesize);
	
	//������
	public int Count();
	
	//״̬
	public List<Datadictionary> selectdictionary();
	
	//ƽ̨
	public List<Datadictionary> selectpt();
	
	//һ���˵���ѯ
	public List<Appcategory> selectcd();
	
	//�����˵�
	public List<Appcategory> selectecd(int id);
	
	//��ʷ�汾�б�
	public List<Appversion> selectversion(int id);
	
	//�����汾�б�
	public int addversioninfo(Appversion appversion);
	
	//���°汾
	public int updateversionId(int vid,int aid);
	
	//��ѯ�汾ID
	public Appversion selectversionID(int appId,String versionNo);
}
