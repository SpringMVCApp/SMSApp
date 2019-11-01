package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;

public interface AppinfoMapper {
	//��ѯ�����ͷ�ҳ
	public List<Appinfo> selectAll(@Param("softwareName")String softwareName,
			@Param("status")int status,
			@Param("flatformId")int flatformId,
			@Param("categoryLevel1")int categoryLevel1,
			@Param("categoryLevel2")int categoryLevel2,
			@Param("categoryLevel3")int categoryLevel3,
			@Param("pageindex")int pageindex,
			@Param("pagesize")int pagesize);

	//������
	public int Count();
	
	//״̬
	public List<Datadictionary> selectdictionary();
	
	//ƽ̨
	public List<Datadictionary> selectpt();
	
	//һ���˵���ѯ
	public List<Appcategory> selectcd();
	
	//�����˵�
	public List<Appcategory> selectecd(@Param("id")int id);
	
	//��ʷ�汾�б�
	public List<Appversion> selectversion(@Param("id")int id);
	
	//�����汾�б�
	public int addversioninfo(Appversion appversion);
	
	//���°汾
	public int updateversionId(@Param("vid")int vid,@Param("aid")int aid);
	
	//��ѯ�汾ID
	public Appversion selectversionID(@Param("appId")int appId,@Param("versionNo")String versionNo);
	
}
