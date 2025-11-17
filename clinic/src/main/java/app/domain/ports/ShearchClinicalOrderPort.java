package app.domain.ports;

import java.util.List;

import app.domain.model.ClinicalOrder;

public interface ShearchClinicalOrderPort {
	public List<ClinicalOrder> findByOrder(ClinicalOrder order)throws Exception;
}
