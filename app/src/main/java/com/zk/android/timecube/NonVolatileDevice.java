package com.zk.android.timecube;


/**
 * NonVolatileDevice represents a device which can operate non volatile storage device
 */
public class NonVolatileDevice implements SdkDevice{
    private int mStatus;
    /**
     * Create a Io device instance .
     */
    public NonVolatileDevice() {
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

    public void setInt(String name,int value) throws SdkException{
        //FIXME
    }

    public void setBoolean(String name,boolean value) throws SdkException{
        //FIXME
    }

    public void setString(String name,String value) throws SdkException{
        //FIXME
    }

    public void setRaw(String name,byte[] raw) throws SdkException{
        //FIXME
    }

    public int getInt(String name) throws SdkException{
        //FIXME
        return 0;
    }

    public boolean setBoolean(String name) throws SdkException{
        //FIXME
        return false;
    }

    public String getString(String name) throws SdkException{
        //FIXME
        return null;
    }

    public byte[] getRaw(String name) throws SdkException{
        byte[] ab = new byte[10];
        return ab;
    }
}
