package com.charniauski.training.horsesrace.web.corrector_dto;

import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.charniauski.training.horsesrace.services.localthread.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by ivc4 on 12.12.2016.
 */
public interface CorrectorDTOForRole<D,R> {

    D getDTOForRole(D entity, R role);

    R getRole();

}
