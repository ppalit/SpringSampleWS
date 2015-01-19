package dev.priyo.spring.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.priyo.spring.beans.Address;
import dev.priyo.spring.beans.NameBean;

@Controller
public class SampleRestController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@RequestMapping(value = "/rest/hello", method = RequestMethod.GET)
    public @ResponseBody NameBean getDummyEmployee() {
        System.out.println("in get");
        return getNameBean("ABC");
    }
     
	 @RequestMapping(value = "/rest/hello1", method = RequestMethod.POST)
	    public @ResponseBody NameBean createEmployee(@RequestBody NameBean nameBean) {
	       System.out.println("in post");
	       nameBean.setName("Priyo");
	        return nameBean;
	    }
	
	private NameBean getNameBean(String name){
		NameBean nameBean = new NameBean();
		nameBean.setName(name);
		nameBean.setPhoneNo(427634);
		
		Address add = new Address();
		add.setAddress1("Wayne");
		add.setZipCode(07470);
		
		nameBean.setAdd(add);
		return nameBean;
	}
}
