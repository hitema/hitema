package workflow;

import java.io.Serializable;
import workflow.rediger.*;
import workflow.interviewerdop.*;
import workflow.interviewerrh.*;
import workflow.selectionner.*;
import workflow.valider.*;
import workflow.accessdb.*;


public class CandidatOrchestrator implements Serializable 
{
	private int id = 0;
	private String intitule = "";
	    private String descriptif = "";
	    private String nom = "";
	    private String prenom = "";
	    private String cv = "";
	    private String rh = "";
	    private String dop = "";
	    private String validation = "";
private int processorder  = 0; 
private String deroulement = "";


	public workflow.accessdb.BeancandidatDB getCandidatDB()
	{
		workflow.accessdb.BeancandidatDB bean = new workflow.accessdb.BeancandidatDB();
		bean.setId(id);
		bean.setDescriptif(descriptif);
		bean.setNom(nom);
		bean.setPrenom(prenom);
		bean.setCv(cv);
		bean.setRh(rh);
		bean.setDop(dop);
		bean.setValidation(validation);
		bean.setProcessorder(processorder);
		bean.setDeroulement(deroulement);
		return bean;
		
	}

	public void setCandidatDB(workflow.accessdb.BeancandidatDB bean)
	{
		this.setId(bean.getId());
		this.setDescriptif(bean.getDescriptif());
		this.setNom(bean.getNom());
		this.setPrenom(bean.getPrenom());
		this.setCv(bean.getCv());
		this.setRh(bean.getRh());
		this.setDop(bean.getDop());
		this.setValidation(bean.getValidation());
		this.setProcessorder(bean.getProcessorder());
		this.setDeroulement(bean.getDeroulement());
	}

	public workflow.rediger.Beancandidat getRedigerCandidat()
	{
		workflow.rediger.Beancandidat bean = new workflow.rediger.Beancandidat();
		bean.setId(id);
		bean.setDescriptif(descriptif);
		bean.setNom(nom);
		bean.setPrenom(prenom);
		bean.setCv(cv);
		bean.setRh(rh);
		bean.setDop(dop);
		bean.setValidation(validation);
		bean.setProcessorder(processorder);
		bean.setDeroulement(deroulement);
		return bean;
	}

	public void setRedigerCandidat(workflow.rediger.Beancandidat bean)
	{
		this.setId(bean.getId());
		this.setDescriptif(bean.getDescriptif());
		this.setNom(bean.getNom());
		this.setPrenom(bean.getPrenom());
		this.setCv(bean.getCv());
		this.setRh(bean.getRh());
		this.setDop(bean.getDop());
		this.setValidation(bean.getValidation());
		this.setProcessorder(bean.getProcessorder());
		this.setDeroulement(bean.getDeroulement());
	}
	
	public workflow.selectionner.Beancandidat getSelectionCandidat()
	{
		workflow.selectionner.Beancandidat bean = new workflow.selectionner.Beancandidat();
		bean.setId(id);
		bean.setDescriptif(descriptif);
		bean.setNom(nom);
		bean.setPrenom(prenom);
		bean.setCv(cv);
		bean.setRh(rh);
		bean.setDop(dop);
		bean.setValidation(validation);
		bean.setProcessorder(processorder);
		bean.setDeroulement(deroulement);
		return bean;
	}

	public void setSelectionCandidat(workflow.selectionner.Beancandidat bean)
	{
		this.setId(bean.getId());
		this.setDescriptif(bean.getDescriptif());
		this.setNom(bean.getNom());
		this.setPrenom(bean.getPrenom());
		this.setCv(bean.getCv());
		this.setRh(bean.getRh());
		this.setDop(bean.getDop());
		this.setValidation(bean.getValidation());
		this.setProcessorder(bean.getProcessorder());
		this.setDeroulement(bean.getDeroulement());
	}

	public workflow.valider.Beancandidat getValiderCandidat()
	{
		workflow.valider.Beancandidat bean = new workflow.valider.Beancandidat();
		bean.setId(id);
		bean.setDescriptif(descriptif);
		bean.setNom(nom);
		bean.setPrenom(prenom);
		bean.setCv(cv);
		bean.setRh(rh);
		bean.setDop(dop);
		bean.setValidation(validation);
		bean.setProcessorder(processorder);
		bean.setDeroulement(deroulement);
		return bean;
	}

	public void setValiderCandidat(workflow.valider.Beancandidat bean)
	{
		this.setId(bean.getId());
		this.setDescriptif(bean.getDescriptif());
		this.setNom(bean.getNom());
		this.setPrenom(bean.getPrenom());
		this.setCv(bean.getCv());
		this.setRh(bean.getRh());
		this.setDop(bean.getDop());
		this.setValidation(bean.getValidation());
		this.setProcessorder(bean.getProcessorder());
		this.setDeroulement(bean.getDeroulement());
	}

	public workflow.interviewerrh.Beancandidat getInterviewerRhCandidat()
	{
		workflow.interviewerrh.Beancandidat bean = new workflow.interviewerrh.Beancandidat();
		bean.setId(id);
		bean.setDescriptif(descriptif);
		bean.setNom(nom);
		bean.setPrenom(prenom);
		bean.setCv(cv);
		bean.setRh(rh);
		bean.setDop(dop);
		bean.setValidation(validation);
		bean.setProcessorder(processorder);
		bean.setDeroulement(deroulement);
		return bean;
	}

	public void setInterviewerRhCandidat(workflow.interviewerrh.Beancandidat bean)
	{
		this.setId(bean.getId());
		this.setDescriptif(bean.getDescriptif());
		this.setNom(bean.getNom());
		this.setPrenom(bean.getPrenom());
		this.setCv(bean.getCv());
		this.setRh(bean.getRh());
		this.setDop(bean.getDop());
		this.setValidation(bean.getValidation());
		this.setProcessorder(bean.getProcessorder());
		this.setDeroulement(bean.getDeroulement());
	}

	public workflow.interviewerdop.Beancandidat getInterviewerDopCandidat()
	{
		workflow.interviewerdop.Beancandidat bean = new workflow.interviewerdop.Beancandidat();
		bean.setId(id);
		bean.setDescriptif(descriptif);
		bean.setNom(nom);
		bean.setPrenom(prenom);
		bean.setCv(cv);
		bean.setRh(rh);
		bean.setDop(dop);
		bean.setValidation(validation);
		bean.setProcessorder(processorder);
		bean.setDeroulement(deroulement);
		return bean;
	}

	public void setInterviewerDopCandidat(workflow.interviewerdop.Beancandidat bean)
	{
		this.setId(bean.getId());
		this.setDescriptif(bean.getDescriptif());
		this.setNom(bean.getNom());
		this.setPrenom(bean.getPrenom());
		this.setCv(bean.getCv());
		this.setRh(bean.getRh());
		this.setDop(bean.getDop());
		this.setValidation(bean.getValidation());
		this.setProcessorder(bean.getProcessorder());
		this.setDeroulement(bean.getDeroulement());
	}
  
  
  
  
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
	
	public CandidatOrchestrator()
	{
	}
    
}
