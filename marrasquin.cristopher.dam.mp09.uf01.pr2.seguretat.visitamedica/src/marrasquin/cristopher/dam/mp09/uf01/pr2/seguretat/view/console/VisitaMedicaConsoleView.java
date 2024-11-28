package marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.view.console;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

public class VisitaMedicaConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public VisitaMedica getVisitaMedica() {
        System.out.print("Id Visita Mèdica: ");
        int id = getIntByText(scanner.nextLine());

        System.out.print("Nom metge: ");
        String nomMetge = scanner.nextLine();

        System.out.print("Nom pacient: ");
        String nomPacient = scanner.nextLine();

        System.out.print("Diagnòstic: ");
        String diagnostic = scanner.nextLine();

        System.out.print("Data (YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        VisitaMedica visitaMedica = new VisitaMedica();
        visitaMedica.setIdVisita(id);
        visitaMedica.setNomMetge(nomMetge);
        visitaMedica.setNomPacient(nomPacient);
        visitaMedica.setDiagnostic(diagnostic);
        visitaMedica.setData(data);
        return visitaMedica;
    }

    public void showVisitaMedica(VisitaMedica visitaMedica) {
        System.out.println("Informació de la Visita Mèdica:");
        System.out.println(visitaMedica.toString());
    }

    public void showMissatge(String missatge, boolean esError) {
        if (esError) {
            System.err.println("ERROR: " + missatge);
        } else {
            System.out.println("Xifrat: " + missatge);
        }
    }

    public boolean demanarMesDades() {
        System.out.print("Desitja demanar més dades? (true/false): ");
        String text = scanner.nextLine();
        return text.equalsIgnoreCase("true");
    }

    public void mostraLogs(ArrayList<VisitaMedicaLog> logs) {
        if (logs != null && !logs.isEmpty()) {
            System.out.println("Logs de Visites Mèdiques:");
            for (VisitaMedicaLog log : logs) {
                System.out.println(log.toString());
            }
        } else {
            System.out.println("No hi ha logs disponibles.");
        }
    }

    private int getIntByText(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.err.println("ERROR: El valor introduït no és un número vàlid.");
            return 0;
        }
    }
}

