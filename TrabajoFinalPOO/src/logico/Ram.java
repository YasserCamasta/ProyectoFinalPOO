package logico;

class RAM extends Componente {
    private int capacidad;
    private String tipo;

    public RAM(String numeroSerie, double precio, int cantidadDisponible, String marca, int capacidad, String tipo) {
        super(numeroSerie, precio, cantidadDisponible, marca);
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String obtenerDetalles() {
        return "Memoria RAM: " + getMarca() + ", Capacidad: " + capacidad + " GB, Tipo: " + tipo;
    }
}