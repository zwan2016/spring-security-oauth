package org.springframework.security.oauth.examples.tonr.mvc;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.NestedServletException;

import javax.annotation.PostConstruct;

/**
 * Created by zwan on 12/18/19.
 */
@ControllerAdvice(basePackageClasses = SparklrController.class)
//@EnableWebMvc
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class OAuth2ExceptionAdvice {

    static {
        System.out.println("*********-1*************");
    }

    @PostConstruct
    public void init(){
        System.out.println("*********0*************");
    }

    @ExceptionHandler(UserDeniedAuthorizationException.class)
    protected ResponseEntity<UserDeniedAuthorizationException> handleConflict(UserDeniedAuthorizationException ex, WebRequest request) {
        System.out.println("*********1*************");
        String bodyOfResponse = "This should be application specific";
        return ResponseEntity.ok(ex);
    }

    @ExceptionHandler(value =OAuth2Exception.class)
    protected ResponseEntity<OAuth2Exception> handleConflict(OAuth2Exception ex, WebRequest request) {
        System.out.println("*********2*************");
        String bodyOfResponse = "This should be application specific";
        return ResponseEntity.ok(ex);
    }

    @ExceptionHandler(NestedServletException.class)
    protected ResponseEntity<NestedServletException> handleConflict(NestedServletException ex) {
        System.out.println("*********3*************");
        String bodyOfResponse = "This should be application specific";
        return ResponseEntity.ok(ex);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Exception> handleConflict(Exception ex) {
        System.out.println("*********4*************");
        String bodyOfResponse = "This should be application specific";
        return ResponseEntity.ok(ex);
    }
}
