package br.usjt.desmob.geodata;

import java.io.Serializable;

/**
 * Created by Denilson Oliveira 81523503 on 06/11/2017.
 */

public class Moedas implements Serializable {
    private String codigo;
    private String nome;
    private String simbolo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Moedas{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", simbolo='" + simbolo + '\'' +
                '}';
    }
}
