package com.ccms.service;


import com.ccms.entity.EcVoucherDetail;
import com.ccms.entity.EcVoucherMain;
import com.ccms.exception.BizException;
import com.ccms.vo.AppRspObject;
import com.ccms.vo.ErrorVo;

public interface VoucherService {


    AppRspObject checkCodeValid(String code);

    String getLockKey(String code);

    AppRspObject checkCodeStatus(String code, Long userId, EcVoucherMain vm, EcVoucherDetail vcd);

    AppRspObject sendWelfare(String code, Long userId, EcVoucherMain vm, EcVoucherDetail vcd) throws BizException;

    int saveLogByCodeDetail(Long mainId, String code, Long userId, ErrorVo error);
}
