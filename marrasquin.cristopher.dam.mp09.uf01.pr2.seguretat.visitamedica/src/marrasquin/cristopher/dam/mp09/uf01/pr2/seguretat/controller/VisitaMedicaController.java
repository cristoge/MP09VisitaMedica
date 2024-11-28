package marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.controller;

import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.service.VisitaMedicaService;
import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.view.console.VisitaMedicaConsoleView;

public class VisitaMedicaController {
    VisitaMedicaConsoleView visitaMedicaView = new VisitaMedicaConsoleView();
    VisitaMedicaService visitaMedicaService = new VisitaMedicaService();

    public void inici() {
        do {
            aplicaSeguretatMD5();
            aplicaSeguretatSHA256();
            aplicaSeguretatAES();
            visitaMedicaView.mostraLogs(visitaMedicaService.getLogs());

        } while (visitaMedicaView.demanarMesDades());
    }


    private void aplicaSeguretatMD5() {

        try {
            visitaMedicaView.showMissatge("MD5 ------------", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
            VisitaMedica visitaMedicaEnc = visitaMedicaService.getVisitaMedicaEncriptatMD5(visitaMedica);
            visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
        } catch (Exception ex) {
            visitaMedicaView.showMissatge("MD5 - " + ex.getMessage(), true);
        }
    }

    private void aplicaSeguretatSHA256() {

        try {
            visitaMedicaView.showMissatge("SHA256 ------------", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
            VisitaMedica visitaMedicaEnc = visitaMedicaService.getVisitaMedicaEncriptatSHA256(visitaMedica);
            visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
        } catch (Exception ex) {
            visitaMedicaView.showMissatge("SHA256 - " + ex.getMessage(), true);
        }
    }

    private void aplicaSeguretatAES() {
        try {
            visitaMedicaView.showMissatge("AES ------------ Encripta", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
            VisitaMedica visitaMedicaEnc = visitaMedicaService.getVisitaMedicaEncriptatAES(visitaMedica);
            visitaMedicaView.showVisitaMedica(visitaMedicaEnc);

            visitaMedicaView.showMissatge("AES ------------ Desencripta", false);
            VisitaMedica visitaMedicaDesenc = visitaMedicaService.getVisitaMedicaDesencriptatAES(visitaMedicaEnc);
            visitaMedicaView.showVisitaMedica(visitaMedicaDesenc);
        } catch (Exception ex) {
            visitaMedicaView.showMissatge("AES - " + ex.getMessage(), true);
        }
    }
}