package com.greatyu.invitation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greatyu.invitation.mapper.InvitaMapper;
import com.greatyu.invitation.model.BaseList;
import com.greatyu.invitation.model.Census;
import com.greatyu.invitation.model.Invita;
import com.greatyu.invitation.model.PingLun;
import com.greatyu.invitation.service.InvitaService;
import com.greatyu.users.model.User;
import com.greatyu.utils.BaseTree;
import com.greatyu.utils.ErrorCode;
import com.greatyu.utils.ResponseVo;
import com.greatyu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class InvitaServiceImpl implements InvitaService {

    @Autowired
    private InvitaMapper invitaMapper;
    ResponseVo responseVo;

    /**
     * 图片上传
     * @param file 图片路径
     * @return 后台图片地址
     */
    @Override
    public ResponseVo addImgurl(MultipartFile file) {
        responseVo=ResponseVo.buildSuccessInstance("");
        if (file==null){
            responseVo=ResponseVo.buildFailInstance(ErrorCode.COMMON_ERROR,"请选择图片");
            return responseVo;
        }

        String type=null;
        String originalFilename=file.getOriginalFilename();
        System.out.println("文件的原名称"+originalFilename);

        type=originalFilename.lastIndexOf(".")!=-1?originalFilename.substring(originalFilename.lastIndexOf(".")+1,originalFilename.length()):null;
        System.out.println("type:"+type);
        if (type==null){
            responseVo.setSuccess(false);
            responseVo.setResponseCode(ErrorCode.FAIL);
            responseVo.setResponseMsg("文件类型不为空，请检查文件类型！");
            return responseVo;

        }
        if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())||"SVG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())){
//先获取rescures 文件路径
            try {
                String classpath= ResourceUtils.getURL("classpath:").getPath();
                classpath=classpath.substring(1,classpath.length());
                String imgPath=classpath+"static/";
                String finalFile=String.valueOf(System.currentTimeMillis())+"."+type;
                String path=imgPath+finalFile;
                System.out.println("存放图片的路径"+path);

                File file1 = new File(path);

                if (!file1.exists()){
                    file1.mkdirs();
                }
                //原始文件写到新的文件
                file.transferTo(file1);
                String url="http://127.0.0.1:9999"+path.substring(path.lastIndexOf("/"),path.length());
                responseVo.setData(url);
                return responseVo;
            } catch (Exception e) {
                responseVo.setSuccess(false);
                responseVo.setResponseCode(ErrorCode.FAIL);
                responseVo.setResponseMsg("上传失败！");
                e.printStackTrace();
                return responseVo;

            }
        }else {
            responseVo.setSuccess(false);
            responseVo.setResponseCode(ErrorCode.FAIL);
            responseVo.setResponseMsg("请上传指定图片格式（GIF,PNG,JPG,JPEG,SVG）！");
            return responseVo;
        }
    }

    /**
     * 获取帖子
     * @param invita
     * @return
     */
    @Override
    public ResponseVo getInvitaList(Invita invita) {
        responseVo=ResponseVo.buildSuccessInstance("");
        PageHelper.startPage(invita.getPageNum(),invita.getPageSize());
        List<Invita> listInvita=invitaMapper.getInvitaList(invita);
        System.out.println("====="+listInvita);
        for (Invita invita1:listInvita){
            String url=invitaMapper.getImgUrl(invita1.getUserCode());
            invita1.setImgUrl(url);
            String num=invitaMapper.getNum(invita1.getInviteCode());
            invita1.setNum(Integer.parseInt(num));
            String PingLun=invitaMapper.getPingLun(invita1.getInviteCode());
            invita1.setPinglunNum(Integer.parseInt(PingLun));
        }
        PageInfo pageInfo=new PageInfo(listInvita);
        responseVo.setData(pageInfo);
        return responseVo;
    }

    /**
     * 新增帖子
     * @param invita
     * @return
     */
    @Override
    public ResponseVo addInvite(Invita invita) {
        invita.setInviteCode(Utils.getUUID());
        int row=invitaMapper.addInvite(invita);
        responseVo=ResponseVo.buildSuccessInstance("");
        if (row==0){
            responseVo=ResponseVo.buildFailInstance();
        }
        return responseVo;
    }

    /**
     * 查看评论
     * @param pingLun
     * @return
     */
    @Override
    public ResponseVo getSee(PingLun pingLun) {
        List<PingLun> pingLuns=invitaMapper.getSee(pingLun);
        for (PingLun p:pingLuns){
            User user=invitaMapper.getUser(p.getCommentId());
            p.setImgUrl(user.getUserUrl());
            p.setUserName(user.getUserName());
        }
        BaseTree<PingLun> baseTree=new BaseTree<>();
        getList(baseTree,pingLuns,"0");
        responseVo=ResponseVo.buildSuccessInstance(baseTree.getChildNodes());
        return responseVo;
    }

    /**
     * 写评论
     * @param pingLun
     * @return
     */
    @Override
    public ResponseVo writePinglun(PingLun pingLun) {
        pingLun.setCommentCode(Utils.getUUID());
        int row=invitaMapper.writePinglun(pingLun);
        if (row==0){
            responseVo=ResponseVo.buildFailInstance();
            return responseVo;
        }
        responseVo=ResponseVo.buildSuccessInstance("");
        return responseVo;
    }

    /**
     * 修改帖子
     * @param invita
     * @return
     */
    @Override
    public ResponseVo updateInvite(Invita invita) {
        int row=invitaMapper.updateInvite(invita);
        responseVo=ResponseVo.buildSuccessInstance("");
        if (row==0){
            responseVo=ResponseVo.buildFailInstance();
        }
        return responseVo;
    }

    /**
     * 删帖
     * @param invitCode
     * @return
     */
    @Override
    public ResponseVo deleteInvite(String invitCode) {
        int row=invitaMapper.deleteInvite(invitCode);
        if (row==0){
            return ResponseVo.buildFailInstance();
        }
        return ResponseVo.buildSuccessInstance("");
    }

    /**
     * 访问人数登记
     * @param census
     * @return
     */
    @Override
    public ResponseVo addCensus(Census census) {
        Census isCensus=invitaMapper.getCensus(census);
        if (isCensus!=null){
            return ResponseVo.buildFailInstance(ErrorCode.COMMON_ERROR,"已经存在");
        }
        int row=invitaMapper.addCensus(census);
        if (row==0){
            return ResponseVo.buildFailInstance();
        }
        return ResponseVo.buildSuccessInstance("");
    }


    /**
     * 递归
     * @param baseTree
     * @param list
     * @param s
     */
    public void getList(BaseTree baseTree,List<PingLun> list,String s){
        Iterator<PingLun> iterator=list.iterator();
        while (iterator.hasNext()){
            PingLun pingLun=iterator.next();
            if (pingLun.getCommentCode().equals(s)){
              menuToNodeTree(baseTree,pingLun);
            }else if (pingLun.getReplyId().equals(s)){

                BaseTree<PingLun> childtree = new BaseTree();

                menuToNodeTree(childtree,pingLun);

                if (null!=childtree.getNodeid()){

                    if (baseTree.getChildNodes()==null){
                        List<PingLun> list1=new ArrayList<>();
                        baseTree.setChildNodes(list1);
                    }
                    baseTree.getChildNodes().add(childtree);
                }
                getList(childtree,list,pingLun.getCommentCode());
            }
        }
    }

    /**
     * 递归树形
     * @param baseTree
     * @param pingLun
     */
    private void menuToNodeTree(BaseTree baseTree,PingLun pingLun) {
        baseTree.setNodeName(pingLun.getInviteCode());
        baseTree.setNodeid(pingLun.getCommentCode());
        baseTree.setAttribute(pingLun);
    }
}

