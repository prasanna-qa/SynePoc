package org.sync.qa.pojo;

import org.apache.juneau.annotation.Beanc;

public class Crdentials
{
    private It it;
   	private Uat uat;
    private Prod prod;
    
    @Beanc(properties="it,uat,prod")
    public Crdentials(It it, Uat uat, Prod prod) {
		super();
		this.it = it;
		this.uat = uat;
		this.prod = prod;
	}

    public void setIt(It it){
        this.it = it;
    }
    public It getIt(){
        return this.it;
    }
    public void setUat(Uat uat){
        this.uat = uat;
    }
    public Uat getUat(){
        return this.uat;
    }
    public void setProd(Prod prod){
        this.prod = prod;
    }
    public Prod getProd(){
        return this.prod;
    }
}
