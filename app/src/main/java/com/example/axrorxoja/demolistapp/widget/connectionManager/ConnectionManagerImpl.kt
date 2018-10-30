package com.example.axrorxoja.demolistapp.widget.connectionManager

import android.net.ConnectivityManager

class ConnectionManagerImpl(private val manager: ConnectivityManager) : IConnectionManager {
    override fun isHaveNetwork(): Boolean = manager.activeNetworkInfo != null
}