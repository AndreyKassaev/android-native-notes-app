package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import online.kassaevandrewandrew.notes.databinding.AppbarMainFragmentBinding
import online.kassaevandrewandrew.notes.db.NoteDAO

class AppBarMainFragment: Fragment(R.layout.appbar_main_fragment) {
    lateinit var binding: AppbarMainFragmentBinding
    val noteDAO = NoteDAO.instance
    val viewModel: NoteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppbarMainFragmentBinding.inflate(inflater)

        binding.appbarAddNoteIcon.setOnClickListener {
            viewModel.newNoteFlag.value = true
            viewModel.currentNote.value = Note(id="", text = "", dateCreated = "")
            activity?.supportFragmentManager?.commit {
                replace(R.id.appbar_fragment_container, AppBarEditFragment())
                replace(R.id.main_fragment_container, SingleNoteEditFragment())
                addToBackStack(null)
            }
        }

        return binding.root
    }
}