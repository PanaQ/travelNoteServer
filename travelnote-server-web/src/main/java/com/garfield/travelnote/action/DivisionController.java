package com.garfield.travelnote.action;

import com.garfield.travelnote.biz.service.impl.DivisionService;
import com.garfield.travelnote.common.model.bo.DivisionBo;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Jingly on 2017/11/22.
 */
@RequestMapping("division")
@Controller
@ResponseBody
class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping("selectProvinces")
    public ResponseBean<List<DivisionBo>> selectProvinces() {

        List<DivisionBo> divisionBos = divisionService.selectProvinces();
        return ResponseUtil.success(divisionBos);
    }

    @GetMapping("selectByParentCode")
    public ResponseBean<List<DivisionBo>> selectByParentCode(@RequestParam("parentCode") String parentCode) {
        List<DivisionBo> divisionBos = divisionService.selectByParentCode(parentCode);
        return ResponseUtil.success(divisionBos);
    }

    @GetMapping("selectByCode")
    public ResponseBean<DivisionBo> selectByCode(@RequestParam("code") String code) {
        DivisionBo divisionBo = divisionService.selectByCode(code);
        return ResponseUtil.success(divisionBo);
    }

}