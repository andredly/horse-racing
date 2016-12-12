package com.charniauski.training.horsesrace.web.corrector_dto;

import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.localthread.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by ivc4 on 12.12.2016.
 */
public abstract class AbstractCorrector<D,R> implements CorrectorDTOForRole<D,R>{

    @Override
    public D getDTOForRole(D entity, R role) {
        return entity;
    }

    public R getRole(){
        UserDetails loggedUserDetails = SecurityContextHolder.getLoggedUserDetails();
        if (loggedUserDetails==null) {return null;}
        Status status = null;
        for (GrantedAuthority grantedAuthority : loggedUserDetails.getAuthorities()) {
            status =Status.valueOf(grantedAuthority.getAuthority());
        }
        return (R)status;
    }

}
