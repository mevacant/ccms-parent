package com.ccms.mapper;

import com.ccms.entity.EcPageTempleteProperty;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EcPageTempletePropertyMapper extends Mapper<EcPageTempleteProperty> {

    List<EcPageTempleteProperty> selelctEnablePageTempletePropertyList();
}