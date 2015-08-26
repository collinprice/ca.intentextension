// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
win.open();

// TODO: write your module tests here
var intentextension = require('ca.intentextension');


var image = Ti.Filesystem.getFile(Ti.Filesystem.resourcesDirectory, "appicon.png").read();
var currentIntent = Ti.Android.currentActivity.getIntent();

currentIntent.setAction(Ti.Android.ACTION_MAIN);
currentIntent.putExtra("shortcut", "this is my shortcut");

var IntentExtension = require('ca.intentextension');

var newIntent = IntentExtension.getIntentExtension(Ti.Android.createIntent({
	action: Ti.Android.ACTION_CREATE_SHORTCUT,
}));

newIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");

newIntent.putExtra(Ti.Android.EXTRA_SHORTCUT_NAME, "My Shortcut");
newIntent.putExtra(Ti.Android.EXTRA_SHORTCUT_INTENT, currentIntent);
newIntent.putExtra(Ti.Android.EXTRA_SHORTCUT_ICON, image);
newIntent.putExtra("duplicate", false);

Ti.Android.currentActivity.sendBroadcast(newIntent);