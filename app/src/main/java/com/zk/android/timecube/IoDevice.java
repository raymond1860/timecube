package com.zk.android.timecube;

/**
 * IoDevice represents a device which can operate low level IO
 */
public class IoDevice implements SdkDevice{
    private int mStatus;
    /**
     * Create a Io device instance .
     */
    public IoDevice() {
        mStatus = SdkDeviceStateClosed;
    }


    /**
     * Open a serial device with default 115200@8N1
     * @throws SdkException Probably may throw SdkException
     */
    public void open() throws SdkException {
        if(mStatus == SdkDeviceStateOpen) return;
        //FIXME
        mStatus = SdkDeviceStateOpen;
    }

    /**
     * Close serial device
     * @throws SdkException Probably may throw SdkException
     */
    public void close() throws SdkException {
        if(mStatus != SdkDeviceStateOpen) return;
        //FIXME
        mStatus = SdkDeviceStateClosed;
    }
}
