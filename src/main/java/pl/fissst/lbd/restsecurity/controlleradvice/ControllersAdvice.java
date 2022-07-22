package pl.fissst.lbd.restsecurity.controlleradvice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllersAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            NoSuchElementException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class )
    public ResponseEntity<String> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(
                ex.getName() + " should be of type " + ex.getRequiredType().getName(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<String> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(
                ex.getParameterName() + " parameter is missing",
                HttpStatus.BAD_REQUEST);
    }

}
