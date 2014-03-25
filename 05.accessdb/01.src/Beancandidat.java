package workflow;

import java.io.Serializable;

public class Beancandidat implements Serializable 
{
	private int id;
	private String intitule;
    private String descriptif;
    private String nom;
    private String prenom;
    private String cv;
    private String rh;
    private String dop;
    private String validation;
private int processorder; 
private String deroulement;

  
    public String getDescriptif() {
        return descriptif;
    }

  
    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

  
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getCv() {
        return cv;
    }


    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }


    public String getDop() {
        return dop;
    }


    public void setDop(String dop) {
        this.dop = dop;
    }


    public String getValidation() {
        return validation;
    }


    public void setValidation(String validation) {
        this.validation = validation;
    }
    
	
	
	 public String getIntitule() {
        return intitule;
    }


    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
	
	
	public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

	public void setProcessorder(int processorder)
	{
		this.processorder=processorder;
	}

	public int getProcessorder()
	{
		return this.processorder;
	}

	public void setDeroulement(String deroulement)
	{
		this.deroulement=deroulement;
	}

	public String getDeroulement()
	{
		return this.deroulement;
	}
	
	public Beancandidat()
	{
	}
    
}
