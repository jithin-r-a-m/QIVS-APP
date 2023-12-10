package com.example.click
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        // Create a table to store cell data
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS cell_data (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "cell_id INTEGER," +
                    "bdy TEXT," +
                    "suff TEXT," +
                    "mod TEXT," +
                    "selected_option TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades here
    }

    fun insertCellData(cellData: MainActivity.CellData): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("cell_id", cellData.cellId)
            put("bdy", cellData.bdy)
            put("suff", cellData.suff)
            put("mod", cellData.mod)
            put("selected_option", cellData.selectedOption)
        }
        return db.insert("cell_data", null, values)
    }

    @SuppressLint("Range")
    fun getAllCellData(): List<MainActivity.CellData> {
        val cellDataList = mutableListOf<MainActivity.CellData>()
        val db = readableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery("SELECT * FROM cell_data", null)
        } catch (e: SQLException) {
            db.execSQL("CREATE TABLE cell_data (_id INTEGER PRIMARY KEY AUTOINCREMENT, cell_id INTEGER, bdy TEXT, suff TEXT, mod TEXT, selected_option TEXT)")
            return emptyList()
        }

        cursor.use {
            while (it.moveToNext()) {
                val cellId = it.getInt(it.getColumnIndex("cell_id"))
                val bdy = it.getString(it.getColumnIndex("bdy"))
                val suff = it.getString(it.getColumnIndex("suff"))
                val mod = it.getString(it.getColumnIndex("mod"))
                val selectedOption = it.getString(it.getColumnIndex("selected_option"))
                val cellData = MainActivity.CellData(cellId, bdy, suff, mod, selectedOption)
                cellDataList.add(cellData)
            }
        }
        return cellDataList
    }

    companion object {
        private const val DATABASE_NAME = "tiry.db"
        private const val DATABASE_VERSION = 3
    }
}
