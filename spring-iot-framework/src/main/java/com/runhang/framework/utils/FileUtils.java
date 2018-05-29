package com.runhang.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @Description:
 * @author runhang
 * 2015年3月17日上午8:34:33
 *
 */
public class FileUtils {
	
	public static List<File> recursiveFiles(File file, List<File> fileList) {
		if (file.isFile()) {
			fileList.add(file);
		} else {
			File[] files = file.listFiles();
			for (File file2 : files) {
				recursiveFiles(file2, fileList);
			}
		}
		return fileList;
	}

	public static List<String> recursiveFilePaths(File file, List<String> filePathList) {
		if (file.isFile()) {
			filePathList.add(file.getPath());
		} else {
			File[] files = file.listFiles();
			for (File file2 : files) {
				recursiveFilePaths(file2, filePathList);
			}
		}
		return filePathList;
	}

	public static void copy(File src , File dest){
		if(!dest.exists()){
			if(!dest.getParentFile().exists()){
				dest.getParentFile().mkdirs();
			}
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			outChannel.transferFrom(inChannel, 0, inChannel.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			IOUtils.closeQuietly(outChannel);
			IOUtils.closeQuietly(inChannel);
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(fis);
		}
	}
	
	public static void moveTo(File src , File dest){
		if(src == null){
			throw new NullPointerException("src is null");
		}
		if(dest == null){
			throw new NullPointerException("dest is null");
		}
		boolean moved = src.renameTo(dest);
		
		if(!moved){
			copy(src, dest);
			src.delete();
		}
	}
	
	public static String getExtention(File file){
		String name = file.getName();
		return name.substring(name.lastIndexOf(".") + 1);
	}
	
	public static File newTempFile(){
		File tempFile = new File(getTempDirectoryPath() , System.currentTimeMillis() + "_" + UUID.randomUUID());
		return tempFile;
	}
	
	public static File newTempFile(String fileName){
		File tempFile = new File(getTempDirectoryPath() , fileName);
		return tempFile;
	}
	
	public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }
    
    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }
    
    public static String getHomeDirectory() {
        return System.getProperty("user.home");
    }

}
