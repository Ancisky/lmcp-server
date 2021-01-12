package com.kglab.lmcp.global.handle.exception.result;

import com.kglab.lmcp.constant.StatusCode;

public class RebutResultMessage extends ResultVoMessage {

    public RebutResultMessage(String errorMsg, Object data) {
        super(StatusCode.REBUT, errorMsg, data);
    }

    public RebutResultMessage(String errorMsg) {
        this( errorMsg, null);
    }
}