package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import online.kassaevandrewandrew.notes.databinding.NotesListFragmentBinding

class NotesListFragment : Fragment(R.layout.notes_list_fragment), NoteRecycleViewAdapter.Listener {

    lateinit var binding: NotesListFragmentBinding
    private val viewModel: NoteViewModel by activityViewModels()
    lateinit var noteRecycleViewAdapter: NoteRecycleViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NotesListFragmentBinding.inflate(inflater, container, false)

        noteRecycleViewAdapter = NoteRecycleViewAdapter(this)
//        val noteRecycleViewAdapter = NoteRecycleViewAdapter(this)

        binding.notesListRecycleView.adapter = noteRecycleViewAdapter
        binding.notesListRecycleView.layoutManager = LinearLayoutManager(activity)



        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.notifyDataSetChangedFlag.observe(viewLifecycleOwner) {
            if (it) {
                noteRecycleViewAdapter.notifyDataSetChanged()
                setNotifyDataSetChangedFlagToFalse()
            }
        }
    }


    fun setNotifyDataSetChangedFlagToFalse(){
        viewModel.notifyDataSetChangedFlag.value = false
    }


    override fun onClick(note: Note) {
        viewModel.currentNote.value = note
        activity?.supportFragmentManager?.commit {
            replace(R.id.appbar_fragment_container, AppBarEditOrDeleteFragment())
            replace(R.id.main_fragment_container, SingleNoteEditFragment())
            addToBackStack(null)
        }
    }

    companion object {
        val instance = NotesListFragment()
    }
}