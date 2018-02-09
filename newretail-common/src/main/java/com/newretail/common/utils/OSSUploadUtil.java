package com.newretail.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.GenericRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;

/**
 * 
 * @ClassName: OSSUploadUtil
 * @Description: 阿里云OSS文件上传工具类
 * @author AggerChen
 * @date 2016年11月3日 下午12:03:24
 */
public class OSSUploadUtil {
	String endpoint = null;     
	String bucketName= null;                                                      
	String accessKeyId= null;
	String accessKeySecret= null;
	OSSConfig ossConfig =null;
/*	static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";     
	static String bucketName = "newretail-private";                                                      
	static String accessKeyId = "LTAIcS2xXiHBRnFI";
	static String accessKeySecret ="0v4s2u977ZqGW3LqERCtFC2fhVRgbE";*/
	private static OSSUploadUtil instance= null;
	/**
	 * 返回实例化参数
	 * @return
	 */
	public static OSSUploadUtil getInstance(boolean isPublic) {
		if(instance==null) {
			return new OSSUploadUtil(isPublic);
		}
		return instance;
	}

	public OSSUploadUtil(boolean isPublic){
		if(isPublic==true) {
			ossConfig = new OSSConfig(true);
		}else {
			
			ossConfig = new OSSConfig();
	
		}
		 endpoint = ossConfig.getEndpoint();     
		 bucketName= ossConfig.getBucketName();                                                      
		 accessKeyId= ossConfig.getAccessKeyId();
		 accessKeySecret= ossConfig.getAccessKeySecret();
		 System.out.println("endpoint:"+endpoint+"bucketName:"+bucketName);
		 System.out.println("accessKeyId:"+accessKeyId+"accessKeySecret:"+accessKeySecret);

	}
	/**
	 * 
	 * @param file
	 * @param folder
	 * @param remoteFile
	 * @return
	 */
	public  String uploadFile(File file,String folder,String remoteFile){
		String fileName = folder+remoteFile;	//文件名，根据UUID来
		return putObject(file,remoteFile.substring(remoteFile.lastIndexOf("."), remoteFile.length()),fileName);
	}
	
		   

	/**
	 * 
	 * @MethodName: updateFile
	 * @Description: 更新文件:只更新内容，不更新文件名和文件地址。
	 * 		(因为地址没变，可能存在浏览器原数据缓存，不能及时加载新数据，例如图片更新，请注意)
	 * @param file
	 * @param fileType
	 * @param oldUrl
	 * @return String
	 */
	public  String updateFile(File file,String fileType,String oldUrl){
		String fileName = getFileName(oldUrl);
		if(fileName==null) return null;
		return putObject(file,fileType,fileName);
	}
	
/*	*//**
	 * 
	 * @MethodName: replaceFile
	 * @Description: 替换文件:删除原文件并上传新文件，文件名和地址同时替换
	 * 		解决原数据缓存问题，只要更新了地址，就能重新加载数据)
	 * @param file
	 * @param fileType 文件后缀
	 * @param oldUrl 需要删除的文件地址
	 * @return String 文件地址
	 *//*
	public static String replaceFile(File file,String fileType,String oldUrl){
		boolean flag = deleteFile(oldUrl);		//先删除原文件
		if(!flag){
			//更改文件的过期时间，让他到期自动删除。
		}
		return uploadFile(file, fileType);
	}*/
	
	/**
	 * 
	 * @MethodName: deleteFile
	 * @Description: 单文件删除
	 * @param fileUrl 需要删除的文件url
	 * @return boolean 是否删除成功
	 */
	public  boolean deleteFile(String fileUrl){
		String bucketName = OSSUploadUtil.getBucketName(fileUrl);		//根据url获取bucketName
		String fileName = OSSUploadUtil.getFileName(fileUrl);			//根据url获取fileName
		if(bucketName==null||fileName==null) return false;
		OSSClient ossClient = null; 
		try {
			ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
			GenericRequest request = new DeleteObjectsRequest(bucketName).withKey(fileName);
			ossClient.deleteObject(request);
		} catch (Exception oe) {
            oe.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
		return true;
	}
	
	/**
	 * 
	 * @MethodName: batchDeleteFiles
	 * @Description: 批量文件删除(较快)：适用于相同endPoint和BucketName
	 * @param fileUrls 需要删除的文件url集合
	 * @return int 成功删除的个数
	 */
	public  int deleteFile(List<String> fileUrls){
		int deleteCount = 0;	//成功删除的个数
		String bucketName = OSSUploadUtil.getBucketName(fileUrls.get(0));		//根据url获取bucketName
		List<String> fileNames = OSSUploadUtil.getFileName(fileUrls);			//根据url获取fileName
		if(bucketName==null||fileNames.size()<=0) return 0;
		OSSClient ossClient = null; 
		try {
			ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
			DeleteObjectsRequest request = new DeleteObjectsRequest(bucketName).withKeys(fileNames);
			DeleteObjectsResult result = ossClient.deleteObjects(request);
			deleteCount = result.getDeletedObjects().size();
		} catch (OSSException oe) {
            oe.printStackTrace();
            throw new RuntimeException("OSS服务异常:", oe);
        } catch (ClientException ce) {
        	ce.printStackTrace();
			throw new RuntimeException("OSS客户端异常:", ce);
        } finally {
            ossClient.shutdown();
        }
		return deleteCount;
		
	}
	
	/**
	 * 
	 * @MethodName: batchDeleteFiles
	 * @Description: 批量文件删除(较慢)：适用于不同endPoint和BucketName
	 * @param fileUrls 需要删除的文件url集合
	 * @return int 成功删除的个数
	 */
	public  int deleteFiles(List<String> fileUrls){
		int count = 0;
		for (String url : fileUrls) {
			if(deleteFile(url)){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @param file
	 * @param folder
	 * @param fileType
	 * @param fileName
	 * @return
	 */
	private  String putObject(File file,String fileType,String fileName){
		   String url = null;		//默认null
		   OSSClient ossClient = null;  
		try {
			ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
			InputStream input = new FileInputStream(file);  
			ObjectMetadata meta = new ObjectMetadata();				// 创建上传Object的Metadata
			meta.setContentType(OSSUploadUtil.contentType(fileType));		// 设置上传内容类型
			meta.setCacheControl("no-cache");					// 被下载时网页的缓存行为  
			PutObjectRequest request = new PutObjectRequest(bucketName, fileName,input,meta);			//创建上传请求
			ossClient.putObject(request); 
			url = "upload succeed file:"+fileName;
			//上传成功再返回的文件路径
		} catch (OSSException oe) {
            oe.printStackTrace();
            return null;
        } catch (ClientException ce) {
        	ce.printStackTrace();
        	return null;
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        	return null;
		} finally {
            ossClient.shutdown();
        }
		return url;
	}
	
	/**
	 * 
	 * @MethodName: contentType
	 * @Description: 获取文件类型
	 * @param FileType
	 * @return String
	 */
	private static String contentType(String fileType){
		fileType = fileType.toLowerCase();
		String contentType = "";
		switch (fileType) {
		case "bmp":	contentType = "image/bmp";
					break;
		case "gif":	contentType = "image/gif";
					break;
		case "png":	
		case "jpeg":	
		case "jpg":	contentType = "image/jpeg";
					break;
		case "html":contentType = "text/html";
					break;
		case "txt":	contentType = "text/plain";
					break;
		case "vsd":	contentType = "application/vnd.visio";
					break;
		case "ppt":	
		case "pptx":contentType = "application/vnd.ms-powerpoint";
					break;
		case "doc":	
		case "docx":contentType = "application/msword";
					break;
		case "xml":contentType = "text/xml";
					break;
		case "mp4":contentType = "video/mp4";
					break;
		default: contentType = "application/octet-stream";
					break;
		}
		return contentType;
     }  
	
	/**
	 * 
	 * @MethodName: getBucketName
	 * @Description: 根据url获取bucketName
	 * @param fileUrl 文件url
	 * @return String bucketName
	 */
	private static String getBucketName(String fileUrl){
		String http = "http://";
		String https = "https://";
		int httpIndex = fileUrl.indexOf(http);
		int httpsIndex = fileUrl.indexOf(https);
		int startIndex  = 0;
		if(httpIndex==-1){
			if(httpsIndex==-1){
				return null;
			}else{
				startIndex = httpsIndex+https.length();
			}
		}else{
			startIndex = httpIndex+http.length();
		}
		int endIndex = fileUrl.indexOf(".oss-"); 
		return fileUrl.substring(startIndex, endIndex);
	}
	
	/**
	 * 
	 * @MethodName: getFileName
	 * @Description: 根据url获取fileName
	 * @param fileUrl 文件url
	 * @return String fileName
	 */
	private static String getFileName(String fileUrl){
		String str = "aliyuncs.com/";
		int beginIndex = fileUrl.indexOf(str);
		if(beginIndex==-1) return null;
		return fileUrl.substring(beginIndex+str.length());
	}
	
	/**
	 * 
	 * @MethodName: getFileName
	 * @Description: 根据url获取fileNames集合
	 * @param fileUrl 文件url
	 * @return List<String>  fileName集合
	 */
	private static List<String> getFileName(List<String> fileUrls){
		List<String> names = new ArrayList<>();
		for (String url : fileUrls) {
			names.add(getFileName(url));
		}
		return names;
	}
}

