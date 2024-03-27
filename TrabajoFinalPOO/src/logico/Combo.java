package logico;

import java.util.ArrayList;

public class Combo {
    private int idCombo;
    private ArrayList<Componente> componentes;

    public Combo(int idCombo) {
        this.idCombo = idCombo;
        componentes = new ArrayList<>();
    }
    public int getIdCombo() {
        return idCombo;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
}