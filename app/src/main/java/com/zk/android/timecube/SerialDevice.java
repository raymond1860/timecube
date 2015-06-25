package com.zk.android.timecube;

/**
 * SerialDevice represents a serial device which may be RS-232 or RS-485 port
 */
public class SerialDevice implements SdkDevice
{
    private int mSerialHandle;
    private int mStatus;
    private String defaultPort = "/dev/ttyS2";


    /**
     * Create a serial device instance .
     *
     * @throws SdkException Probably throws a SdkException since internal implementation
     *                      use a control device.
     */
    public SerialDevice() throws SdkException {
        mStatus = SdkDeviceStateClosed;
    }


    /**
     * Open a serial device with default 115200@8N1
     * @throws SdkException Probably may throw SdkException
     */
    public void open() throws SdkException {
        if(mStatus == SdkDeviceStateOpen) return;
        int ret = SdkNative.native_serial_open(defaultPort, 115200, 8, 1, 0);
        if(ret<0){
            throw new SdkException(ret);
        }
        mSerialHandle = ret;
        mStatus = SdkDeviceStateOpen;
    }

    /**
     * Close serial device
     * @throws SdkException Probably may throw SdkException
     */
    public void close() throws SdkException {
        if(mStatus != SdkDeviceStateOpen) return;
        SdkNative.native_serial_close(mSerialHandle);
        mStatus = SdkDeviceStateClosed;
    }

    /**
     * Open a serial device with specified port and default 115200@8N1
     * @param port
     *        serial port name
     * @throws SdkException Probably may throw SdkException
     */
    public void open(String port) throws SdkException {
        if(mStatus == SdkDeviceStateOpen) return;
        int ret = SdkNative.native_serial_open(port, 115200, 8, 1, 0);
        if(ret<0){
            throw new SdkException(ret);
        }
        mSerialHandle = ret;
        mStatus = SdkDeviceStateOpen;
    }
    /**
     * Open serial port with specified baudrate,data bits,stop bits,parity
     *@param port
     *          serial port name
     *@param baudrate
     *          serial communication baud rate,generally it should 9600,115200,etc.
     * @param databits
     *            8\7\6\5
     * @param stopbits
     *            1\2
     * @param parity
     *            0\1\2 0:Parity None 1:Parity Odd 2:Parity Even
     * @throws SdkException Probably may throw SdkException
     */
    public void open(String port,int baudrate,int databits,int stopbits,int parity) throws SdkException {
        if(mStatus == SdkDeviceStateOpen) return;
        int ret = SdkNative.native_serial_open(port,baudrate,databits,stopbits,parity);
        if(ret<0){
            throw new SdkException(ret);
        }
        mSerialHandle = ret;
        mStatus = SdkDeviceStateOpen;
    }

    /**
     * Enable/Disable Transmitter (only used on RS485-like half-duplex serial port) <br>
     *     In half-duplex environment, transceiver under receiving state normally. If<br>
     *    we need to transmit ,please call transmitterEnable(true) firstly.
     *
     * @param enable
     *          enable/disable transmitter
     * @throws SdkException   transmitterEnable may throw SdkException
     */
    private void transmitterEnable(boolean enable) throws SdkException {
       //FIXME
    }
    /**
     * Open serial port with specified baudrate,data bits,stop bits and parity
     *
     * @param baudrate
     *          serial communication baud rate,generally it should 9600,115200,etc.
     * @param databits
     *          serial communication data bits,valid options are 5/6/7/8
     * @param stopbits
     *          serial communication stop bits,valid options are 1/2
     * @param parity
     *          serial communication parity,valid options are 0/1/2 <br>
     *          0 means no parity <br>
     *          1 means Odd parity <br>
     *          2 means Even parity
     * @throws SdkException open may throw SdkException
     */
    public void open(int baudrate, int databits, int stopbits, int parity) throws SdkException {
        if(mStatus == SdkDeviceStateOpen) return;
        int ret = SdkNative.native_serial_open(defaultPort, baudrate, databits, stopbits, parity);
        if(ret<0){
            throw new SdkException(ret);
        }
        mSerialHandle = ret;
        mStatus = SdkDeviceStateOpen;
    }

    /**
     * Read serial device into user buffer
     * @param rbuf
     *            The byte array is used to store data read
     * @return greater or equal than 0 return actual read length,otherwise some
     *         error encountered from low-level driver
     * @throws SdkException read may throw SdkException
     */
    public int read(byte[] rbuf) throws SdkException {
        int ret =SdkNative.native_serial_read(mSerialHandle, rbuf, rbuf.length);
        if(ret<0){
            throw new SdkException(ret);
        }
        return  ret;
    }


    /**
     * Write user buffer wbuf to serial port,don't care duplex and xmit delay
     * @param wbuf
     *            An array to send as a series of bytes
     * @return greater or equal than 0 return actual written length,otherwise
     *         some error encountered from low-level
     * @throws SdkException write may throw SdkException
     *
     */
    public int write(byte[] wbuf) throws SdkException {
        int ret =SdkNative.native_serial_write(mSerialHandle, wbuf, wbuf.length);
        if(ret<0){
            throw new SdkException(ret);
        }
        return ret;
    }

    /**
     *  Write user buffer wbuf to serial port in half duplex mode and using xmit delay
     * @param wbuf
     *            An array to send as a series of bytes
     * @param writeDelayMS
     *         delay time after writing to transceiver ( in unit millisecond.)
     * @return greater or equal than 0 return actual written length,otherwise
     *         some error encountered from low-level
     * @throws SdkException write may throw SdkException
     *
     */
    public int halfDuplexWrite(byte[] wbuf,int writeDelayMS) throws SdkException {
        try{
            transmitterEnable(true);
        }catch (SdkException e){
            throw new SdkException(e.errorCode());
        }
        int ret =SdkNative.native_serial_write(mSerialHandle, wbuf, wbuf.length);
        if(ret<0){
            throw new SdkException(ret);
        }
        try{
            if(writeDelayMS != 0)
                Thread.sleep(writeDelayMS);
            transmitterEnable(false);
        }catch (SdkException e){
            throw new SdkException(e.errorCode());
        }catch (InterruptedException e){
            throw new SdkException("InterruptedException");
        }
        return ret;
    }
}
