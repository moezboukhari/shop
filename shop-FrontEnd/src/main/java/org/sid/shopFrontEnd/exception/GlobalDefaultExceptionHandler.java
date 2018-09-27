package org.sid.shopFrontEnd.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
@ComponentScan({"org.sid.shopBackEnd","org.sid.shopFrontEnd"})
@ControllerAdvice
@Configuration
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle", "the pag is not constructed");
		model.addObject("errorDescription", "the pag you are looking for is not available now !");
		model.addObject("title", "404 error page");

		return model;
		}

}
