package com.dao;

import java.util.Date;
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
	
	//���汾ID��ѯ
	public Appversion versionID(@Param("id")int id);
	
	//�޸İ汾
	public int versionUpdate(Appversion appversion);
	
	//��id��ѯappinfo
	public Appinfo selectAppinfoId(@Param("id")int id);
	
	//����ƽ̨
	public List<Datadictionary> selectdata(@Param("typeCode")String typeCode);
	
	//���d�����˵�
	public List<Appcategory> seleerjcd(@Param("id")String id);
	
	//�޸�App������Ϣ
	public int updateappinfo(Appinfo appinfo);
	
	//ɾ��App��Ϣ
	public int deleteappinfo(@Param("id")int id);
	
	//����App��Ϣ
	public int addAppinfo(Appinfo appinfo);
	
	//���¼�
	public int sale(Appinfo appinfo);
}
