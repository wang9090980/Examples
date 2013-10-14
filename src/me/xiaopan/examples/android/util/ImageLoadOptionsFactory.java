package me.xiaopan.examples.android.util;

import me.xiaopan.easy.network.android.image.DefaultAlphaAnimationListener;
import me.xiaopan.easy.network.android.image.DefaultBitmapLoadHandler;
import me.xiaopan.easy.network.android.image.ImageLoadOptions;
import me.xiaopan.examples.android.R;
import android.content.Context;

/**
 * ImageLoadOptions工厂类，专门提供适合各种场景的ImageLoadOptions
 */
public class ImageLoadOptionsFactory {
	private static ImageLoadOptions defaultImageLoadOptions;	//默认的ImageLoadOptions
	private static ImageLoadOptions listImageLoadOptions;	//列表用的ImageLoadOptions
	
	/**
	 * 获取默认的ImageLoadOptions，默认的ImageLoadOptions的特别之处在于不会将Bitmap缓存在内存中
	 * @return
	 */
	public static final ImageLoadOptions getDefaultImageLoadOptions(Context context){
		if(defaultImageLoadOptions == null){
			defaultImageLoadOptions = new ImageLoadOptions();
			defaultImageLoadOptions.setCacheInLocal(true);	//将图片缓存到本地
			defaultImageLoadOptions.setLoadingDrawableResId(R.drawable.images_loading);	//设置加载中显示的图片
			defaultImageLoadOptions.setShowAnimationListener(new DefaultAlphaAnimationListener());	//设置一个透明度由50%渐变到100%的显示动画
			defaultImageLoadOptions.setBitmapLoadHandler(new DefaultBitmapLoadHandler(context));	//设置一个图片处理器，保证读取到大小合适的Bitmap，避免内存溢出
		}
		return listImageLoadOptions;
	}
	
	/**
	 * 获取列表用的ImageLoadOptions，其同默认的ImageLoadOptions的不同之处在于其会将Bitmap缓存到内存中
	 * @return
	 */
	public static final ImageLoadOptions getListImageLoadOptions(Context context){
		if(listImageLoadOptions == null){
			listImageLoadOptions = new ImageLoadOptions();
			listImageLoadOptions.setCachedInMemory(true);	//每次加载图片的时候先从内存中去找，并且加载完成后将图片缓存在内存中
			listImageLoadOptions.setCacheInLocal(true);	//将图片缓存到本地
			listImageLoadOptions.setLoadingDrawableResId(R.drawable.images_loading);	//设置加载中显示的图片
			listImageLoadOptions.setShowAnimationListener(new DefaultAlphaAnimationListener());	//设置一个透明度由50%渐变到100%的显示动画
			listImageLoadOptions.setBitmapLoadHandler(new DefaultBitmapLoadHandler(context));	//设置一个图片处理器，保证读取到大小合适的Bitmap，避免内存溢出
		}
		return listImageLoadOptions;
	}
}