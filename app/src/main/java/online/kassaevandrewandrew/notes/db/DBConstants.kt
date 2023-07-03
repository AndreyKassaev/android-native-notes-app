package online.kassaevandrewandrew.notes.db

import android.provider.BaseColumns

class DBConstants {
    companion object {
        const val TABLE_NAME = "notes"
        const val COLUMN_NAME_TEXT = "text"
        const val COLUMN_NAME_DATE_CREATED = "date_created"

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "NotesDB.db"

        const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COLUMN_NAME_TEXT TEXT," +
                "$COLUMN_NAME_DATE_CREATED TEXT)"
        const val  SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}