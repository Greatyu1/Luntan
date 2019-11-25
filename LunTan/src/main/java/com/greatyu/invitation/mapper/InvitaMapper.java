package com.greatyu.invitation.mapper;

import com.greatyu.invitation.model.Census;
import com.greatyu.invitation.model.Invita;
import com.greatyu.invitation.model.PingLun;
import com.greatyu.users.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("InvitaMapper")
public interface InvitaMapper {
    List<Invita> getInvitaList(@Param("invita") Invita invita);

    String getImgUrl(@Param("userCode") String userCode);

    String getNum(@Param("inviteCode") String inviteCode);

    String getPingLun(@Param("inviteCode") String inviteCode);

    int addInvite(@Param("invita") Invita invita);

    List<PingLun> getSee(@Param("pingLun") PingLun pingLun);


    PingLun getSees(@Param("inviteCode") String inviteCode,@Param("commentCode") String commentCode);

    int writePinglun(@Param("pingLun") PingLun pingLun);

    int updateInvite(@Param("invita") Invita invita);

    int deleteInvite(@Param("invitCode")String invitCode);

    User getUser(@Param("commentId") String commentId);

    Census getCensus(@Param("census") Census census);

    int addCensus(@Param("census") Census census);
}
