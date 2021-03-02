package com.firebaselearn.firebaseexample.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer 
{
	private static Firestore firestore=null;
	
	@PostConstruct
	public void initialize() throws IOException
	{
			System.out.println("inside initializer");
		InputStream serviceAccount = new URL("<url or file reference for your firebase service account >").openStream();
	
		/*
		 * FirebaseOptions options = new FirebaseOptions.Builder()
		 * .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		 * .setDatabaseUrl("https://testprojforcicd.firebase.io") .build();
		 */
		
		FirestoreOptions firestoreoptions = FirestoreOptions.newBuilder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				//.setProjectId("testprojforcicd")
				.build();
		
		
		  if(firestore==null) 
		  {
			  firestore = firestoreoptions.getService(); 
		  }
		 
		/*
		 * if(FirebaseApp.getApps().isEmpty()) { FirebaseApp.initializeApp(options); }
		 */
	}
	public Firestore getFirebase()
	{
		return firestore;
	}
}
