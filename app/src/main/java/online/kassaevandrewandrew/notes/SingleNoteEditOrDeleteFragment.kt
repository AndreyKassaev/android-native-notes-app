package online.kassaevandrewandrew.notes
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import online.kassaevandrewandrew.notes.databinding.SingleNoteEditFragmentDatabindingBinding
import online.kassaevandrewandrew.notes.db.NoteDAO

class SingleNoteEditOrDeleteFragment: Fragment(R.layout.single_note_edit_or_delete_fragment) {
    lateinit var binding: SingleNoteEditFragmentDatabindingBinding
    private val viewModel: NoteViewModel by activityViewModels()
    private val noteDAO = NoteDAO.instance
    val keyboardUtils = KeyboardUtils()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.single_note_edit_fragment_databinding, container, false
        )
        //Show soft-keyboard
        binding.singleNoteEditTextBody.postDelayed(Runnable { keyboardUtils.showKeyboard(binding.singleNoteEditTextBody) }, 100)
        viewModel.saveCurrentNoteFlag.observe(viewLifecycleOwner) {
//            saveCurrentNote()
            keyboardUtils.hideKeyboard(binding.singleNoteEditTextBody)
        }


//        System.currentTimeMillis()

        binding.layoutViewModel = viewModel

        return binding.root
    }


    override fun onPause() {
        super.onPause()
//        saveCurrentNote()
    }

//    private fun saveCurrentNote(){
//        viewModel.currentNote.value?.let {
//            if (it.text != ""){
//                noteDAO.writeDB(viewModel.currentNote.value!!)
////                viewModel.notifyDataSetChangedFlag.value = true
//                viewModel.currentNote.value = Note(id="",text="", dateCreated = "")
//                Toast.makeText(activity,"Saved",Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}