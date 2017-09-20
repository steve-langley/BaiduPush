package com.baidu.yun.push.model;

//import net.sf.json.JsonArray;
import io.vertx.core.json.JsonArray;

import com.baidu.yun.core.annotation.HttpParamKeyName;
import com.baidu.yun.core.annotation.RangeRestrict;
import com.baidu.yun.core.annotation.R;
import com.baidu.yun.push.constants.BaiduPushConstants;

public class DeleteDevicesFromTagRequest extends PushRequest{

	@HttpParamKeyName(name=BaiduPushConstants.TAG_NAME, param=R.REQUIRE)
	@RangeRestrict(minLength=1, maxLength=128)
	private String tagName = null;
	
    @HttpParamKeyName(name=BaiduPushConstants.CHANNEL_IDS, param=R.REQUIRE)
    private String channelIds = null;
    
    // get
    public String getTagName () {
    	return tagName;
    }
    public String getChannelIdsString () {
    	return channelIds;
    }
    public String[] getChannelIdsArray () {
    	JsonArray jsonChannelIds = new  JsonArray(channelIds);
    	return (String[]) jsonChannelIds.getList().toArray();
    }
    // set
    public void setTagName (String tagName) {
    	this.tagName = tagName;
    }
    public void setChannelIds (String[] channelIds) {
    	JsonArray tmpChannelIds = new JsonArray();
    	for (int i = 0; i < channelIds.length; i++){
    		tmpChannelIds.add(channelIds[i]);
    	}
    	this.channelIds = tmpChannelIds.toString();
    }
    // add
    public DeleteDevicesFromTagRequest addTagName (String tagName) {
    	this.tagName = tagName;
    	return this;
    }
    public DeleteDevicesFromTagRequest addChannelIds (String[] channelIds) {
    	JsonArray tmpChannelIds = new JsonArray();
    	for (int i = 0; i < channelIds.length; i++){
    		tmpChannelIds.add(channelIds[i]);
    	}
    	this.channelIds = tmpChannelIds.toString();
    	return this;
    }
    public DeleteDevicesFromTagRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public DeleteDevicesFromTagRequest addExpires(Long requestTimeOut) {
    	this.expires = requestTimeOut;
		return this;
	}
}

