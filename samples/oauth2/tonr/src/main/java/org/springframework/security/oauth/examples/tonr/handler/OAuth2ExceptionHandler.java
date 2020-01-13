package org.springframework.security.oauth.examples.tonr.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zwan on 12/18/19.
 */
@ControllerAdvice
public class OAuth2ExceptionHandler {

    @ExceptionHandler(UserDeniedAuthorizationException.class)
    protected ModelAndView handleConflict(UserDeniedAuthorizationException ex, WebRequest request) {
        System.out.println("*********1*************");
        String bodyOfResponse = "This should be application specific";
        return new ModelAndView("oauth_error");
    }

    @ExceptionHandler(value =OAuth2Exception.class)
    protected ResponseEntity handleConflict(OAuth2Exception ex, WebRequest request) {
        System.out.println("*********2*************");
        String bodyOfResponse = "This should be application specific";
        return ResponseEntity.ok(null);
    }
}
