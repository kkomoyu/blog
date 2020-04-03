package com.lwm.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.lwm.common.utils.http.HttpUtils;
import com.lwm.framework.config.SystemConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: guya
 * @Date: 2020/3/20 09:03
 * @Description: 获取地址类
 */
@Slf4j
public class AddressUtils {

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip) {
        String address = "XX XX";
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        if (SystemConfig.isAddressEnabled()) {
            String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
            if (StringUtils.isEmpty(rspStr)) {
                log.error("获取地理位置异常 {}", ip);
                return address;
            }
            JSONObject obj = JSONObject.parseObject(rspStr);
            JSONObject data = obj.getObject("data", JSONObject.class);
            String region = data.getString("region");
            String city = data.getString("city");
            address = region + " " + city;
        }
        return address;
    }
}
