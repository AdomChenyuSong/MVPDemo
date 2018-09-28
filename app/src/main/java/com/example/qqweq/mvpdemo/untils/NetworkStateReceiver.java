package com.example.qqweq.mvpdemo.untils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyd
 * on 14-4-21
 */
public class NetworkStateReceiver extends BroadcastReceiver {

    public interface NetworkStateListener {
        void onNetworkStateChanged(boolean isConnected, int type);
    }

    public enum NetEnumworkStateReceiver {
        INSTANCE;
        private NetworkStateReceiver networkStateReceiver;

        private NetEnumworkStateReceiver() {
            networkStateReceiver = new NetworkStateReceiver();
        }

        public NetworkStateReceiver getInstance() {
            return networkStateReceiver;
        }
    }

    public void register(Context context) {
        checkNetworkState(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(NetEnumworkStateReceiver.INSTANCE.getInstance(), intentFilter);
    }

    public static void unregister(Context context) {
        NetEnumworkStateReceiver.INSTANCE.getInstance().removeAllListeners();
        context.unregisterReceiver(NetEnumworkStateReceiver.INSTANCE.getInstance());
    }

    private int networkType = ConnectivityManager.TYPE_WIFI;
    private boolean isConnected = false;

    public boolean isConnected() {
        return isConnected;
    }

    private List<NetworkStateListener> networkStateListeners = new ArrayList<NetworkStateListener>();

    public void addListener(NetworkStateListener listener) {
        if (!networkStateListeners.contains(listener)) {
            networkStateListeners.add(listener);
        }

        listener.onNetworkStateChanged(isConnected, networkType);
    }

    public void removeListener(NetworkStateListener listener) {
        networkStateListeners.remove(listener);
    }

    public void removeAllListeners() {
        networkStateListeners.clear();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        checkNetworkState(context);
    }

    private void checkNetworkState(Context context) {
        boolean connected = false;

        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            connected = networkInfo.isConnected();
            networkType = networkInfo.getType();
        }

        if (isConnected != connected) {
            isConnected = connected;

            for (NetworkStateListener listener : networkStateListeners) {
                listener.onNetworkStateChanged(connected, networkType);
            }
        }
    }

}
