package logico;

public class Ram extends Componente {
    private int capacidadGB;
    private String tipo;

    public Ram(String numeroSerie, String marca, int capacidadGB, String tipo) {
        super(numeroSerie, marca); 
        this.capacidadGB = capacidadGB;
        this.tipo = tipo;
        this.precio = 2000.0;
    }

    public int getCapacidadGB() {
        return capacidadGB;
    }

    public void setCapacidadGB(int capacidadGB) {
        this.capacidadGB = capacidadGB;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String obtenerDetalles() {
        return "Memoria RAM: " + getMarca() + ", Capacidad: " + capacidadGB + " GB, Tipo: " + tipo;
    }

}
