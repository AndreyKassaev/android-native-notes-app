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

class SingleNoteEditFragment: Fragment(R.layout.single_note_edit_fragment_databinding) {
    lateinit var binding: SingleNoteEditFragmentDatabindingBinding
    private val viewModel: NoteViewModel by activityViewModels()
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

        if(viewModel.noteDeletedFlag.value == false){
            saveCurrentNote()

        }
        viewModel.noteDeletedFlag.value = false


    }

    private fun saveCurrentNote(){
        viewModel.currentNote.observe(viewLifecycleOwner) {

        viewModel.currentNote.value?.let {
            if(it.text != ""){
                if (viewModel.newNoteFlag.value == true){
                    NoteDAO.instance.writeDB(it)
                }else{
                    NoteDAO.instance.update(it)
                }
                viewModel.currentNote.value = Note(id = "", text = "", dateCreated = "")
                viewModel.newNoteFlag.value = false
            }
        }
        }
    }
}
