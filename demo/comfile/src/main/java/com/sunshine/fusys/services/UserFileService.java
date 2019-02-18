package com.sunshine.fusys.services;

import java.util.List;
import java.util.Map;

import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.fusys.mappers.UserFileDao;
import com.sunshine.fusys.models.Page;
import com.sunshine.fusys.models.UserFileDTO;
import com.sunshine.fusys.util.LogUtil;

/**
 * 
 * 创建人：fantasy <br>
 * 创建时间：2013-12-3 <br>
 * 功能描述： 用户上传下载文件操作DAO<br>
 */
@Service("userFileService")
public class UserFileService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserFileDao userFileDao;
	
	/**
	 * 保存上传文件
	 * 
	 * @param userFile
	 * @author fantasy
	 * @date 2013-12-3
	 */
	public void save(UserFileDTO userFile){
		userFileDao.save(userFile);
		logger.info(LogUtil.getLogStr("saveUserFile","200",userFile,"",""));
	}

	/**
	 * 查询用户上传文件列表
	 * 
	 * @param map
	 * @return List<UserFileDTO>
	 * @author fantasy
	 * @date 2013-12-3
	 */
	public List<UserFileDTO> find(Map<String, Object> map){
		logger.info(LogUtil.getLogStr("findUserFileList","200",map,"",""));
		return userFileDao.find(map);
	}
	
	/**
	 * 查询用户上传文件列表
	 * 
	 * @param map
	 * @return List<UserFileDTO>
	 * @author fantasy
	 * @date 2013-12-3
	 */
	public Page findPage(Map<String, Object> map){
		logger.info(LogUtil.getLogStr("findUserFileList","200",map,"",""));
		List<UserFileDTO> list = userFileDao.findPage(map);
		Page page = new Page(1, 15, 3, 3,list );
		return page;
	}
}