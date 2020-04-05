package jp.techacademy.masayuki.natsume.calcapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)

        var str1 = edit_1.text.toString()
        var str2 = edit_2.text.toString()
        var id: View? =  v //"@+id/button"のﾎﾞﾀﾝIDにする

        if ((str1 == "") || (str2 == "")) {
            Snackbar.make(v!!, "「何か数値を入力してください。」", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action") {
                    Log.d("UI_PARTS", "「Snakbarがﾀｯﾌﾟされました。」")
                }.show()
        } else {

            var num1 = str1.toDouble()
            var num2 = str2.toDouble()
            var numAll = 0.0

            //どのbuttonをｸﾘｯｸしたかの条件式にする
            if (id == button3){
                numAll = (num1 + num2)
                intent.putExtra("VALUEALL", numAll) //if条件式の結果を変数に代入してputExtra
            } else if (id == button4) {
                numAll = (num1 - num2)
                intent.putExtra("VALUEALL", numAll)
            } else if (id == button5) {
                numAll = (num1 * num2)
                intent.putExtra("VALUEALL", numAll)
            } else if (id == button6) {
                numAll = (num1 / num2)
                intent.putExtra("VALUEALL", numAll)
            }
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
