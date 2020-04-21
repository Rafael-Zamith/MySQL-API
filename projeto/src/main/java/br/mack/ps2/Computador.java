package br.mack.ps2;


public class Computador {
    private int id;
    private String marca;
    private int processador;
    private int RAM;
    private int DiskSize;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String nome) {
        this.marca = marca;
    }

    public int getProcessador() {
        return this.processador;
    }

    public void setProcessador(int processador) {
        this.processador = processador;
    }

    public int getRAM() {
        return this.RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getDiskSize() {
        return this.DiskSize;
    }

    public void setDiskSize(int DiskSIze) {
        this.DiskSize = DiskSize;
    }



    public String toString() {
        return "{" +
            " ID: '" + getId() + "'" +
            ", Marca: '" + getMarca() + "'" +
            ", Processador: '" + getProcessador() + "'" +
            ", RAM: '" + getRAM() + "'" +
            ", Tamanho do disco: '" + getDiskSize() + "'" +
            "}";
    }

}