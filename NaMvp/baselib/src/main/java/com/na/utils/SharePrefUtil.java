package com.na.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Set;

/**
 * Created by oneal23 on 2018/6/29.
 */
public final class SharePrefUtil extends BaseUtil{

    private SharedPreferences preferences;

    private static class SharePrefUtilHolder {
        public final static SharePrefUtil INSTANCE = new SharePrefUtil();
    }

    public static SharePrefUtil getInstance() {
        return SharePrefUtilHolder.INSTANCE;
    }

    private SharePrefUtil() {

    }

    public SharedPreferences.Editor getEditor() {
        return preferences.edit();
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void init(String preFileName) {
        try {
            preferences = getContext().getSharedPreferences(preFileName, Context.MODE_PRIVATE);
        } catch (Exception e) {
            LogUtil.e(e, "init error");
        }
    }

    /**
     * 移除某个key
     *
     * @param key
     * @return 是否移除成功
     */
    public void remove(String key) {
        getEditor().remove(key).commit();
    }

    /**
     * 清除所有数据
     */
    public void clear() {
        getEditor().clear().commit();
    }

    /**
     * 保存 String数据 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的String数据
     */
    public void put(String key, String value) {
        getEditor().putString(key, value).commit();
    }

    /**
     * 读取 String数据
     *
     * @param key
     * @return String 数据
     */
    public String getAsString(String key, String def) {
        return getPreferences().getString(key, def);
    }

    /**
     * 保存 Boolean数据 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的String数据
     */
    public void put(String key, boolean value) {
        getEditor().putBoolean(key, value).commit();
    }

    /**
     * 读取 String数据
     *
     * @param key
     * @return String 数据
     */
    public boolean getAsBoolean(String key, boolean def) {
        return getPreferences().getBoolean(key, def);
    }

    public void put(String key, int value) {
        getEditor().putInt(key, value).commit();
    }

    public int getAsInt(String key, int def) {
        return getPreferences().getInt(key, def);
    }

    public void put(String key, long value) {
        getEditor().putLong(key, value).commit();
    }

    public long getAsLong(String key, long def) {
        return getPreferences().getLong(key, def);
    }

    public void put(String key, float value) {
        getEditor().putFloat(key, value).commit();
    }

    public float getAsFloat(String key, float def) {
        return getPreferences().getFloat(key, def);
    }

    public void put(String key, Set<String> value) {
        getEditor().putStringSet(key, value);
    }

    public Set<String> getAsStringSet(String key, Set<String> def) {
        return getPreferences().getStringSet(key, def);
    }

    /**
     * 保存 JSONObject数据 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的JSON数据
     */
    public void put(String key, JSONObject value) {
        saveObject(key, value);
    }

    /**
     * 读取JSONObject数据
     *
     * @param key
     * @return JSONObject数据
     */
    public JSONObject getAsJSONObject(String key) {
        Object object = readObject(key);
        if (object instanceof JSONObject) {
            return (JSONObject) object;
        }
        return null;
    }

    /**
     * 保存 JSONArray数据 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的JSONArray数据
     */
    public void put(String key, JSONArray value) {
        saveObject(key, value);
    }

    /**
     * 读取JSONArray数据
     *
     * @param key
     * @return JSONArray数据
     */
    public JSONArray getAsJSONArray(String key) {
        Object object = readObject(key);
        if (object instanceof JSONArray) {
            return (JSONArray) object;
        }
        return null;
    }

    /**
     * 保存 byte数据 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的数据
     */
    public void put(String key, byte[] value) {
        saveObject(key, value);
    }

    /**
     * 获取 byte 数据
     *
     * @param key
     * @return byte 数据
     */
    public byte[] getAsBinary(String key) {
        Object object = readObject(key);
        if (object instanceof byte[]) {
            return (byte[]) object;
        }
        return null;
    }

    /**
     * 保存 Serializable数据 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的value
     */
    public void put(String key, Serializable value) {
        saveObject(key, value);
    }

    /**
     * 读取 Serializable数据
     *
     * @param key
     * @return Serializable 数据
     */
    public Object getAsObject(String key) {
        Object object = readObject(key);
        if (object instanceof Serializable) {
            return (Serializable) object;
        }
        return null;
    }

    /**
     * 保存 bitmap 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的bitmap数据
     */
    public void put(String key, Bitmap value) {
        saveObject(key, value);
    }


    /**
     * 读取 bitmap 数据
     *
     * @param key
     * @return bitmap 数据
     */
    public Bitmap getAsBitmap(String key) {
        Object object = readObject(key);
        if (object instanceof Bitmap) {
            return (Bitmap) object;
        }
        return null;
    }

    /**
     * 保存 drawable 到 缓存中
     *
     * @param key   保存的key
     * @param value 保存的drawable数据
     */
    public void put(String key, Drawable value) {
        saveObject(key, value);
    }

    /**
     * 读取 Drawable 数据
     *
     * @param key
     * @return Drawable 数据
     */
    public Drawable getAsDrawable(String key) {
        Object object = readObject(key);
        if (object instanceof Drawable) {
            return (Drawable) object;
        }
        return null;
    }

    private void saveObject(String key, Object obj) {
        try {
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(obj);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            getEditor().putString(key, bytesToHexString);
            getEditor().commit();
        } catch (IOException e) {
            LogUtil.e(e, "saveObject", "error");
        }
    }

    /**
     * desc:获取保存的Object对象
     *
     * @return modified:
     */
    private Object readObject(String key) {
        try {
            if (getPreferences().contains(key)) {
                String string = getPreferences().getString(key, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is = new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    Object readObject = is.readObject();
                    return readObject;
                }
            }
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * desc:将数组转为16进制
     *
     * @param bArray
     * @return modified:
     */
    private static String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * desc:将16进制的数据转为数组
     * <p>创建人：聂旭阳 , 2014-5-25 上午11:08:33</p>
     *
     * @param data
     * @return modified:
     */
    private static byte[] StringToBytes(String data) {
        String hexString = data.toUpperCase().trim();
        if (hexString.length() % 2 != 0) {
            return null;
        }
        byte[] retData = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i++) {
            int int_ch;  // 两位16进制数转化后的10进制数
            char hex_char1 = hexString.charAt(i); ////两位16进制数中的第一位(高位*16)
            int int_ch3;
            if (hex_char1 >= '0' && hex_char1 <= '9')
                int_ch3 = (hex_char1 - 48) * 16;   //// 0 的Ascll - 48
            else if (hex_char1 >= 'A' && hex_char1 <= 'F')
                int_ch3 = (hex_char1 - 55) * 16; //// A 的Ascll - 65
            else
                return null;
            i++;
            char hex_char2 = hexString.charAt(i); ///两位16进制数中的第二位(低位)
            int int_ch4;
            if (hex_char2 >= '0' && hex_char2 <= '9')
                int_ch4 = (hex_char2 - 48); //// 0 的Ascll - 48
            else if (hex_char2 >= 'A' && hex_char2 <= 'F')
                int_ch4 = hex_char2 - 55; //// A 的Ascll - 65
            else
                return null;
            int_ch = int_ch3 + int_ch4;
            retData[i / 2] = (byte) int_ch;//将转化后的数放入Byte里
        }
        return retData;
    }
}
