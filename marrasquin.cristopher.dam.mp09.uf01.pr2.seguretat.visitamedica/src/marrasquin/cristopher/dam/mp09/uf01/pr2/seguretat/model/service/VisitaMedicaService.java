package marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.service;

import java.util.ArrayList;

import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;
import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.repository.VisitaMedicaLogRepository;



public class VisitaMedicaService {

	VisitaMedicaLogRepository visitaMedicaLogRepository = null;

	public VisitaMedicaService() {
		visitaMedicaLogRepository = new VisitaMedicaLogRepository();
	}

	public VisitaMedica getVisitaMedicaEncriptatMD5(VisitaMedica visitaMedica) {
		this.validaVisitaMedica(visitaMedica);
		visitaMedicaLogRepository.addVisitaMedica("MD5", "Original", visitaMedica);

		MD5SecurityService Security = new MD5SecurityService();
		String nomPacientEnc = Security.encripta(visitaMedica.getNomPacient());
		String diagnosticEnc = Security.encripta(visitaMedica.getDiagnostic());

		VisitaMedica visitaMedicaEnc = new VisitaMedica();
		visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
		visitaMedicaEnc.setData(visitaMedica.getData());
		visitaMedicaEnc.setNomMetge(visitaMedica.getNomMetge());
		visitaMedicaEnc.setNomPacient(nomPacientEnc);
		visitaMedicaEnc.setDiagnostic(diagnosticEnc);

		visitaMedicaLogRepository.addVisitaMedica("MD5", "Encriptat", visitaMedicaEnc);
		return visitaMedicaEnc;
	}
	
	public VisitaMedica getVisitaMedicaEncriptatSHA256(VisitaMedica visitaMedica) {
		this.validaVisitaMedica(visitaMedica);
		visitaMedicaLogRepository.addVisitaMedica("SHA256", "Original", visitaMedica);

		SHA256SecurityService Security = new SHA256SecurityService();
		String nomPacientEnc = Security.encripta(visitaMedica.getNomPacient());
		String diagnosticEnc = Security.encripta(visitaMedica.getDiagnostic());

		VisitaMedica visitaMedicaEnc = new VisitaMedica();
		visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
		visitaMedicaEnc.setData(visitaMedica.getData());
		visitaMedicaEnc.setNomMetge(visitaMedica.getNomMetge());
		visitaMedicaEnc.setNomPacient(nomPacientEnc);
		visitaMedicaEnc.setDiagnostic(diagnosticEnc);

		visitaMedicaLogRepository.addVisitaMedica("SHA256", "Encriptat", visitaMedicaEnc);
		return visitaMedicaEnc;
	}
	
	public VisitaMedica getVisitaMedicaEncriptatAES(VisitaMedica visitaMedica) {
		this.validaVisitaMedica(visitaMedica);
		visitaMedicaLogRepository.addVisitaMedica("AES", "Original", visitaMedica);

		AESSecurityService Security = new AESSecurityService();
		String nomPacientEnc = Security.encripta(visitaMedica.getNomPacient());
		String diagnosticEnc = Security.encripta(visitaMedica.getDiagnostic());

		VisitaMedica visitaMedicaEnc = new VisitaMedica();
		visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
		visitaMedicaEnc.setData(visitaMedica.getData());
		visitaMedicaEnc.setNomMetge(visitaMedica.getNomMetge());
		visitaMedicaEnc.setNomPacient(nomPacientEnc);
		visitaMedicaEnc.setDiagnostic(diagnosticEnc);

		visitaMedicaLogRepository.addVisitaMedica("AES", "Encriptat", visitaMedicaEnc);
		return visitaMedicaEnc;
	}
	
	public VisitaMedica getVisitaMedicaDesencriptatAES(VisitaMedica visitaMedicaEnc)
	{
		AESSecurityService Security = new AESSecurityService();
		String nomPacientDesenc = Security.desencripta(visitaMedicaEnc.getNomPacient());
		String diagnosticDesenc = Security.desencripta(visitaMedicaEnc.getDiagnostic());

		
		VisitaMedica visitaMedicaDesenc = new VisitaMedica();
		visitaMedicaDesenc.setIdVisita(visitaMedicaEnc.getIdVisita());
		visitaMedicaDesenc.setData(visitaMedicaEnc.getData());
		visitaMedicaDesenc.setNomMetge(visitaMedicaEnc.getNomMetge());
		visitaMedicaDesenc.setNomPacient(nomPacientDesenc);
		visitaMedicaDesenc.setDiagnostic(diagnosticDesenc);
		
		visitaMedicaLogRepository.addVisitaMedica("AES", "Desencriptat", visitaMedicaDesenc);
		return visitaMedicaDesenc;
	}

	public ArrayList<VisitaMedicaLog> getLogs() {
		return visitaMedicaLogRepository.getVisitesMediquesLog();
	}

	private void validaVisitaMedica(VisitaMedica visitaMedica) {
		if (visitaMedica == null)
			throw new RuntimeException("Visita mèdica ha d'estar informada");

		if (visitaMedica.getIdVisita() < 1)
			throw new RuntimeException("Id visita ha d'estar informat");

		if (visitaMedica.getNomMetge() == null || visitaMedica.getNomMetge() == "")
			throw new RuntimeException("El nom del metge ha d'estar informat");

		if (visitaMedica.getNomPacient() == null || visitaMedica.getNomPacient() == "")
			throw new RuntimeException("El nom del pacient ha d'estar informat");

		if (visitaMedica.getDiagnostic() == null || visitaMedica.getDiagnostic() == "")
			throw new RuntimeException("El diagnòstic ha d'estar informat");

	}

}
