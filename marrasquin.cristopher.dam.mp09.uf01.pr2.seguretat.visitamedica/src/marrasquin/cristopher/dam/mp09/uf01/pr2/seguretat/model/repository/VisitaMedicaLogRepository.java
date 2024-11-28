package marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.repository;

import java.util.ArrayList;

import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

public class VisitaMedicaLogRepository {

    private static ArrayList<VisitaMedicaLog> visites = new ArrayList<VisitaMedicaLog>();

    public void addVisitaMedica(String algoritme, String accio, VisitaMedica visitaMedica) {

        VisitaMedicaLog visitaMedicaLog = new VisitaMedicaLog();
        visitaMedicaLog.setAlgoritme(algoritme);
        visitaMedicaLog.setAccio(accio);
        visitaMedicaLog.setVisitaMedica(visitaMedica);
        visites.add(visitaMedicaLog);

    }

    public ArrayList<VisitaMedicaLog> getVisitesMediquesLog() {
        return visites;
    }
}
