package com.ccms.mapper;

import com.ccms.entity.EcsuserUserAddrs;
import tk.mybatis.mapper.common.Mapper;

public interface EcsuserUserAddrsMapper extends Mapper<EcsuserUserAddrs> {
    EcsuserUserAddrs selectAddrByCode(String code);
}