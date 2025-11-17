package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;

import app.domain.ports.ClinicalOrderPort;

import app.domain.ports.ShearchClinicalOrderPort;
@Service
public class ShearchClinicalOrderService {
	@Autowired
	private ClinicalOrderPort orderPort;
	@Autowired
	private ShearchClinicalOrderPort shearchClinicalOrderPort;

	public List<ClinicalOrder> search(ClinicalOrder clinicalOrder) throws Exception {
		clinicalOrder = orderPort.findById(clinicalOrder);
		if (clinicalOrder == null) {
			throw new Exception("debe consultar una orden de un paciente registrado");
		}
		return shearchClinicalOrderPort.findByOrder(clinicalOrder);

	}

}
