package com.jing.utils;

import java.io.File;
import java.util.UUID;

public class UploadUtils {

	// 根据文件名，生成hash路径
	public static String getHashPath(String filename) {
		String hashCode = Integer.toHexString(filename.hashCode());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			if (i < 8 - hashCode.length()) {
				sb.append("/0");
			} else {
				sb.append("/" + hashCode.charAt(hashCode.length() + i - 8));
			}
		}
		return new String(sb);
	}

	// 把文件名前面的路径去掉("d\\xyz\\1.txt"→"1.txt")
	public static String getFilename(String filePath) {
		return filePath.substring(filePath.lastIndexOf("\\") + 1);
	}

	// 重载
	public static String getFilename(File file) {
		return getFilename(file.toString());
	}

	// 根据原文件名得到随机文件名
	public static String getUuidName(String filename) {
		int index = filename.lastIndexOf(".");
		if (index == -1) {
			// 没有扩展名
			return UUID.randomUUID().toString();
		} else {
			return UUID.randomUUID().toString() + filename.substring(index);
		}
	}

	// 获得文件扩展名
	public static String getExtension(String filename) {
		int index = filename.lastIndexOf(".");
		if (index == -1) {
			// 没有扩展名
			return "";
		} else {
			return filename.substring(index);
		}
	}

	// 根据上传文件路径，生成文件hash路径+随机文件名
	// ("d\\xyz\\1.txt"→"/0/2/c/9/2/b/3/3/3c6e4aa0-5665-4d92-a682-a0a1076f8edc.txt")
	public static String getPath(String filePath) {
		String filename = getFilename(filePath);
		return getHashPath(filename) + "/" + getUuidName(filename);
	}

	// 重载
	public static String getPath(File file) {
		return getPath(file.toString());
	}

}
