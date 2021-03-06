package com.zhiyin.device.dbs.service;

import com.zhiyin.dbs.module.common.service.IBaseService;
import com.zhiyin.dbs.module.common.service.IBaseService2;
import com.zhiyin.device.dbs.entity.DeviceFixInfo;

/**
 * Created by hg on 2016/10/8.
 */
public interface IDeviceFixInfoService extends IBaseService2<DeviceFixInfo> {
    DeviceFixInfo selectByUk(DeviceFixInfo fixInfo);

    DeviceFixInfo selectByKey(DeviceFixInfo fixInfo);
}
