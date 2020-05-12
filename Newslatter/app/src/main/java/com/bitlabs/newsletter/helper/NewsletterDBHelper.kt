package com.bitlabs.newsletter.helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.bitlabs.newsletter.model.Post

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

    fun insertNews(news: Post) {
        val values = ContentValues()
        values.put(COLUMN_TITLE, news.title)
        values.put(COLUMN_BODY, news.detail)
        values.put(COLUMN_DATE, news.date)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()

    }

    fun updateNews(news: Post, id: Int) {
        val values = ContentValues()
        values.put(COLUMN_TITLE, news.title)
        values.put(COLUMN_BODY, news.detail)
        values.put(COLUMN_DATE, news.date)

        val db = this.writableDatabase
        db.update(TABLE_NAME, values, "_id = $id", null)
    }

    fun getAllNews(): ArrayList<Post> {
        val listNews = ArrayList<Post>()
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val news = Post(cursor.getString(1), cursor.getString(2), cursor.getString(3))
                listNews.add(news)
            } while (cursor.moveToNext())
        }
        db.close()
        return listNews
    }
}