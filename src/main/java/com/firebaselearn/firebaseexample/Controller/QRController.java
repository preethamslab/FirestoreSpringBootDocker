package com.firebaselearn.firebaseexample.Controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firebaselearn.firebaseexample.DAO.QRDao;
import com.firebaselearn.firebaseexample.model.QRModel;

@RestController
public class QRController 
{
	@Autowired
	private QRDao qrservice;
   

	
	@PostMapping("/qrcode/creatae")
   public String getQRCode(@RequestBody QRModel qrmode) throws Exception
   {
	   String ret="";
	 try{
		ret= qrservice.saveQRDetails(qrmode);
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		ret = e.getMessage();
		e.printStackTrace();
	
	}
	return ret;
   }
	
	@GetMapping("/qrcode/{uuid}")
	public QRModel getQRDetails(@PathVariable String uuid) throws Exception
	{
		return qrservice.getQRDetails(uuid);
	}
}
