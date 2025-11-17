package app.domain.ports;


import app.domain.model.Procedure;


public interface ProcedurePort {
	
	public Procedure findByOrderNumber(Procedure procedure) throws Exception;
	public void save(Procedure procedure) throws Exception;
	
}