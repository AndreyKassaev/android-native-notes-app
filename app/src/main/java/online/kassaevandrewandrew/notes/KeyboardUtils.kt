package online.kassaevandrewandrew.notes

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT
import android.widget.EditText

class KeyboardUtils {
    fun showKeyboard(editText: EditText) {
        editText.requestFocus()
        (editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(editText, SHOW_IMPLICIT)
        //imm.toggleSoftInput(InputMethodManager.SHOW_FORCED)
//        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
//        imm.showSoftInput(editText, 0)
    }

    fun hideKeyboard(editText: EditText) {
        val imm = editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }
    companion object {
        val instance = KeyboardUtils()
    }
}