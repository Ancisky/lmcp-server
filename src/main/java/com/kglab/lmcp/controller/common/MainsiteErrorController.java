package com.kglab.lmcp.controller.common;

import com.kglab.lmcp.controller.BaseAction;
import com.kglab.lmcp.global.handle.exception.result.ResultVoMessage;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainsiteErrorController extends BaseAction implements ErrorController {

	private static final String ERROR_PATH = "/**/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError() {
		throw new ResultVoMessage(FAIL, "此路不通");
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}