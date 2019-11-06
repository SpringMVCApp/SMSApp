package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BackendMapper;
import com.entity.Appcategory;
import com.entity.Appinfo;
import com.entity.Appversion;
import com.entity.Backenduser;
import com.entity.Datadictionary;
import com.service.BackendmsService;
@Service("backendservice")
public class BackendmsServiceimpl implements BackendmsService{
	@Resource
	private BackendMapper backendMapper;
	
	public Backenduser dologin(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		return backendMapper.dologin(userCode, userPassword);
	}

	//��ѯ�����ͷ�ҳ
	public List<Appinfo> backlist(String softwareName, int flatformId, int categoryLevel1, int categoryLevel2,
			int categoryLevel3, int pageindex, int pagesize) {
		return backendMapper.backlist(softwareName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, pageindex, pagesize);
	}

	//������
	public int Count() {
		return backendMapper.Count();
	}

	//ƽ̨
	public List<Datadictionary> selectpt() {
		return backendMapper.selectpt();
	}

	//һ���˵���ѯ
	public List<Appcategory> selectcd() {
		return backendMapper.selectcd();
	}

	//�����˵�
	public List<Appcategory> selectecd(int id) {
		return backendMapper.selectecd(id);
	}

	//ͨ��ID��ѯappinfo
	public Appinfo selectID(int aid) {
		return backendMapper.selectID(aid);
	}

	//ͨ��ID��ѯcategory
	public Appversion selectversion(int id) {
		return backendMapper.selectversion(id);
	}

	//���
	public int checksave(Appinfo appinfo) {
		return backendMapper.checksave(appinfo);
	}

}
