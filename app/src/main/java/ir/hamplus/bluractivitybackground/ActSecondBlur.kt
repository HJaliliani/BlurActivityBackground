package ir.hamplus.bluractivitybackground

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.mirrajabi.viewfilter.core.ViewFilter
import ir.mirrajabi.viewfilter.renderers.BlurRenderer
import kotlinx.android.synthetic.main.ly_act_second_blur.*
import org.jetbrains.anko.backgroundDrawable

class ActSecondBlur : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ly_act_second_blur)

        var bitmap : Bitmap? =null
       // 1- Read passed argument
        if (intent.hasExtra("image")){
            val byteArray = intent.getByteArrayExtra("image")
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        }

        // 2- set as background
        if (bitmap != null) {
            val bitmapDrawable = BitmapDrawable( resources , bitmap)

            //setBackgroundDrawable is Depricated
           // root_constraint_layout_blur.setBackgroundDrawable(bitmapDrawable)

            //Use  backgroundDrawable by Anko
            root_constraint_layout_blur.backgroundDrawable = bitmapDrawable
        }

        //3- blur background of layout by library
        ViewFilter.getInstance(this)
            //Use blur effect or implement your custom IRenderer
            .setRenderer(  BlurRenderer(20))
            .applyFilterOnView(  root_constraint_layout_blur,
                root_constraint_layout_blur    )

    }
}
