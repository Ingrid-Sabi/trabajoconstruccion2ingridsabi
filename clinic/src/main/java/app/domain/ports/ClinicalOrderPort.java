package app.domain.ports;


import app.domain.model.ClinicalOrder;


public interface ClinicalOrderPort {
	
	public ClinicalOrder findById(ClinicalOrder order)throws Exception;
	public void save(ClinicalOrder order)throws Exception;


}
