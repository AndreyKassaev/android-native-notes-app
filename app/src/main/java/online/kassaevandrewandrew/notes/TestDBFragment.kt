package online.kassaevandrewandrew.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import online.kassaevandrewandrew.notes.databinding.TestDbBinding
import online.kassaevandrewandrew.notes.db.DBManager
import online.kassaevandrewandrew.notes.db.NoteDAO

class TestDBFragment: Fragment(R.layout.test_db) {
    lateinit var binding : TestDbBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestDbBinding.inflate(inflater)

        val dbManager = activity?.let { DBManager(it) }
        dbManager?.openDB()
        dbManager?.readDB()
        dbManager?.closeDB()

        val noteList = NoteDAO.instance.notesList
//        binding.testdbButton.setOnClickListener {
//            binding.testdbTextView.text = ""
//            dbManager?.openDB()
//            dbManager?.writeDB(text = binding.testdbEditTextText.text.toString(), date_created = binding.testdbEditTextDate.text.toString())
//            val dataFromDB = dbManager?.readDB()
//            if (dataFromDB != null) {
//                for (i in dataFromDB){
//                    binding.testdbTextView.append(i.toString())
//                    binding.testdbTextView.append("\n")
//                }
//            }
//            dbManager?.closeDB()
//        }
        binding.testdbTextView.text = noteList[0].text



        return binding.root
    }
}