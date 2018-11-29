package gondai.myloaderlib

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


class MyLoader {
    companion object {
        fun    loadImage( url:String, view:ImageView ){

          //Caching comes out of the box with Glide
            Glide.with(view.context)

                    .load(url)

                         .into(view)






        }

    }
}