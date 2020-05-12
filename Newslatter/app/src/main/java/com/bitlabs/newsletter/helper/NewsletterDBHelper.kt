package com.bitlabs.newsletter.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NewsletterDBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "newsletter.db"
        const val TABLE_NAME = "news"
        const val COLUMN_ID = "_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_BODY = "body"
        const val COLUMN_IMAGE = "image"
        const val COLUMN_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_NEWS_TABLE = ("CREATE TABLE $TABLE_NAME(" +
                " $COLUMN_ID INTEGER PRIMARY KEY," +
                " $COLUMN_TITLE TEXT NOT NULL," +
                " $COLUMN_BODY TEXT NOT NULL," +
                " $COLUMN_DATE TEXT NOT NULL)")

        db?.execSQL(CREATE_NEWS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTs $TABLE_NAME")
        onCreate(db)
    }
}