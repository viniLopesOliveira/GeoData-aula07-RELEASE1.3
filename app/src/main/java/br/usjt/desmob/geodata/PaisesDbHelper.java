package br.usjt.desmob.geodata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asbonato on 16/10/17.
 */

public class PaisesDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Paises.db";
    public static final String SQL_CREATE_PAIS =
            "CREATE TABLE " + PaisesContract.PaisEntry.TABLE_NAME + "(" +
                    PaisesContract.PaisEntry._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisEntry.COLUMN_NAME_NOME + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_REGIAO + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3 + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_DENOMINO + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO + " INTEGER," +
                    PaisesContract.PaisEntry.COLUMN_NAME_AREA + " INTEGER," +
                    PaisesContract.PaisEntry.COLUMN_NAME_GINI + " REAL," +
//                    idiomas
                    PaisesContract.PaisEntry.COLUMN_NAME_NOMEIDIOMA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_NOMENATIVOIDIOMA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_ISO639_1 + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_ISO639_2 + " TEXT," +
                    // moedas
                    PaisesContract.PaisEntry.COLUMN_NAME_CODIGOMOEDA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_NOMEMOEDA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_SIMBOLOMOEDA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_DOMINIOS + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_FUSOS + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_FRONTEIRAS + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE + " REAL," +
                    PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE + " REAL)";



    public static final String SQL_DROP_PAIS =
            "DROP TABLE IF EXISTS " + PaisesContract.PaisEntry.TABLE_NAME;

    public PaisesDbHelper(Context contexto){
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PAIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_PAIS);
        db.execSQL(SQL_CREATE_PAIS);
    }
}
