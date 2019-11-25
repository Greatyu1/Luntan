package com.greatyu.invitation.controller;


import com.greatyu.invitation.model.Census;
import com.greatyu.invitation.model.Invita;
import com.greatyu.invitation.model.PingLun;
import com.greatyu.invitation.service.InvitaService;
import com.greatyu.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/invitation")
@Api(description="帖子管理模块")
public class InvitaController {

    @Autowired
    private InvitaService invitaService;
    ResponseVo responseVo;
    @ApiOperation(value = "图片上传")
    @PostMapping("/imgUrl")
    @ResponseBody
    private ResponseVo addImgurl(@RequestParam("file") MultipartFile file){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.addImgurl(file);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "查询帖子")
    @PostMapping("/getInvitaList")
    @ResponseBody
    private ResponseVo getInvitaList(@RequestBody Invita invita){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.getInvitaList(invita);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "发帖")
    @PostMapping("/addInvite")
    @ResponseBody
    private ResponseVo addInvite(@RequestBody Invita invita){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.addInvite(invita);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "查询评论")
    @PostMapping("/getSee")
    @ResponseBody
    private ResponseVo getSee(@RequestBody PingLun pingLun){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.getSee(pingLun);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "写评论")
    @PostMapping("/writePinglun")
    @ResponseBody
    private ResponseVo writePinglun(@RequestBody PingLun pingLun){
        responseVo=new ResponseVo();
        try {
            System.out.println("=="+pingLun.getCommentText());
            responseVo=invitaService.writePinglun(pingLun);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }


    @ApiOperation(value = "修改帖子")
    @PostMapping("/updateInvite")
    @ResponseBody
    private ResponseVo updateInvite(@RequestBody Invita invita){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.updateInvite(invita);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "删帖")
    @PostMapping("/deleteInvite")
    @ResponseBody
    private ResponseVo deleteInvite(@RequestParam String invitCode){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.deleteInvite(invitCode);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "访问人数登记")
    @PostMapping("/addCensus")
    @ResponseBody
    private ResponseVo addCensus(@RequestBody Census census){
        responseVo=new ResponseVo();
        try {
            responseVo=invitaService.addCensus(census);
        }catch (Exception e){
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误！请联系后台");
            e.printStackTrace();
        }
        return responseVo;
    }
}
