package marrasquin.cristopher.dam.mp09.uf01.pr2.seguretat.model.domain;

public class VisitaMedicaLog {

    private String algoritme;
    private String accio;
    private VisitaMedica visitaMedica;

    public String getAlgoritme() {
        return algoritme;
    }

    public void setAlgoritme(String algoritme) {
        this.algoritme = algoritme;
    }

    public String getAccio() {
        return accio;
    }

    public void setAccio(String accio) {
        this.accio = accio;
    }

    public VisitaMedica getVisitaMedica() {
        return visitaMedica;
    }

    public void setVisitaMedica(VisitaMedica visitaMedica) {
        this.visitaMedica = visitaMedica;
    }

    @Override
    public String toString() {
        return "VisitaMedicaLog [algoritme=" + algoritme + ", accio=" + accio + ", visitaMedica=" + visitaMedica + "]";
    }

}

