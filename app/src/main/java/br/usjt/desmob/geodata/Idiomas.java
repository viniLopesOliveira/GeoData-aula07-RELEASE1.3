package br.usjt.desmob.geodata;

import java.io.Serializable;

/**
 * Created by Denilson Oliveira 81523503 on 06/11/2017.
 */

public class Idiomas implements Serializable {
    private String iso639_1;
    private String iso639_2;
    private String nome;
    private String nomeNativo;

    public String getIso639_1() {
        return iso639_1;
    }

    public void setIso639_1(String iso639_1) {
        this.iso639_1 = iso639_1;
    }

    public String getIso639_2() {
        return iso639_2;
    }

    public void setIso639_2(String iso639_2) {
        this.iso639_2 = iso639_2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeNativo() {
        return nomeNativo;
    }

    public void setNomeNativo(String nomeNativo) {
        this.nomeNativo = nomeNativo;
    }

    @Override
    public String toString() {
        return "Idiomas{" +
                "iso639_1='" + iso639_1 + '\'' +
                ", iso639_2='" + iso639_2 + '\'' +
                ", nome='" + nome + '\'' +
                ", nomeNativo='" + nomeNativo + '\'' +
                '}';
    }
}
