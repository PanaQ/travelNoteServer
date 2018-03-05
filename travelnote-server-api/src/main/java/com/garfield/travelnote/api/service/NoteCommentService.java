package com.garfield.travelnote.api.service;

import com.garfield.travelnote.api.model.bo.AddNoteCommentBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NoteCommentService {

    /**
     * 发表留言
     *
     * @param param
     * @return
     */
    @POST("/noteComment/addNoteComment")
    Observable<ResponseBean<Void>> addFollow(@Body RequestBean<AddNoteCommentBo> param);

}
