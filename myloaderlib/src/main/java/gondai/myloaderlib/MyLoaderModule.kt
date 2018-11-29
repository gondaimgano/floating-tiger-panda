package gondai.myloaderlib

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory



@GlideModule
abstract class MyLoaderModule:AppGlideModule() {

    abstract var diskCacheSizeByte:Long

    abstract  fun options()

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        options()

        builder.setDiskCache(InternalCacheDiskCacheFactory(context, diskCacheSizeByte))
        super.applyOptions(context, builder)
    }
}