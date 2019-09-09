package com.ccms.mapper;


import com.ccms.entity.EcVoucherDetail;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface EcVoucherDetailMapper extends Mapper<EcVoucherDetail> {

    Map<String,Object> selectSimpleColumnByCode(String code);
}