//package com.oceantest.services.service;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.oceantest.services.policy.model.SlipPaEntity;
//
//public class SlipPaServiceImpl implements SlipPaService {
//	
//	private static final Logger LOG = LoggerFactory.getLogger(SlipPaServiceImpl.class);
//	
//	@Autowired
//    private EntityManager em;
//	
//	/////////////////////////////////////////
//
//	@Override
//	//บันทึกข้อมูลลงตาราง slip_pa
//	public void insertSlipa(List<SlipPaEntity> slipPaEntityList) throws Exception {
//		String uniqId = "YiemYiem";
//		
//		log(uniqId,"Enter insertSlipa()");
//		if(slipPaEntityList==null || slipPaEntityList.isEmpty()){
//			throw new Exception("Error : Can not insert slip_pa : rowData for insert is null");
//		}
//		
//		log(uniqId,"slipPaEntityList.size() = "+ slipPaEntityList.size());
//		
//		for(SlipPaEntity obj : slipPaEntityList) {
//			obj.setCreateDate(new Date());
//			obj.setCreateBy("ParePare");
//			obj.setUpdateDate(new Date());
//			obj.setUpdateBy("ParePare");
//			
//			em.persist(obj);
//			log(uniqId,"- obj.getId() = "+ obj.getId());
//		}
//		
//		em.flush();
//		log(uniqId, "Exit insertSlipa()");
//	}
//	
//	@Override
//	//ค้นหาข้อมูลจาก slip_pa โดยใช้ primary key
//	public SlipPaEntity getSlipPaById(Long id) throws Exception {
//		String uniqId = "YiemYiem";
//		log(uniqId,"Enter getSlipPaById(id="+id+")");
//		SlipPaEntity entity = em.find(SlipPaEntity.class, id);
//		if(entity!=null){
//			log(uniqId, "found data");
//		}else{
//			log(uniqId, "Not found data");
//		}
//		log(uniqId, "Exit getSlipPaById()");
//		return entity;
//	}
//	
//	/////////////////////////////////////////////
//	private void log(String uniqId, String msg) {
//		if (LOG.isDebugEnabled()) {
//			if (StringUtils.isBlank(uniqId)) {
//				LOG.debug(msg);
//			} else {
//				LOG.debug(uniqId + " " + msg);
//			}
//		}
//	}
//
//}
