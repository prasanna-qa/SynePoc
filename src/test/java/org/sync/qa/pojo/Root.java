 package org.sync.qa.pojo;



import org.apache.juneau.annotation.Beanc;

public class Root
 {
     private Crdentials crdentials;
     
     @Beanc(properties="crdentials")
     public Root(Crdentials crdentials) {
 		super();
 		this.crdentials = crdentials;
 	}

     public void setCrdentials(Crdentials crdentials){
         this.crdentials = crdentials;
     }
    
	public Crdentials getCrdentials(){
         return this.crdentials;
     }
 }