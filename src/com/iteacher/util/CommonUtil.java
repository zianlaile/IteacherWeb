package com.iteacher.util;

import java.util.UUID;

public class CommonUtil {
	// 去"-"的uuid
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
