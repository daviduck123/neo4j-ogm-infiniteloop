package com.david.duck.controller;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.david.duck.model.Fetch1;
import com.david.duck.model.Fetch2;
import com.david.duck.model.Fetch3;
import com.david.duck.model.Master;
import com.david.duck.repository.Fetch1Repository;
import com.david.duck.repository.Fetch2Repository;
import com.david.duck.repository.Fetch3Repository;

@Controller
public class FetchController {

	@Autowired
	Fetch1Repository fetch1Repository;
	
	@Autowired
	Fetch2Repository fetch2Repository;
	 
	@Autowired
	Fetch3Repository fetch3Repository;
	
	@RequestMapping(value="/saveFetch", method = RequestMethod.GET)
	public @ResponseBody String saveFetchData(){
		for(int i=0;i<50;i++){
			Fetch1 fetch1=new Fetch1();
			fetch1.setName("Fetch1."+i);
			fetch1Repository.save(fetch1);
			
			List<Fetch2> listFetch2=new ArrayList<Fetch2>();
			for(int j=0; j<25;j++){
				Fetch2 fetch2=new Fetch2();
				fetch2.setName("Fetch2."+j+"-Fetch1."+i);
				fetch2.setFetch1(fetch1);
				fetch2Repository.save(fetch2);
				
				List<Fetch3> listFetch3=new ArrayList<Fetch3>();
				for(int k=0;k<10;k++){
					Fetch3 fetch3=new Fetch3();
					fetch3.setName("Fetch3."+k+"-Fetch2."+j+"-Fetch1."+i);
					fetch3.setFetch2(fetch2);
					fetch3Repository.save(fetch3);
					
					listFetch3.add(fetch3);
				}
				fetch2.setFetch3(listFetch3);
				fetch2Repository.save(fetch2);
				
				listFetch2.add(fetch2);
			}
			fetch1.setFetch2(listFetch2);
			fetch1Repository.save(fetch1);
		}
				
		return "Success Save";
	}
	
	@RequestMapping(value="/getFetch/{depth}", method = RequestMethod.GET)
	public @ResponseBody List<Fetch2 >getFetchData(@PathVariable String depth){
				
		int depthInt=Integer.parseInt(depth);
		Iterable<Fetch1> results = fetch1Repository.findAll(depthInt);
		List<Fetch1> dataListFetch=new ArrayList<Fetch1>(IteratorUtil.asCollection(results));
		
		return dataListFetch.get(0).getFetch2();
	}
	
	@RequestMapping(value="/getFetch", method = RequestMethod.GET)
	public @ResponseBody List<Fetch1> getFetchDataDefault(){
				
		Iterable<Fetch1> results = fetch1Repository.findAll();
		List<Fetch1> dataListFetch=new ArrayList<Fetch1>(IteratorUtil.asCollection(results));
		
		return dataListFetch;
	}
	
	
	@RequestMapping(value="/deleteFetch", method = RequestMethod.GET)
	public @ResponseBody String deleteFetchData(){
		fetch1Repository.deleteAll();
		fetch2Repository.deleteAll();
		fetch3Repository.deleteAll();
	
		return "Success Delete";
	}
	
	@RequestMapping(value="/Fetch2/{id}", method = RequestMethod.GET)
	public @ResponseBody Fetch1 FetchData(@PathVariable String id){
		//fetch2.add(fetch2Repository.findOne((long)7225));
//		Fetch2 fetch2= fetch2Repository.findOne((long)7225);
//		Fetch1 fetch = fetch1Repository.findByFetch2(fetch2);
		Fetch1 fetch=fetch1Repository.findById(Long.parseLong(id));
		
		return fetch;
	}
}
