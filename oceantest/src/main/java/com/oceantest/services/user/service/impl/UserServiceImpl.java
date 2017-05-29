//package com.oceantest.services.user.service.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.oceantest.services.user.model.UserEntity;
//import com.oceantest.services.user.service.UserService;
//
//@Service("userJpaService")
////@Repository
//@Transactional
////@Transactional(readOnly = false)
//public class UserServiceImpl implements UserService{
//
//	@PersistenceContext	
//	private EntityManager entityManager;
//	
////	@Autowired
////	PersonRepository pr;
//	
//	public List<UserEntity> findAll() throws Exception{
//		
//		return entityManager.createNamedQuery("UserEntity.findAll",UserEntity.class).setMaxResults(10).getResultList();
//	};
//	
//	public UserEntity findById() throws Exception{
//		return entityManager.find(UserEntity.class, 0);
//	};
//}
