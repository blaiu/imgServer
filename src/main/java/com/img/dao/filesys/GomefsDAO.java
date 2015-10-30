package com.img.dao.filesys;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.gome.gfs.Configure;
import com.gome.gfs.GomeFileService;

/**
 * gomefs数据读写
 * */
@Repository
public class GomefsDAO {
	GomeFileService gomefs ;
	@Value("${zk.addr}") private String zkAddr;
	
	public String write(byte[] data){
		return gomefs.writeBytes(data);
	}
	
	public byte[] read(String key){
		return gomefs.readBytes(key);
	}
	//初始化文件系统
	 @PostConstruct
	 private void initGomefs(){
			Configure con = new Configure();
			con.setServers(zkAddr);
//			gomefs = new GomeFileService(con);
//			gomefs = new GomeFileService();
			gomefs = GomeFileService.getGomeFsServer();
	 }
}
