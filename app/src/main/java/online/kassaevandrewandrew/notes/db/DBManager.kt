package online.kassaevandrewandrew.notes.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import online.kassaevandrewandrew.notes.Note

class DBManager(context: Context) {
    val noteDAO = NoteDAO.instance
    companion object {
        fun getSingleton(context: Context): DBManager{
            return DBManager(context)
        }
    }
    val dbHelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    //First open db
    fun openDB(){
        db = dbHelper.writableDatabase
    }


    fun writeNoteToDB(note: Note){
        val dateCreated = java.util.Calendar.getInstance().time.toString()
        val values = ContentValues().apply {
            put(DBConstants.COLUMN_NAME_TEXT, note.text)
            put(DBConstants.COLUMN_NAME_DATE_CREATED, dateCreated)
        }
        db?.insert(DBConstants.TABLE_NAME, null, values)
    }

    fun readDB(): MutableList<Note>{
        val data = mutableListOf<Note>()
        val cursor = db?.query(
            DBConstants.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            "_id DESC"
            )

            while(cursor?.moveToNext()!!){
                val id = cursor.getString(0)
                val text = cursor.getString(1)
                val dateCreated = cursor.getString(2)
                data.add(Note(id=id,text=text,dateCreated=dateCreated))
            //                noteDAO.notesList.add(Note(id =id, text =text, dateCreated =dateCreated))
            }
            cursor.close()
        return data
    }

    fun update(note:Note){
        val cv = ContentValues()
        cv.put(DBConstants.COLUMN_NAME_TEXT, note.text)
        db?.update(DBConstants.TABLE_NAME, cv, "_id = ${note.id}", null )
    }

    fun delete(note: Note){
        val cv = ContentValues()
        cv.put(DBConstants.COLUMN_NAME_TEXT, note.text)
        db?.delete(DBConstants.TABLE_NAME,  "_id = ${note.id}", null )

    }

    fun closeDB(){
        dbHelper.close()
    }
}