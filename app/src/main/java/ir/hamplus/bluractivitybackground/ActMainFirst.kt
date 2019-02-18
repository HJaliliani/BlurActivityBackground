package ir.hamplus.bluractivitybackground

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarek360.instacapture.Instacapture
import com.tarek360.instacapture.listener.SimpleScreenCapturingListener
import kotlinx.android.synthetic.main.ly_act_first.*
import java.io.ByteArrayOutputStream

class ActMainFirst : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ly_act_first)

        button_next.setOnClickListener {
            screenshotAndSendToAnotherActivity()
        }
    }

    fun screenshotAndSendToAnotherActivity(){
        Instacapture.capture(this, object : SimpleScreenCapturingListener() {
            override fun onCaptureComplete(bitmap: Bitmap) {
                val i = Intent(this@ActMainFirst, ActSecondBlur::class.java)

                val bStream  =  ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, bStream)
                val byteArray = bStream.toByteArray()
                i.putExtra("image", byteArray )
                startActivity(i)
            }
        })
    }
}
