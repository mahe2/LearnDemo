package com.learn.demo.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class CheckNetWorkStatus {
	private static final String PREFERENCES_NAME = "com_cyou_2GAnd3G_Switch";
	private static final String IS_FORBID = "isForbid";
	

	/**
	 * 检查网络是否连通
	 * 
	 * @return true or false
	 */
	public static boolean isNetworkAvailable(Context context) {
		// 是否禁用2g 3g网络
//		boolean isforbid = SharedPreferenceManager.read(context, PREFERENCES_NAME, IS_FORBID, false);

		return isNetworkAvailable(context, false);
	}

	/**
	 * 是否禁用2G/3G网,只有是Wifi连接才可以是有效连接 WangQing 2013-8-13 boolean
	 * 
	 * @param context
	 *            上下文
	 * @param isforbid2Gor3G
	 *            判断是2G 还是 3G
	 * @return 是否可用
	 */
	public static boolean isNetworkAvailable(Context context,
			Boolean isforbid2Gor3G) {
		Boolean returnV = false;
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connectivity == null) {
			return false;
		} else {
			// 获取代表联网状态的NetWorkInfo对象
			NetworkInfo info = connectivity.getActiveNetworkInfo();
			if (info != null) {
				boolean available = info.isAvailable();
				if (isforbid2Gor3G) {
					// 只有Wifi 可用
					// 获取当前的网络连接是否可用
					State state = connectivity.getNetworkInfo(
							ConnectivityManager.TYPE_WIFI).getState();
					if (State.CONNECTED == state && available) {
						returnV = true;
					}
				} else {
					// 可以使用3G 网络访问
					returnV = available;
				}
			} else {
				return false;
			}
		}
		return returnV;

	}
	
	
	public static boolean isNetwork2G3G4G(Context context  ){
		ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connectivity == null){
			return false;
		}
		NetworkInfo info = connectivity.getActiveNetworkInfo();
		if(info == null){
			return false;
		}
		
		State state = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
		if(state == State.CONNECTED && info.isAvailable()){
			return true;
		}
		return false;
	}
	
	public static boolean isNetwork2G3G4G(Context context ,Intent intent ){
		ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connectivity == null){
			return false;
		}
		NetworkInfo info = connectivity.getActiveNetworkInfo();
		if(info == null){
			return false;
		}
		
		
		NetworkInfo networkInfo = (NetworkInfo) intent
				.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
		if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE
				&& networkInfo.isConnected()) {
			return true;
		}
			
			
		
//		State state = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
//		if(state == State.CONNECTED && info.isAvailable()){
//			return true;
//		}
		return false;
	}
	
	public static boolean isWifiOpen(Context context){
		ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {      
            NetworkInfo[] infos = manager.getAllNetworkInfo();      
            if (infos != null) {      
                for(NetworkInfo ni : infos){  
                    if(ni.getTypeName().equals("WIFI") && ni.isConnected()){  
                        return true;  
                    }  
                }  
            }      
        }
        return false;
	}
	
	public static String getConnectWifiSsid(Context context){ 
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo(); 
        return wifiInfo.getSSID(); 
 }
}
