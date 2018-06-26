package com.na.demo.data.net;

import com.na.data.net.IHttpHeader;
import com.na.data.net.IHttpHeaderManager;
import com.na.demo.BuildConfig;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public class HeaderMananger implements IHttpHeaderManager {

    private DefaultHeader defaultHeader;

    private DefaultHeader privateHeader;

    private static class HeaderManangerHolder{
        public static HeaderMananger INSTANCE = new HeaderMananger();
    }

    private HeaderMananger() {
        defaultHeader = new DefaultHeader();
        defaultHeader.setAppType("android");
        defaultHeader.setVersionCode(BuildConfig.VERSION_CODE + "");
        defaultHeader.setVersionName(BuildConfig.VERSION_NAME);
    }

    @Override
    public IHttpHeader getDefaultHeader() {
        return defaultHeader;
    }

    @Override
    public IHttpHeader getPrivateHeader() {
        return privateHeader;
    }

    public static HeaderMananger getInstance(){
        return HeaderManangerHolder.INSTANCE;
    }

}
