package ca.intentextension;

import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;

import org.appcelerator.titanium.proxy.IntentProxy;
import org.appcelerator.titanium.TiBlob;

import android.content.Intent;
import android.graphics.Bitmap;

@Kroll.proxy
public class EnhancedIntentProxy extends IntentProxy {

	private static final String TAG = "EnhancedIntentProxy";

	public EnhancedIntentProxy() {
		super();
	}

	public EnhancedIntentProxy(Intent intent) {
		super(intent);
	}

	@Override
	@Kroll.method
	public void putExtra(String key, Object value) {

		if (value instanceof IntentProxy) {
			intent.putExtra(key, (Intent) ((IntentProxy) value).getIntent());
		} else if (value instanceof TiBlob) {
			intent.putExtra(key, ((TiBlob) value).getImage());
		} else {
			super.putExtra(key, value);
		}
	}
}