package com.zk.android.timecube;

/**
 * IoDevice represents a device which can operate low level IO
 */
public class IoDevice implements SdkDevice{
    /**
     * IO pin direction input
     */
    public static final int IoPinDirInput=0;
    /**
     * IO pin direction output
     */
    public static final int IoPinDirOutput=1;
    /**
     * IO pin level high
     */
    public static final int IoPinLevelHigh=1;
    /**
     * Io pin level low
     */
    public static final int IoPinLevelLow=0;
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

    /**
     * Set IO level
     * @param io
     *          IO number
     * @param level
     *          expected level,{ @link #IoPinLevelHigh }
     * @throws SdkException Probably may throw SdkException
     */
    public void setLevel(int io,int level) throws SdkException{
        //FIXME
    }


    /**
     * Set IO level
     * @param io
     *          IO number
     * @return io level {@link #IoPinLevelHigh}
     * @throws SdkException Probably may throw SdkException
     */
    public int getLevel(int io) throws SdkException{
        //FIXME
        return 0;
    }

    /**
     * Set IO Direction
     * @param io
     *          IO number
     * @param dir
     *          expected level,{@link #IoPinDirInput}
     * @throws SdkException Probably may throw SdkException
     */
    public void setDir(int io,int dir) throws SdkException{
    //FIXME
    }


    /**
     * Set IO level
     * @param io
     *          IO number
     * @return io direction {@link #IoPinDirInput}
     * @throws SdkException Probably may throw SdkException
     */
    public int getDir(int io) throws SdkException{
    //FIXME
    return 0;
    }
}
