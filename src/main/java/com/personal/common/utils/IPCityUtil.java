package com.personal.common.utils;

import org.apache.commons.lang3.StringUtils;

public class IPCityUtil {

	static {
		String ipDatPath = IPCityUtil.class.getClassLoader().getResource("").getPath() + "nocompile/ip.dat";
		// String ipDatPath1 = FileUtil.getAppPath(IPCityService.class) +
		// "/nocompile/ip.dat";
		IP.load(ipDatPath);
	}

	public static String getCityByIP(String ip) {
		if (StringUtils.isNotBlank(ip)) {
			String[] citys = IP.find(ip);
			String city = citys[2];
			if (StringUtils.isEmpty(city)) {
				city = citys[1];
			}
			if (StringUtils.isEmpty(city)) {
				city = citys[0];
			}
			if (city.equals("保留地址")) {
				city = "";
			}
			return city;
		} else {
			return "";
		}

	}
}
