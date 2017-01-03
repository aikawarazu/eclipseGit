package com.fh.daoTest;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TestExtend {
	public static void main(String[] args) {
		List<String> dirs = getDirs("F:" + File.separator + "GetPathTest");
		for (String dir : dirs) {
			System.out.println(dir);
		}

	}

	public static List<String> getDirs(String path) {
		// get the path of file
		File file = new File(path);
		List<String> list = new LinkedList<String>();
		list.add(path);
		if (file.isDirectory()) {
			// if the path is directory ,then add all sub directories to the
			// list
			for (String subPath : file.list()) {
				String subAbsolutePath = path + File.separator + subPath;
				File file2 = new File(subAbsolutePath);
				if (!file2.isDirectory() || file2.list().length == 0) {
					list.add(subAbsolutePath);
					continue;
				}
				list.addAll(getDirs(path + File.separator + subPath));
			}
		}
		// return path list
		return list;
	}
}
