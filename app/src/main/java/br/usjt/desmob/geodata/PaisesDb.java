package br.usjt.desmob.geodata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by asbonato on 16/10/17.
 */

public class PaisesDb {
    PaisesDbHelper dbHelper;

    public PaisesDb(Context contexto){
        dbHelper = new PaisesDbHelper(contexto);
    }

    public void inserePaises(String continente,Pais[] paises){

        Log.i("continente",continente);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if(true){
            Pais[] lista = selecionaPaises();

        }

        if(continente == "all") {
            db.delete(PaisesContract.PaisEntry.TABLE_NAME, null, null);
        } else {
            continente = continente.replace("region/","");
            String where = PaisesContract.PaisEntry.COLUMN_NAME_REGIAO + " = ?";
            String[] conditions = {continente};
            db.delete(PaisesContract.PaisEntry.TABLE_NAME, where, conditions);
        }


        Moedas moeda;
        Idiomas idioma;


        for(Pais pais:paises){
            ContentValues values = new ContentValues();
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_NOME, pais.getNome());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_REGIAO, pais.getRegiao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL, pais.getCapital());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA, pais.getBandeira());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3, pais.getCodigo3());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO, pais.getSubRegiao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_DENOMINO, pais.getDemonimo());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO, pais.getPopulacao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_AREA, pais.getArea());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_GINI, pais.getGini());
            for(int i = 0; i< pais.getMoedas().size();i++){
                moeda = pais.getMoedas().get(i);
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_CODIGOMOEDA,moeda.getCodigo());
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_NOMEMOEDA,moeda.getNome());
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_SIMBOLOMOEDA,moeda.getSimbolo());
            }
            for(int i = 0; i< pais.getIdiomas().size();i++){
                idioma = pais.getIdiomas().get(i);
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_NOMEIDIOMA,idioma.getNome());
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_NOMENATIVOIDIOMA,idioma.getNomeNativo());
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_ISO639_1,idioma.getIso639_1());
                values.put(PaisesContract.PaisEntry.COLUMN_NAME_ISO639_2,idioma.getIso639_2());

            }
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_FUSOS, String.valueOf(pais.getDominios()));
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_FUSOS, String.valueOf(pais.getFusos()));
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_FUSOS, String.valueOf(pais.getFronteiras()));
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE, pais.getLatitude());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE, pais.getLongitude());



            db.insert(PaisesContract.PaisEntry.TABLE_NAME, null, values);
        }
    }

    public Pais[] selecionaPaises(){
        ArrayList<Pais> paises = new ArrayList<>();
        ArrayList<Moedas> moedas;
        ArrayList<Idiomas> idiomas;

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {
                PaisesContract.PaisEntry.COLUMN_NAME_NOME,
                PaisesContract.PaisEntry.COLUMN_NAME_REGIAO,
                PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL,
                PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA,
                PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3,
                PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO,
                PaisesContract.PaisEntry.COLUMN_NAME_DENOMINO,
                PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO,
                PaisesContract.PaisEntry.COLUMN_NAME_AREA,
                PaisesContract.PaisEntry.COLUMN_NAME_GINI,



                PaisesContract.PaisEntry.COLUMN_NAME_CODIGOMOEDA,
                PaisesContract.PaisEntry.COLUMN_NAME_NOMEMOEDA,
                PaisesContract.PaisEntry.COLUMN_NAME_SIMBOLOMOEDA,




                PaisesContract.PaisEntry.COLUMN_NAME_NOMEIDIOMA,
                PaisesContract.PaisEntry.COLUMN_NAME_NOMENATIVOIDIOMA,
                PaisesContract.PaisEntry.COLUMN_NAME_ISO639_1,
                PaisesContract.PaisEntry.COLUMN_NAME_ISO639_2,

                PaisesContract.PaisEntry.COLUMN_NAME_FUSOS,
                PaisesContract.PaisEntry.COLUMN_NAME_FUSOS,
                PaisesContract.PaisEntry.COLUMN_NAME_FUSOS,
                PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE,
                PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE

        };
        String ordem = PaisesContract.PaisEntry.COLUMN_NAME_NOME;

        Cursor c = db.query(PaisesContract.PaisEntry.TABLE_NAME, colunas, null, null,
                ordem, null, null);
        while(c.moveToNext()) {
            Pais pais = new Pais();
            Moedas moeda = new Moedas();
            Idiomas idioma = new Idiomas();
            moedas = new ArrayList<>();
            idiomas = new ArrayList<>();

            pais.setNome(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_NOME)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_REGIAO)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL)));
            pais.setBandeira(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3)));
            pais.setSubRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO)));
            pais.setDemonimo(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_DENOMINO)));
            pais.setPopulacao(c.getInt(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO)));
            pais.setArea(c.getInt(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_AREA)));
            pais.setGini(c.getDouble(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_GINI)));
            pais.setLatitude(c.getDouble(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE)));
            pais.setLongitude(c.getDouble(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE)));

            moeda.setCodigo(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CODIGOMOEDA)));
            moeda.setNome(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_NOMEMOEDA)));
            moeda.setSimbolo(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_SIMBOLOMOEDA)));

            idioma.setNome(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_NOMEIDIOMA)));
            idioma.setNomeNativo(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_NOMENATIVOIDIOMA)));
            idioma.setIso639_1(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_ISO639_1)));
            idioma.setIso639_2(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_ISO639_2)));

            moedas.add(moeda);
            idiomas.add(idioma);

            pais.setMoedas(moedas);
            pais.setIdiomas(idiomas);

            paises.add(pais);

        }
        c.close();
        return paises.toArray(new Pais[0]);
    }
}
