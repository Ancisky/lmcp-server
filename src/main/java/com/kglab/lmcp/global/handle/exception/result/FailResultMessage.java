package com.kglab.lmcp.global.handle.exception.result;

import com.kglab.lmcp.constant.StatusCode;
import lombok.Data;

public class FailResultMessage extends ResultVoMessage {


    public FailResultMessage(String errorMsg, Object data) {
        super(StatusCode.FAIL, errorMsg, data);
    }

    public FailResultMessage(String errorMsg) {
        this( errorMsg, null);
    }
}