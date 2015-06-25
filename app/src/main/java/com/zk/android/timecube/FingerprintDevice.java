package com.zk.android.timecube;

/**
 * FPSensorDevice class represent a FP sensor ,contains capture the image of
 * FP,detect and correct the image, get some information of the FP sensor,etc.
 */
public class FingerprintDevice implements SdkDevice {
    private int mIndex;
    private int mStatus;

    /**
     * Construct a FP sensor
     *
     * @param index The index of available FP sensor, for example: if init
     *              function return 1,the index will be 0.
     */
    public FingerprintDevice(int index) {
        this.mIndex = index;
        mStatus = SdkDeviceStateClosed;
    }

    /**
     * Construct a FP sensor with default index 0
     */
    public FingerprintDevice() {
        this(0);
    }

    /**
     * Open FP sensor
     *
     * @throws SdkException Probably throw SdkException
     */
    public void open() throws SdkException {
        if (mStatus == SdkDeviceStateOpen)
            return;
        //FIXME
        mStatus = SdkDeviceStateOpen;
    }

    /**
     * Close FP sensor
     *
     * @throws SdkException Probably throw SdkException
     */
    public void close() throws SdkException {
        if (mStatus != SdkDeviceStateOpen)
            return;
        mStatus = SdkDeviceStateClosed;
    }

    /**
     * Capture FP image from FP sensor
     *
     * @param imageBuffer The byte array which to store the data of FP, The size of the
     *                    array is image's width * image's height. You can get the width
     *                    of FP image by call function
     *                    getParameter(0,Const.FP_PARAM_IMAGE_WIDTH). Get the height of
     *                    FP image by call function
     *                    getParameter(0,Const.FP_PARAM_IMAGE_HEIGHT). before you call
     *                    this function make sure sensor have initialization OK.
     * @return 0: success,otherwise throws SdkException
     * @throws SdkException sensorCapture throw SdkException
     */
    public int sensorCapture(byte[] imageBuffer) throws SdkException {
        int ret = 1;
        //FIXME
        if (ret != 0) {
            throw new SdkException(ret);
        }
        return ret;
    }

    /**
     * Set parameter
     *
     * @param parameterType  The type of parameter
     * @param parameterValue The value of parameter to be set
     * @return 0: success,otherwise throws SdkException
     * @throws SdkException setParameter throw SdkException
     */
    public int setParameter(int parameterType, String parameterValue) throws SdkException {
        int ret = -1;
        //FIXME
        if (ret != 0) {
            throw new SdkException(ret);
        }
        return ret;
    }

    /**
     * Get parameter
     *
     * @param parameterType The type of parameter
     * @return The value of the parameter
     * @throws SdkException getParameter throw SdkException
     */
    public String getParameter(int parameterType) throws SdkException {
        String ret = "nothing";
        //FIXME
        if (ret == null || ret.length() <= 0) {
            throw new SdkException("get Parameter error");
        }
        return ret;
    }


}