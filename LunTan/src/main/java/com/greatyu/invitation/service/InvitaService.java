package com.greatyu.invitation.service;

import com.greatyu.invitation.model.Census;
import com.greatyu.invitation.model.Invita;
import com.greatyu.invitation.model.PingLun;
import com.greatyu.utils.ResponseVo;
import org.springframework.web.multipart.MultipartFile;

public interface InvitaService {
    ResponseVo addImgurl(MultipartFile file);

    ResponseVo getInvitaList(Invita invita);

    ResponseVo addInvite(Invita invita);

    ResponseVo getSee(PingLun pingLun);

    ResponseVo writePinglun(PingLun pingLun);

    ResponseVo updateInvite(Invita invita);

    ResponseVo deleteInvite(String invitCode);

    ResponseVo addCensus(Census census);
}
