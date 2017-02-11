package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RepairPartsDao;
import com.icephone.model.RepairProject;
import com.icephone.pojo.RepairParts;
import com.icephone.service.RepairPartsService;


@Service
public class RepairPartsServiceImpl implements RepairPartsService {

	@Autowired
	private RepairPartsDao repairPartsDao;
	
	@Override
	public boolean addParts(RepairParts rPart) {
		//name check if exist
		
		
		//save
		repairPartsDao.add(rPart);
		return true;
	}
	
	
	@Override
	public List getAllParts() {
		List list = repairPartsDao.getAllParts();
		List<RepairProject> projectList = new ArrayList<RepairProject>();
		
		//转换数据
		for(int i=0;i<list.size();i++){
			RepairProject project = new RepairProject();
			project.setPart((RepairParts)list.get(i));
			String partName = ((RepairParts)list.get(i)).getRpParts();
			String names[] = partName.split("、");
			ArrayList<String> partNameList = new ArrayList<String>();
			for(int j=0;j<names.length;j++){
				partNameList.add(names[j]);
			}
			project.setPartNames(partNameList);
			projectList.add(project);
		}
		return projectList;
	}

	@Override
	public boolean updatePartsContent(int pId, String pName, String pParts,
			int pStatus) {
		RepairParts rParts = repairPartsDao.getById(RepairParts.class, pId);
		if(rParts==null){
			return false;
		}
		pName = pName.trim();
		pParts = pParts.trim();
		if((pName!=null)&&(pName!="")){
			rParts.setRpName(pName);
		}
		if((pParts!=null)&&(pParts!="")){
			rParts.setRpParts(pParts);;
		}
		if(pStatus>0){
			rParts.setRpValid(pStatus);
		}
		repairPartsDao.update(rParts);
		return true;
	}

	

}
