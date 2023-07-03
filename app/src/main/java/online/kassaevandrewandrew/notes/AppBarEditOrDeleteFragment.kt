package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import online.kassaevandrewandrew.notes.databinding.AppbarEditOrDeleteFragmentBinding
import online.kassaevandrewandrew.notes.db.NoteDAO

class AppBarEditOrDeleteFragment: Fragment(R.layout.appbar_edit_or_delete_fragment) {
    lateinit var binding: AppbarEditOrDeleteFragmentBinding
    val viewModel: NoteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppbarEditOrDeleteFragmentBinding.inflate(inflater)

        binding.appbarSaveIcon.setOnClickListener {
            viewModel.currentNote.value?.let { it1 -> NoteDAO.instance.update(it1) }
        }
        binding.appbarBackIcon.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace(R.id.appbar_fragment_container, AppBarMainFragment())
                replace(R.id.main_fragment_container, NotesListFragment.instance)
            }
        }
        binding.appbarDeleteIcon.setOnClickListener {
            viewModel.currentNote.value?.let { NoteDAO.instance.delete(it)}
            viewModel.noteDeletedFlag.value = true

            activity?.supportFragmentManager?.commit {
                replace(R.id.appbar_fragment_container, AppBarMainFragment())
                replace(R.id.main_fragment_container, NotesListFragment.instance)
            }
        }

        return binding.root
    }
}