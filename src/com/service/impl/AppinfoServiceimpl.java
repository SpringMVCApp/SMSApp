package com.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AppinfoMapper;
import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Datadictionary;
import com.service.AppinfoService;
@Service("Appinfoservice")
public class AppinfoServiceimpl implements AppinfoService{
	@Resource
	private AppinfoMapper appinfoMapper;
	//��ѯ�����ͷ�ҳ
	public List<Appinfo> selectAll(String softwareName, int status, int flatformId, int categoryLevel1,
			int categoryLevel2, int categoryLevel3, int pageindex, int pagesize) {
		return appinfoMapper.selectAll(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageindex, pagesize);
	}
	//������
	public int Count() {
		return appinfoMapper.Count();
	}
	//״̬
	public List<Datadictionary> selectdictionary() {
		return appinfoMapper.selectdictionary();
	}
	//ƽ̨
	public List<Datadictionary> selectpt() {
		return appinfoMapper.selectpt();
	}
	//һ���˵���ѯ
	public List<Appcategory> selectcd() {
		return appinfoMapper.selectcd();
	}
	//�����˵�
	public List<Appcategory> selectecd(int id) {
		return appinfoMapper.selectecd(id);
	}
	//��ʷ�汾�б�
	public List<Appversion> selectversion(int id) {
		return appinfoMapper.selectversion(id);
	}
	//�����汾�б�
	public int addversioninfo(Appversion appversion) {
		return appinfoMapper.addversioninfo(appversion);
	}
	//���°汾
	public int updateversionId(int vid, int aid) {
		return appinfoMapper.updateversionId(vid, aid);
	}
	//��ѯ�汾ID
	public Appversion selectversionID(int appId,String versionNo) {
		return appinfoMapper.selectversionID(appId,versionNo);
	}
	//���汾ID��ѯ
	public Appversion versionID(int id) {
		return appinfoMapper.versionID(id);
	}
	//�޸İ汾
	public int versionUpdate(Appversion appversion) {
		return appinfoMapper.versionUpdate(appversion);
	}
	//��id��ѯappinfo
	public Appinfo selectAppinfoId(int id) {
		return appinfoMapper.selectAppinfoId(id);
	}
	//����ƽ̨
	public List<Datadictionary> selectdata(String typeCode) {
		return appinfoMapper.selectdata(typeCode);
	}
	//���d�����˵�
	public List<Appcategory> seleerjcd(String id) {
		return appinfoMapper.seleerjcd(id);
	}
	
	//�޸�App������Ϣ
	public int updateappinfo(Appinfo appinfo) {
		return appinfoMapper.updateappinfo(appinfo);
	}
	//ɾ��App��Ϣ
	public int deleteappinfo(int id) {
		return appinfoMapper.deleteappinfo(id);
	}
	//����App��Ϣ
	public int addAppinfo(Appinfo appinfo) {
		return appinfoMapper.addAppinfo(appinfo);
	}
	//���¼�
	public int sale(Appinfo appinfo) {
		return appinfoMapper.sale(appinfo);
	}

}
