package online.kassaevandrewandrew.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import online.kassaevandrewandrew.notes.databinding.MainActivityBinding
import online.kassaevandrewandrew.notes.db.DBManager

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater).also { setContentView(it.root) }
        MyAppContext.setMyContext(this)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        supportFragmentManager.commit{
            add(R.id.appbar_fragment_container, AppBarMainFragment())
            add(R.id.main_fragment_container, NotesListFragment.instance)
        }
    }

}