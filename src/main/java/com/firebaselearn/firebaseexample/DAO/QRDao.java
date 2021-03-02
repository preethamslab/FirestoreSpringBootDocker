package com.firebaselearn.firebaseexample.DAO;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firebaselearn.firebaseexample.config.FirebaseInitializer;
import com.firebaselearn.firebaseexample.model.QRModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

@Service
public class QRDao 
{
	@Autowired
	private FirebaseInitializer db;
	
	/*
	 * private CollectionReference getQRCollection() { return
	 * db.getFirebase().collection("restaurant-use-case"); }
	 */
	
	
	public String saveQRDetails(QRModel qrmodel) throws Exception
	{
		Firestore firstore = db.getFirebase();
		
		ApiFuture<WriteResult> collectionsAPIFuture = firstore.collection("restaurant-use-case")
				.document(qrmodel.getUuid().toString())
				.set(qrmodel);
		
		 String ret = collectionsAPIFuture.get().getUpdateTime().toString();
		 if(collectionsAPIFuture.isDone())
		 {
			// firstore.close();
		 }
		 return ret;
	}
	
	
	public QRModel getQRDetails(String uuid) throws Exception
	{
		
		Firestore firstore = db.getFirebase();
		DocumentReference documentRef = firstore.collection("restaurant-use-case").document(uuid);
		ApiFuture<DocumentSnapshot> future = documentRef.get();
		
		DocumentSnapshot document = future.get();
		
		QRModel qrmodel = null;
		
		if(document.exists())
		{
			qrmodel = document.toObject(QRModel.class);
			//firstore.close();
		}
		
		return qrmodel;

	}
}
