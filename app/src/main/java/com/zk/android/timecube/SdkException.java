package com.zk.android.timecube;

import java.io.IOException;
import java.util.HashMap;

/**
 * SdkException represents Sdk relevant exception.
 */
public class SdkException extends IOException
{
    private static final long               serialVersionUID = -1L;
    private int mDDKError = -1000;
    private static HashMap<Integer, String> mErrorMap;
    private static Boolean                  mbMapInit        = false;
    private static ErrorMaps mErrMaps = new ErrorMaps();
    private static class ErrorMaps
    {
        public ErrorMaps()
        {
            initMap();
        }

        String get(int errcode) {
            String err = mErrorMap.get(errcode);
            String errUnknown = "Unknown error";
            if (err != null)
                return err;
            return errUnknown;
        }
        void initMap()
        {
            if (!mbMapInit)
            {
                mErrorMap = new HashMap<Integer, String>();
                mErrorMap.put(-5001, "NULL, Get value failed");

                mbMapInit = true;
            }
        }
    }


    public SdkException(int errcode)
    {
        super(mErrMaps.get(errcode));
        mDDKError = errcode;
    }

    public SdkException(String err)
    {
        super(err);
    }

    public int errorCode()
    {
        return mDDKError;
    }

    public String errorString()
    {
        return mErrMaps.get(mDDKError);
    }
}

