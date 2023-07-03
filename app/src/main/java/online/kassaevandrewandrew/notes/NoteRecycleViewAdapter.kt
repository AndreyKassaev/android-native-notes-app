package online.kassaevandrewandrew.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import online.kassaevandrewandrew.notes.databinding.SingleListedNoteFragmentBinding
import online.kassaevandrewandrew.notes.db.NoteDAO

class NoteRecycleViewAdapter(val listener: Listener) : RecyclerView.Adapter<NoteRecycleViewAdapter.NoteHolder>() {

    val notesList = NoteDAO.instance.notesList

    interface Listener{
        fun onClick(note: Note)
    }

    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = SingleListedNoteFragmentBinding.bind(itemView)
        fun bind(note: Note, listener: Listener) = with(binding){
            singleListedNoteHeader.text = note.text.split(" ")[0]
            singleListedNoteTextBody.text = note.text
            singleListedNoteDateCreated.text = note.dateCreated

            itemView.setOnClickListener{
                listener.onClick(note)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRecycleViewAdapter.NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_listed_note_fragment, parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount() = notesList.size

    override fun onBindViewHolder(holder: NoteRecycleViewAdapter.NoteHolder, position: Int) {
        val note: Note = notesList[position]
        holder.bind(note, listener)
    }



}