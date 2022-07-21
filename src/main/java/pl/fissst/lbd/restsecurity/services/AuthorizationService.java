package pl.fissst.lbd.restsecurity.services;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    public Boolean isAuthorized(String url,@Nullable String role){
        Boolean isAuthorized = false;
        if(url.contains("/api/student") && (role!=null && (role.equals("STUDENT_ROLE") || role.equals("TEACHER_ROLE")))){
            isAuthorized=true;
        }
        else if(url.contains("/api/teacher") && (role!=null && role.equals("TEACHER_ROLE"))){
            isAuthorized=true;
        }
        return isAuthorized;
    }

}
