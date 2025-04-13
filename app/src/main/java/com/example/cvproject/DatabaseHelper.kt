package com.example.cvproject


import CV
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "cv_database"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "cv_table"

        private const val COLUMN_ID = "id"
        private const val COLUMN_FIRST_NAME = "first_name"
        private const val COLUMN_LAST_NAME = "last_name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PHONE = "phone"
        private const val COLUMN_BIRTH_DATE = "birth_date"
        private const val COLUMN_UNIVERSITY = "university"
        private const val COLUMN_LINKEDIN = "linkedin"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_FIRST_NAME TEXT,
                $COLUMN_LAST_NAME TEXT,
                $COLUMN_EMAIL TEXT,
                $COLUMN_PHONE TEXT,
                $COLUMN_BIRTH_DATE TEXT,
                $COLUMN_UNIVERSITY TEXT,
                $COLUMN_LINKEDIN TEXT
            )
        """.trimIndent()

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addCV(
        cv :CV

    ): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FIRST_NAME, cv.firstName)
            put(COLUMN_LAST_NAME, cv.lastName)
            put(COLUMN_EMAIL, cv.email)
            put(COLUMN_PHONE, cv.phoneNumber)
            put(COLUMN_BIRTH_DATE, cv.birthDate)
            put(COLUMN_UNIVERSITY, cv.uniName)
            put(COLUMN_LINKEDIN, cv.linkedIn)
        }
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result != -1L
    }

    fun getAllCV(): List<CV> {
        val list = mutableListOf<CV>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val cv = CV(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    firstName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRST_NAME)),
                    lastName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LAST_NAME)),
                    email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                    phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE)),
                    birthDate = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTH_DATE)),
                    uniName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_UNIVERSITY)),
                    linkedIn = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LINKEDIN))
                )
                list.add(cv)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return list
    }

    fun deleteCV(id: Int): Boolean {
        val db = writableDatabase
        val result = db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
        return result > 0
    }
}