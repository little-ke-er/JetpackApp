package com.haikun.base_library.ui.bindingadapter

import android.os.Build.VERSION.SDK_INT
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.haikun.base_library.R

/**
 * 包名: com.haikun.base_library.ui.bindingadapter
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 11:54
 * 修改人: haikun
 * 修改时间: 2021/3/29 11:54
 * 修改备注: TODO
 */
object ImageViewBindingAdapter {


    @BindingAdapter("android:imgUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {
        imageView.load(url, ImageLoader.Builder(imageView.context)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
            .build()){
            placeholder(R.drawable.img_empty)
            error(R.drawable.img_empty)
            //transformations(RoundedCornersTransformation(16f.dp))

        }
    }

    @BindingAdapter("android:imgResource")
    @JvmStatic
    fun loadImage(imageView: ImageView,@DrawableRes resourceId: Int) {
        imageView.load(resourceId)
    }
}