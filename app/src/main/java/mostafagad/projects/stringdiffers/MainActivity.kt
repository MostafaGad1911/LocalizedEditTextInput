package mostafagad.projects.stringdiffers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mostafagad.projects.localizededittext.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var testNumRegex = "تيسشيشسي545454"
        Log.i("TEST_NUM_REG" , testNumRegex.RemoveNumbers())
        Log.i("TEST_AR_REG" , testNumRegex.RemoveArabic())
        Log.i("TEST_EN_REG" , testNumRegex.RemoveEnglish())

        Log.i("TEST_AR_CONTAIN_REG" , testNumRegex.ContainArabic().toString())
        Log.i("TEST_EN_CONTAIN_REG" , testNumRegex.ContainEnglish().toString())

    }
}