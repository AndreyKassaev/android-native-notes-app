package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import online.kassaevandrewandrew.notes.databinding.AppbarEditFragmentBinding
import online.kassaevandrewandrew.notes.db.NoteDAO

class AppBarEditFragment: Fragment(R.layout.appbar_edit_fragment) {

    lateinit var binding: AppbarEditFragmentBinding
    val viewModel: NoteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppbarEditFragmentBinding.inflate(inflater)


        binding.appbarSaveNoteIcon.setOnClickListener {
            viewModel.currentNote.observe(viewLifecycleOwner){
                viewModel.currentNote.value?.let {  NoteDAO.instance.writeDB(it) }
            }
        }

        binding.appbarBackIcon.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace(R.id.appbar_fragment_container, AppBarMainFragment())
                replace(R.id.main_fragment_container, NotesListFragment.instance)
            }
        }

        return binding.root
    }



}