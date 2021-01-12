package com.kglab.lmcp.global.handle.exception.result;

import com.kglab.lmcp.constant.StatusCode;
import lombok.Data;

/*
 *
 *  * @param null
 * @author sc
 * @return 
 * @date 2021/1/12
 */
public class SuccessResultMessage extends ResultVoMessage {
    public SuccessResultMessage(String errorMsg, Object data) {
        super(StatusCode.SUCCESS, errorMsg, data);
    }

    public SuccessResultMessage(String errorMsg) {
        this( errorMsg, null);
    }
}