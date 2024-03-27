package logico;

import java.util.ArrayList;

class Motherboard extends Componente {
    private String marca;
    private String modelo;
    private String tipoSocket;
    private String tipoMemoria;
    private ArrayList<String> conexionesHDD;
    
    public Motherboard(String numeroSerie, double precio, int cantidadDisponible, String marca, String modelo,
                       String tipoSocket, String tipoMemoria, ArrayList<String> conexionesHDD) {
        super(numeroSerie, precio, cantidadDisponible);
        this.marca = marca;
        this.modelo = modelo;
        this.tipoSocket = tipoSocket;
        this.tipoMemoria = tipoMemoria;
        this.conexionesHDD = conexionesHDD;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoSocket() {
        return tipoSocket;
        }
        		 public void setTipoSocket(String tipoSocket) {
            this.tipoSocket = tipoSocket;
        }

        public String getTipoMemoria() {
            return tipoMemoria;
        }

        public void setTipoMemoria(String tipoMemoria) {
            this.tipoMemoria = tipoMemoria;
        }

        public ArrayList<String> getConexionesHDD() {
            return conexionesHDD;
        }

        public void setConexionesHDD(ArrayList<String> conexionesHDD) {
            this.conexionesHDD = conexionesHDD;
        }
        public String obtenerDetalles() {
            return "Tarjeta Madre: " + marca + " " + modelo + ", Socket: " + tipoSocket +
                    ", Tipo de Memoria: " + tipoMemoria + ", Conexiones HDD: " + conexionesHDD.toString();
        }
    }