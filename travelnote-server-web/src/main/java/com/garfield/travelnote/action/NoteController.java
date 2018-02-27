package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.NoteService;
import com.garfield.travelnote.common.model.bo.BaseNoteBo;
import com.garfield.travelnote.common.model.bo.NoteBo;
import com.garfield.travelnote.common.model.bo.NoteQuery;
import com.garfield.travelnote.common.model.bo.UserBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.query.ListBean;
import com.zhexinit.ov.common.query.SortPagerQuery;
import com.zhexinit.ov.common.util.DateUitl;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 *  用户Controller
 **/
@RestController
@RequestMapping("note")
public class NoteController {

    private final static String serverUrl = "http://localhost:8080";

    @Autowired
    private NoteService noteService;

    /**
     * 发表游记
     */
    @PostMapping(value = "addNote")
    public ResponseBean<Void> addNote(@RequestBody @Valid RequestBean<BaseNoteBo> param,UserBo userBo) {
        if(userBo != null){
            Long userId = userBo.getId();
            BaseNoteBo noteBo = param.getParam();
            noteBo.setUserId(userId);
            noteService.addNote(noteBo);
        }
        return ResponseUtil.success();
    }

    /**
     * 删除游记
     */
    @PostMapping(value = "deleteNote")
    public ResponseBean<Void> deleteNote(@RequestBody @Valid RequestBean<Long> param,UserBo userBo) {
        if(userBo != null){
            Long userId = userBo.getId();
            Long id = param.getParam();
            noteService.deleteNote(id,userId);
        }

        return ResponseUtil.success();
    }

    /**
     * 修改游记
     */
    @PostMapping(value = "modifyNote")
    public ResponseBean<Void> modifyNote(@RequestBody @Valid RequestBean<BaseNoteBo> param,UserBo userBo) {
        if(userBo != null){
            Long userId = userBo.getId();
            BaseNoteBo noteBo = param.getParam();
            noteBo.setUserId(userId);
            noteService.modifyNote(noteBo);
        }

        return ResponseUtil.success();
    }

    /**
     * 根据id查看游记
     */
    @PostMapping(value = "getNoteById")
    public ResponseBean<NoteBo> getNoteById(@RequestBody RequestBean<Long> param){
        Long id = param.getParam();
        NoteBo noteBo = noteService.getNoteBoById(id);
        return ResponseUtil.success(noteBo);
    }

    /**
     * 上传图片
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "uploadPicture")
    public ResponseBean<String> uploadPicture(HttpServletRequest request) throws IOException {
        MultipartRequest multipartRequest = (MultipartRequest) request;
        MultipartFile file = multipartRequest.getFile("picture");
        String dirName = "/upload/pic/";
        String dirPath = this.getClass().getClassLoader().getResource("").getPath();
        String fileName = dirName+DateUitl.getLongTimestamp()+"_"+file.getOriginalFilename();
        File localFile = new File(dirPath+"/static"+fileName);
        file.transferTo(localFile);
        return ResponseUtil.success(serverUrl+fileName);
    }

    /**
     * 上传视频
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "uploadVideo")
    public ResponseBean<String> uploadVideo(HttpServletRequest request) throws IOException {
        MultipartRequest multipartRequest = (MultipartRequest) request;
        MultipartFile file = multipartRequest.getFile("video");
        String dirName = "/upload/video/";
        String dirPath = this.getClass().getClassLoader().getResource("").getPath();
        String fileName = dirName+DateUitl.getLongTimestamp()+"_"+file.getOriginalFilename();
        File localFile = new File(dirPath+"/static"+fileName);
        file.transferTo(localFile);
        return ResponseUtil.success(serverUrl+fileName);
    }

    /**
     * 根据userId获取游记列表(获取别人的)
     */
    @PostMapping("getNoteListByUserId")
    public ResponseBean<ListBean<BaseNoteBo>> getNoteListByUserId(@Valid @RequestBody RequestBean<SortPagerQuery<NoteQuery>> requestBean) {
        SortPagerQuery<NoteQuery> sortPagerQuery = requestBean.getParam();
        return ResponseUtil.success(noteService.getNoteListByUserId(sortPagerQuery));
    }

    /**
     * 获取自己的所有游记列表
     */
    @PostMapping("getNoteListByMine")
    public ResponseBean<ListBean<BaseNoteBo>> getNoteListByMine(@Valid @RequestBody RequestBean<SortPagerQuery> requestBean,UserBo userBo) {
        SortPagerQuery sortPagerQuery = requestBean.getParam();
        Long userId = null;
        if(userBo != null) {
            userId = userBo.getId();
        }
        return ResponseUtil.success(noteService.getNoteListByMine(sortPagerQuery,userId));
    }

    /**
     * 获取所有的游记列表
     */
    @PostMapping("getNoteList")
    public ResponseBean<ListBean<BaseNoteBo>> getNoteList(@Valid @RequestBody RequestBean<SortPagerQuery> requestBean) {
        SortPagerQuery sortPagerQuery = requestBean.getParam();
        noteService.getNoteList(sortPagerQuery);

        return ResponseUtil.success(noteService.getNoteList(sortPagerQuery));
    }

}
