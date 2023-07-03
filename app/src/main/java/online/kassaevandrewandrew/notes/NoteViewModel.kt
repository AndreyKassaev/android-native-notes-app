package online.kassaevandrewandrew.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {
    val currentNote: MutableLiveData<Note> by lazy { MutableLiveData<Note>(Note(id = "", text = "", dateCreated = "")) }
    val notifyDataSetChangedFlag: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }
    val saveCurrentNoteFlag: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }
    val newNoteFlag: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }
    val noteDeletedFlag: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }

}