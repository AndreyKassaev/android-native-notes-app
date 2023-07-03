package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import online.kassaevandrewandrew.notes.databinding.SingleNoteEditFragmentDatabindingBinding
import online.kassaevandrewandrew.notes.databinding.SingleNoteReadFragmentBinding

class SingleNoteReadFragment: Fragment(R.layout.single_note_read_fragment) {

    private val viewModel: NoteViewModel by activityViewModels()

    lateinit var binding: SingleNoteReadFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SingleNoteReadFragmentBinding.inflate(inflater)

        viewModel.currentNote.observe(viewLifecycleOwner) {
            binding.singleNoteReadTextBody.text = it.text
        }

        return binding.root
    }
}