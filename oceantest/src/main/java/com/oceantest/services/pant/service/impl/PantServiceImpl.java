package com.oceantest.services.pant.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oceantest.services.jpa.service.PantJpaService;
import com.oceantest.services.pant.model.Pant;
import com.oceantest.services.pant.service.PantService;

@Component
public class PantServiceImpl implements PantService {

	@Autowired 
	private PantJpaService pantJpaService;
	
	 
	private static final AtomicLong counter = new AtomicLong();
	private static List<Pant> pants;

	static {
		pants = virtualPant();
	}

	public void createPant(Pant pant) {
//		pantJpaService

		pant.setId(counter.incrementAndGet());
		pants.add(pant);
	}

	public List<Pant> findAllPant() {

		// List<Map<String,Object>> aaa =new RestTempleteGetUtils() {
		//
		// @Override
		// public String url() {
		// // TODO Auto-generated method stub
		//// return
		// "http://192.168.1.72:9004/oceantest/rest/shirtrest/shirt/jpa/";
		// return "http://localhost:9004/oceantest/rest/Pant/pant/jpa/";
		// }
		//
		// @Override
		// public Map<String, Object> methodUrlVariables() {
		// // TODO Auto-generated method stub
		// return null;
		// }
		// }.getData(new TypeToken<List<Map<String,Object>>>(){}.getType());
		//
		// System.out.println("===> "+ new Gson().toJson(aaa));

		return pants;
	}

	public Pant findById(long id) {
		for (Pant pant : pants) {
			if (pant.getId() == id) {
				return pant;
			}
		}
		return null;
	}

	public Pant findByBrandName(String brand) {
		for (Pant pant : pants) {
			if (pant.getBrand() == brand) {
				return pant;
			}
		}
		return null;
	}

	public void updatePant(Pant pant) {
		int index = pants.indexOf(pant);
		pants.set(index, pant);
	}

	public void deletePantById(long id) {
		for (Iterator<Pant> iterator = pants.iterator(); iterator.hasNext();) {
			Pant pant = iterator.next();
			if (pant.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void deleteAllPant() {
		pants.clear();
	}

	public boolean isPantExist(Pant pant) {
		return findByBrandName(pant.getBrand()) != null;
	}

	private static List<Pant> virtualPant() {
		List<Pant> pants = new ArrayList<Pant>();
		pants.add(new Pant(counter.incrementAndGet(), "AAA", 1, 200));
		pants.add(new Pant(counter.incrementAndGet(), "BBB", 2, 300));
		pants.add(new Pant(counter.incrementAndGet(), "CCC", 3, 500));
		pants.add(new Pant(counter.incrementAndGet(), "DDD", 4, 700));
		pants.add(new Pant(counter.incrementAndGet(), "EEE", 5, 900));
		return pants;
	}

}
