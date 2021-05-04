package com.example.listview_manipulation_donnes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="centerManger";
    private static final String TABLE_NAME="centre";
    private static final String kEY_ID="_ID";
    private static final String kEY_NOM="Nom";
    private static final String kEY_VILLE="ville";
    private static final String kEY_LAT="latitude";
    private static final String kEY_LONG="longitude";


    public Helper(@Nullable Context context)
    {
        super (context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("+kEY_ID+"INTEGER PRIMARY KEY,"+kEY_NOM+"TEXT,"+kEY_VILLE+"TEXT,"+kEY_LAT+"TEXT,"+kEY_LONG+"TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void addCentre(Centre centre)
    {
     SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(kEY_NOM,centre.getNom());
        cv.put(kEY_VILLE,centre.getNom());
        cv.put(kEY_LAT,centre.getNom());
        cv.put(kEY_LONG,centre.getNom());
        db.insert(TABLE_NAME,null,cv);
        db.close();
    }
    public Cursor fetchAllCenter(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{kEY_ID,kEY_NOM,kEY_VILLE,kEY_LAT,kEY_LONG},null,null ,null,null,null);
    return  cursor;
    }
    public void deleteCenter(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,kEY_ID+"=?",new String[]{String.valueOf(id)});
    }
    public  void updateCenter(int id ,Centre centre){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(kEY_NOM,centre.getNom());
        cv.put(kEY_VILLE,centre.getVille());
        cv.put(kEY_LAT,centre.getLatitude());
        cv.put(kEY_LONG,centre.getLongitude());
        db.update(TABLE_NAME,cv,kEY_ID+"=?",new String[]{String.valueOf(id)});
    }
    public Centre getCentre(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{kEY_ID,kEY_NOM,kEY_VILLE,kEY_LAT,kEY_LONG},kEY_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);
if (cursor != null)
    cursor.moveToFirst();
Centre centre=new Centre(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));

return  centre;

    }
}
