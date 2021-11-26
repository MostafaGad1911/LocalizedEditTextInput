package mostafagad.projects.localizededittext

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mostafa.projects.gadexentions.GadExt.Companion.showToast
import java.util.*
import java.util.regex.Pattern
import kotlin.concurrent.timerTask
import android.R.attr.password
import android.text.*
import android.util.TypedValue
import java.util.regex.Matcher
import kotlin.collections.ArrayList


class AndroidLocalizedEditText(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(
        context,
        attrs
    ) {

    private var userlang: String? = "en"

    init {

        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        try {
            var typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.LocalizedEditStyle,
                0, 0
            )
            userlang = typedArray.getString(R.styleable.LocalizedEditStyle_used_language)

            this.isClickable = true
            this.includeFontPadding = false
            this.isFocusableInTouchMode = true
            if (!this.hasFocus()) {
                this.clearFocus()
            }
            var beforeS = ""
            var afterS = ""
            this.addTextChangedListener(object : TextWatcher {

                @RequiresApi(Build.VERSION_CODES.CUPCAKE)
                override fun afterTextChanged(s: Editable) {

                    afterS = this@AndroidLocalizedEditText.text.toString().trim()
                    if (org.apache.commons.lang3.StringUtils.difference(
                            beforeS.trim(),
                            afterS.trim()
                        ).length > 0
                    ) {
                        if (TextUtils.equals(userlang, "ar") && this@AndroidLocalizedEditText.text.toString().ContainEnglish()) {
                            this@AndroidLocalizedEditText.setText(this@AndroidLocalizedEditText.text.toString().RemoveEnglish())
                            this@AndroidLocalizedEditText.setSelection(this@AndroidLocalizedEditText.length())
                        } else if (TextUtils.equals(userlang, "en") && this@AndroidLocalizedEditText.text.toString().ContainArabic()) {
                            this@AndroidLocalizedEditText.setText(this@AndroidLocalizedEditText.text.toString().RemoveArabic())
                            this@AndroidLocalizedEditText.setSelection(this@AndroidLocalizedEditText.length())
                        }
                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                    beforeS = this@AndroidLocalizedEditText.text.toString().trim()
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                    Log.i("CharInput", "${s.toString()}")


                }
            })
            typedArray.recycle()

        } catch (e: Exception) {
        }
    }


}

private val arFilters: InputFilter = object : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        return if (source != null && source.matches(Regex("^[A-z0-9ًٌٍَُِّ]+\$"))) {
            ""
        } else null
    }
}

private val enFilters: InputFilter = object : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        return if (source != null && source.matches(Regex("[ء-ي]+"))) {
            ""
        } else null
    }
}


fun String.RemoveNumbers():String{
    var re = Regex("[0-9]")
    var testRegx = re.replace(this , "")
    Log.i("TEST_REGX" , testRegx)
    return testRegx
}

fun String.RemoveArabic():String{
    var re = Regex("[ء-ي]+")
    var testRegx = re.replace(this , "")
    Log.i("TEST_REGX" , testRegx)
    return testRegx
}

fun String.RemoveEnglish():String{
    var re = Regex("[a-zA-Z]+")
    var testRegx = re.replace(this , "")
    Log.i("TEST_REGX" , testRegx)
    return testRegx
}

fun String.ContainArabic():Boolean{
    var re = Regex("[ء-ي]+")
    return re.containsMatchIn(this)
}

fun String.ContainEnglish():Boolean{
    var re = Regex("[a-zA-Z]+")
    return re.containsMatchIn(this)
}


@RequiresApi(Build.VERSION_CODES.CUPCAKE)
fun EditText.disableEditText() {
    this.setInputType(InputType.TYPE_NULL)
}

@RequiresApi(Build.VERSION_CODES.CUPCAKE)
fun EditText.enableEditText() {
    this.setInputType(InputType.TYPE_CLASS_TEXT)
}

