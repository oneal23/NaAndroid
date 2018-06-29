package com.na.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresPermission;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * Created by oneal23 on 2018/6/29.
 */
public final class PhoneUtil extends BaseUtil {

    private static class PhoneUtilHolder {
        public final static PhoneUtil INSTANCE = new PhoneUtil();
    }


    public static PhoneUtil getInstance() {
        return PhoneUtil.PhoneUtilHolder.INSTANCE;
    }

    /**
     * Return whether the device is phone.
     *
     * @return {@code true}: yes<br>{@code false}: no
     */
    public boolean isPhone() {
        boolean flag = false;
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null && tm.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE) {
            flag = true;
        }
        return flag;
    }

    /**
     * Return the unique device id.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return the unique device id
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public String getDeviceId() {
        String did = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String imei = tm.getImei();
                if (!StringUtil.isEmpty(did)) {
                    did = imei;
                } else {
                    did = tm.getMeid();
                }
            } else {
                did = tm.getDeviceId();
            }

            if (did == null) {
                did = "";
            }
        }
        return did;
    }

    /**
     * Return the serial of device.
     *
     * @return the serial of device
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public String getSerial() {
        String serial = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            serial = Build.getSerial();
        } else {
            serial = Build.SERIAL;
        }

        if (serial == null) {
            serial = "";
        }
        return serial;
    }

    /**
     * Return the IMEI.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return the IMEI
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public String getIMEI() {
        String imei = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                imei = tm.getImei();
            } else {
                imei = tm.getDeviceId();
            }

            if (imei == null) {
                imei = "";
            }
        }
        return imei;
    }

    /**
     * Return the MEID.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return the MEID
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public String getMEID() {
        String meid = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                meid = tm.getMeid();
            } else {
                meid = tm.getDeviceId();
            }

            if (meid == null) {
                meid = "";
            }
        }
        return meid;
    }

    /**
     * Return the IMSI.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return the IMSI
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public String getIMSI() {
        String imsi = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            imsi = tm.getSubscriberId();
            if (imsi == null) {
                imsi = "";
            }
        }
        return imsi;
    }

    /**
     * Returns the current phone type.
     *
     * @return the current phone type
     * <ul>
     * <li>{@link TelephonyManager#PHONE_TYPE_NONE}</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_GSM }</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_CDMA}</li>
     * <li>{@link TelephonyManager#PHONE_TYPE_SIP }</li>
     * </ul>
     */
    public int getPhoneType() {
        int type = -1;
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            type = getPhoneType();
        }
        return type;
    }

    /**
     * Return whether sim card state is ready.
     *
     * @return {@code true}: yes<br>{@code false}: no
     */
    public boolean isSimCardReady() {
        boolean isReady = false;
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            isReady = (tm.getSimState() == TelephonyManager.SIM_STATE_READY);
        }
        return isReady;
    }

    /**
     * Return the sim operator name.
     *
     * @return the sim operator name
     */
    public String getSimOperatorName() {
        String soName = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            soName = tm.getSimOperatorName();
            if (soName == null) {
                soName = "";
            }
        }
        return soName;
    }

    /**
     * Return the sim operator using mnc.
     *
     * @return the sim operator
     */
    public String getSimOperatorByMnc() {
        String operator = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            operator = tm.getSimOperator();
            if (operator == null) {
                operator = "";
            }
        }
        return operator;
//        if (operator == null) return null;
//        switch (operator) {
//            case "46000":
//            case "46002":
//            case "46007":
//                return "中国移动";
//            case "46001":
//                return "中国联通";
//            case "46003":
//                return "中国电信";
//            default:
//                return operator;
//        }
    }

    /**
     * Return the phone status.
     * <p>Must hold
     * {@code <uses-permission android:name="android.permission.READ_PHONE_STATE" />}</p>
     *
     * @return DeviceId = 99000311726612<br>
     * DeviceSoftwareVersion = 00<br>
     * Line1Number =<br>
     * NetworkCountryIso = cn<br>
     * NetworkOperator = 46003<br>
     * NetworkOperatorName = 中国电信<br>
     * NetworkType = 6<br>
     * PhoneType = 2<br>
     * SimCountryIso = cn<br>
     * SimOperator = 46003<br>
     * SimOperatorName = 中国电信<br>
     * SimSerialNumber = 89860315045710604022<br>
     * SimState = 5<br>
     * SubscriberId(IMSI) = 460030419724900<br>
     * VoiceMailNumber = *86<br>
     */
    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    public String getPhoneStatus() {
        String str = "";
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            str += "DeviceId(IMEI) = " + tm.getDeviceId() + "\n";
            str += "DeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion() + "\n";
            str += "Line1Number = " + tm.getLine1Number() + "\n";
            str += "NetworkCountryIso = " + tm.getNetworkCountryIso() + "\n";
            str += "NetworkOperator = " + tm.getNetworkOperator() + "\n";
            str += "NetworkOperatorName = " + tm.getNetworkOperatorName() + "\n";
            str += "NetworkType = " + tm.getNetworkType() + "\n";
            str += "PhoneType = " + tm.getPhoneType() + "\n";
            str += "SimCountryIso = " + tm.getSimCountryIso() + "\n";
            str += "SimOperator = " + tm.getSimOperator() + "\n";
            str += "SimOperatorName = " + tm.getSimOperatorName() + "\n";
            str += "SimSerialNumber = " + tm.getSimSerialNumber() + "\n";
            str += "SimState = " + tm.getSimState() + "\n";
            str += "SubscriberId(IMSI) = " + tm.getSubscriberId() + "\n";
            str += "VoiceMailNumber = " + tm.getVoiceMailNumber() + "\n";
        }
        return str;
    }

    /**
     * Skip to dial.
     *
     * @param phoneNumber The phone number.
     */
    public void dial(final String phoneNumber) {
       getContext().startActivity(IntentUtil.getInstance().getDialIntent(phoneNumber, true));
    }

    /**
     * Make a phone call.
     * <p>Must hold {@code <uses-permission android:name="android.permission.CALL_PHONE" />}</p>
     *
     * @param phoneNumber The phone number.
     */
    @RequiresPermission(Manifest.permission.CALL_PHONE)
    public void call(final String phoneNumber) {
        getContext().startActivity(IntentUtil.getInstance().getCallIntent(phoneNumber, true));
    }

    /**
     * Send sms.
     *
     * @param phoneNumber The phone number.
     * @param content     The content.
     */
    public void sendSms(final String phoneNumber, final String content) {
        getContext().startActivity(IntentUtil.getInstance().getSendSmsIntent(phoneNumber, content, true));
    }

    /**
     * Send sms silently.
     * <p>Must hold {@code <uses-permission android:name="android.permission.SEND_SMS" />}</p>
     *
     * @param phoneNumber The phone number.
     * @param content     The content.
     */
    @RequiresPermission(Manifest.permission.SEND_SMS)
    public void sendSmsSilent(final String phoneNumber, final String content) {
        if (!StringUtil.isEmpty(content)) {
            PendingIntent sentIntent = PendingIntent.getBroadcast(getContext(), 0, new Intent("send"), 0);
            SmsManager smsManager = SmsManager.getDefault();
            if (content.length() >= 70) {
                List<String> ms = smsManager.divideMessage(content);
                for (String str : ms) {
                    smsManager.sendTextMessage(phoneNumber, null, str, sentIntent, null);
                }
            } else {
                smsManager.sendTextMessage(phoneNumber, null, content, sentIntent, null);
            }
        }
    }
}
