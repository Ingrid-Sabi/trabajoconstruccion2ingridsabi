package app.domain.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.domain.model.Employee;
import app.domain.model.Invoice;
import app.domain.model.Patient;

import app.domain.ports.EmployeePort;
import app.domain.ports.InvoicePort;
import app.domain.ports.PatientPort;
@Service
public class InvoiceService {
	@Autowired
	private InvoicePort invoicePort;
	@Autowired
	private PatientPort patientPort;
	@Autowired
	private EmployeePort employeePort;
	
    public void createInvoice(Invoice invoice) throws Exception {
        if (invoice == null) throw new Exception("La factura no puede ser nula");

        if (invoice.getPatientDocument() <= 0) 
            throw new Exception("El documento del paciente debe ser un número positivo");

        if (invoice.getPolicyNumber() <= 0) 
            throw new Exception("El número de póliza debe ser un número positivo");

        int age = invoice.getPatientAge();
        if (age < 0 || age > 120) 
            throw new Exception("La edad del paciente debe estar entre 0 y 120");

        if (invoice.getDoctorName() == null) 
            throw new Exception("El doctor no puede ser nulo");
        if (invoice.getDoctorName().getDocument() == 0) 
            throw new Exception("El documento del doctor no puede ser 0");

        if (invoice.getPatientName() == null) 
            throw new Exception("El paciente no puede ser nulo");
        if (invoice.getPatientName().getDocument() == 0) 
            throw new Exception("El documento del paciente no puede ser 0");

        String companyName = invoice.getInsuranceCompanyName();
        if (companyName == null || companyName.trim().isEmpty()) 
            throw new Exception("La compañía de seguros no puede estar vacía");

        Date validity = invoice.getPolicyValidity();
        if (validity == null) 
            throw new Exception("La fecha de validez de la póliza no puede ser nula");

        Date endDate = invoice.getPolicyEndDate();
        if (endDate == null) 
            throw new Exception("La fecha de finalización de la póliza no puede ser nula");

        if (endDate.before(validity)) 
            throw new Exception("La fecha de finalización debe ser posterior a la fecha de validez");

        Patient tempPatient = new Patient();
        tempPatient.setDocument(invoice.getPatientDocument());
        
        Patient patient = patientPort.findByDocument(tempPatient);

        if (patient == null)
            throw new Exception("El paciente no existe");
        
        
        Employee doctor = employeePort.findByDocument(invoice.getDoctorName());
        if (doctor == null)
            throw new Exception("El doc no existe");
        invoice.setDoctorName(doctor);
        invoice.setPatientName(patient);

        invoicePort.save(invoice);
    }

}
