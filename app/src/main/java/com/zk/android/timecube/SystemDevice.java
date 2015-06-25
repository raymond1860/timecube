package com.zk.android.timecube;

import android.os.Build;

/**
 * Represents as system device which can access system level resources.
 */
public class SystemDevice implements SdkDevice {
    private int mStatus;

    /**
     * Create a SystemDevice instance .
     */
    public SystemDevice() {
        mStatus = SdkDeviceStateClosed;
    }
    /**
     * Open a serial device with default 115200@8N1
     * @throws SdkException Probably may throw SdkException
     */
    public void open() throws SdkException {
        if(mStatus == SdkDeviceStateOpen) return;
        mStatus = SdkDeviceStateOpen;
    }

    /**
     * Close serial device
     * @throws SdkException Probably may throw SdkException
     */
    public void close() throws SdkException {
        if(mStatus != SdkDeviceStateOpen) return;
        mStatus = SdkDeviceStateClosed;
    }


    /**
     * Get RomID string
     * @return RomID string
     */
    public String getRomID() throws SdkException{
        //FIXME
        throw new SdkException("get RomID failed");
    }

    /**
     * Get Android version
     * @return such as "4.2.2","4.4.2"
     */
    public String getAndroidVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * Get linux version
     * @return Linux version such as "2.6.x","3.1.x"
     */
    public String getLinuxVersion(){
        return System.getProperty("os.version");
    }

    /**
     * Get system config,name=value format,e.g."rfid=1,wifi=1",token is ','
     * @return config string
     */
    public String getSystemConfig(){
        return "Wi-Fi=1,Ethernet=1";
    }
}

