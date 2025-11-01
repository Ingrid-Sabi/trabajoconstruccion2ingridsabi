package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.InvoicePort;
import app.domain.ports.PatientPort;
@Service
public class CreateInvoice {
	@Autowired
	private PatientPort patientPort;
	@Autowired
    private ClinicalOrderPort clinicalOrderPort;
	@Autowired
    private InvoicePort invoicePort;

    public void createInvoice(Invoice invoice) throws Exception {
        Patient posiblePatient = new Patient();
        posiblePatient.setDocument(invoice.getDocument());
        Patient patient = patientPort.findByDocument(posiblePatient); // tipo paciente y no tipo cedula
        if (patient == null){
            throw new Exception("La factura debe tener un paciente asociado");
        }
        if (invoice.isMedicine()){
            ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(invoice.getOrder());
            if (clinicalOrder == null || patient.getDocument() != clinicalOrder.getPatientName().getDocument()) {
                throw new Exception("El medicamento requiere de una orden asociada");
            }
            invoice.setOrder(clinicalOrder);
        }
        invoice.setPatientName(patient);
        invoicePort.save(invoice);
    }

}
