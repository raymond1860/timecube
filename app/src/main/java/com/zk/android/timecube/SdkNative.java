package com.zk.android.timecube;

/**
 * Created by Administrator on 2015/6/25.
 */
public class SdkNative {
      static
        {
            System.loadLibrary("zk_android_device");
        }

        // FP
        public static native int native_fp_init();

        public static native void native_fp_free();

        public static native int native_fp_open(int index);

        public static native int native_fp_close(int index);

        public static native int native_fp_sensorCapture(int index, byte[] imageBuffer, int imageBufferSize);

        public static native int native_fp_setParameter(int index, int parameterType, String parameterValue);

        public static native String native_fp_getParameter(int index, int parameterType);

        public static native int native_fp_getCount();

        public static native String native_fp_getSensorName(int index);

        public static native int native_fp_getLastError(int index);

        // SERIAL
        public static native int native_serial_open(String port,int baudrate, int databits, int stopbits, int parity);

        public static native int native_serial_read(int handle, byte[] rbuf, int rlen);

        public static native int native_serial_write(int handle, byte[] wbuf, int wlen);

        public static native void native_serial_close(int handle);

}
