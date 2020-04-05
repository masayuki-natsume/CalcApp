package jp.techacademy.masayuki.natsume.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Mainから1つのｷｰで値を受け取る
        val valueAll = intent.getDoubleExtra("VALUEALL", 0.0)
            textView.text = "${valueAll}"
    }
}
