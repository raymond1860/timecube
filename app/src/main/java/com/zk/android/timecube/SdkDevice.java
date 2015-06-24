package com.zk.android.timecube;
/**
 * Interface SdkDevice represents common API for any sdk device.
 */
public interface SdkDevice
{
    public static final int SdkDeviceStateClosed=0;
    public static final int SdkDeviceStateOpen=1;
    void open() throws SdkException;
    void close() throws SdkException;
}
