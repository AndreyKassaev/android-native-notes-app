package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import online.kassaevandrewandrew.notes.databinding.SingleListedNoteFragmentBinding

class SingleListedNoteFragment : Fragment (R.layout.single_listed_note_fragment) {

    lateinit var binding: SingleListedNoteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SingleListedNoteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}