package br.usjt.desmob.geodata;

import android.provider.BaseColumns;

/**
 * Created by asbonato on 16/10/17.
 */

public class PaisesContract {

    public static abstract class PaisEntry implements BaseColumns{
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_REGIAO = "regiao";
        public static final String COLUMN_NAME_CAPITAL = "capital";
        public static final String COLUMN_NAME_BANDEIRA = "bandeira";
        public static final String COLUMN_NAME_CODIGO3 = "codigo3";
        public static final String COLUMN_NAME_SUBREGIAO = "subRegiao";
        public static final String COLUMN_NAME_DENOMINO = "demonimo";
        public static final String COLUMN_NAME_POPULACAO = "populacao";
        public static final String COLUMN_NAME_AREA = "area";
        public static final String COLUMN_NAME_GINI = "gini";
        public static final String COLUMN_NAME_IDIOMAS = "idiomas";
        public static final String COLUMN_NAME_DOMINIOS = "dominios";
        public static final String COLUMN_NAME_FUSOS = "fusos";
        public static final String COLUMN_NAME_FRONTEIRAS = "fronteiras";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";

        // moedas
        public static final String COLUMN_NAME_CODIGOMOEDA = "codigo" ;
        public static final String COLUMN_NAME_NOMEMOEDA = "nomeMoeda" ;
        public static final String COLUMN_NAME_SIMBOLOMOEDA = "simboloMoeda" ;

        //idiomas
        public static final String COLUMN_NAME_NOMEIDIOMA = "nomeIdioma" ;
        public static final String COLUMN_NAME_NOMENATIVOIDIOMA = "nomeNativoIdioma" ;
        public static final String COLUMN_NAME_ISO639_1 = "iso639_1" ;
        public static final String COLUMN_NAME_ISO639_2 = "iso639_2" ;




    }
}
