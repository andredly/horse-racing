package com.charniauski.training.horsesrace.web.corrector_dto;

/**
 * Created by ivc4 on 12.12.2016.
 */
public interface CorrectorDTOForRole<D,R> {

    D getDTOForRole(D entity, R role);

    R getRole();

}
