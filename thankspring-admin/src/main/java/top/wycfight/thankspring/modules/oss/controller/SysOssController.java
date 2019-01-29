package top.wycfight.thankspring.modules.oss.controller;

import com.google.gson.Gson;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.thankspring.common.utils.ConfigConstant;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.common.validator.group.AliyunGroup;
import top.wycfight.thankspring.common.validator.group.QcloudGroup;
import top.wycfight.thankspring.common.validator.group.QiniuGroup;
import top.wycfight.thankspring.modules.oss.bean.SysOssEntity;
import top.wycfight.thankspring.modules.oss.cloud.CloudStorageConfig;
import top.wycfight.thankspring.modules.oss.cloud.QiniuCloudStorageService;
import top.wycfight.thankspring.modules.oss.service.SysOssService;
import top.wycfight.thankspring.modules.sys.service.SysConfigService;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文件上传（OSS）Controller
 * @create: 2019-01-21 09:28
 * @modified By:
 **/
@RestController
@RequestMapping("sys/oss")
public class SysOssController {

    @Autowired
    private SysOssService sysOssService;


    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;

    /**
     * 查询文件上传列表
     * @param params 参数条件
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public ResultData list(@RequestParam Map<String,Object> params) {
        PageUtils pageUtils = sysOssService.queryPage(params);
        return ResultData.ok().put("page",pageUtils);

    }

    /**
     * 保存配置
     * @param cloudStorageConfig 文件上传配置
     * @return
     */
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public ResultData saveConfig(@RequestBody CloudStorageConfig cloudStorageConfig) {
        // 校验类型
        ValidatorUtils.validateEntity(cloudStorageConfig);
        if(cloudStorageConfig.getType() == Constant.CloudService.QINIU.getValue()) {
            // 校验七牛数据
            ValidatorUtils.validateEntity(cloudStorageConfig, QiniuGroup.class);
        } else if(cloudStorageConfig.getType() == Constant.CloudService.ALIYUN.getValue()){
            //校验阿里云数据
            ValidatorUtils.validateEntity(cloudStorageConfig, AliyunGroup.class);
        } else if(cloudStorageConfig.getType() == Constant.CloudService.QCLOUD.getValue()){
            //校验腾讯云数据
            ValidatorUtils.validateEntity(cloudStorageConfig, QcloudGroup.class);
        }

        sysConfigService.updateValueByKey(KEY, new Gson().toJson(cloudStorageConfig));
        return ResultData.ok();

    }

    /**
     * 初始化配置
     * @return
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public ResultData config() {
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);
        return ResultData.ok().put("config",config);
    }





}
