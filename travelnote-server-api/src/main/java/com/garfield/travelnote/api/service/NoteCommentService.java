package com.garfield.travelnote.api.service;

import com.garfield.travelnote.common.model.bo.AddNoteCommentBo;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface NoteCommentService {

    /**
     * 添加留言
     *
     * @param param
     * @return
     */
    @POST("/noteComment/addNoteComment")
    Observable<ResponseBean<Void>> addFollow(@Body RequestBean<AddNoteCommentBo> param);

}
