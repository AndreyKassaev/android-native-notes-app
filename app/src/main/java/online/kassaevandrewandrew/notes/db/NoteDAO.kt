package online.kassaevandrewandrew.notes.db

import android.widget.Toast
import online.kassaevandrewandrew.notes.MyAppContext
import online.kassaevandrewandrew.notes.Note
import online.kassaevandrewandrew.notes.NotesListFragment
import online.kassaevandrewandrew.notes.R

class NoteDAO {
    var notesList = mutableListOf<Note>()
    lateinit var dbManager: DBManager


    init {
        dbManager = DBManager(MyAppContext.context)
        dbManager.openDB()
        readDB()
    }

    fun readDB(){
        notesList = dbManager.readDB()
    }

    fun update(note: Note){
        dbManager.update(note)
        readDB()
        NotesListFragment.instance.noteRecycleViewAdapter.notifyDataSetChanged()
        Toast.makeText(MyAppContext.context, R.string.toast_saved, Toast.LENGTH_SHORT).show()
    }

    fun writeDB(note: Note){
        dbManager.writeNoteToDB(note)
        readDB()
        NotesListFragment.instance.noteRecycleViewAdapter.notifyDataSetChanged()
        Toast.makeText(MyAppContext.context, R.string.toast_saved, Toast.LENGTH_SHORT).show()
    }

    fun delete(note: Note){
        dbManager.delete(note)
        readDB()
        NotesListFragment.instance.noteRecycleViewAdapter.notifyDataSetChanged()
        Toast.makeText(MyAppContext.context, R.string.toast_deleted, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val instance = NoteDAO()
    }

}