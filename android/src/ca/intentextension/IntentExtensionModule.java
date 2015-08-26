package ca.intentextension;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.proxy.IntentProxy;

import android.content.Intent;

@Kroll.module(name="IntentExtension", id="ca.intentextension")
public class IntentExtensionModule extends KrollModule {

	private static final String LCAT = "IntentExtensionModule";
	private static final boolean DBG = TiConfig.LOGD;

	public IntentExtensionModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) { }

	@Kroll.method
	public EnhancedIntentProxy getIntentExtension(IntentProxy intent) {
		return new EnhancedIntentProxy(intent.getIntent());
	}

}

