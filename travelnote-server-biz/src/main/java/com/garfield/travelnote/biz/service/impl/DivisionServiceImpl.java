package com.garfield.travelnote.biz.service.impl;

import com.garfield.travelnote.common.model.bo.DivisionBo;
import com.garfield.travelnote.common.util.DivisionConverter;
import com.garfield.travelnote.dal.domain.DivisionDo;
import com.garfield.travelnote.dal.mapper.DivisionDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionDoMapper divisionDoMapper;

    /*
   * 拷贝到文本，去除非法空格
   * */
//    public static void main(String[] args) {
//        try {
//            File file = new File("F:\\ad.txt");
//            List list = FileUtils.readLines(file);
//            Map<String, String> map = new HashMap<>();
//            for (Object o : list) {
//                String line = (String) o;
//                String[] split = StringUtils.split(StringUtils.trim(line), " ");
//                int level = 1;
//                String parentCode = "";
//                String code = split[0];
//                String province = code.substring(0, 2);
//                String city = code.substring(2, 4);
//                String district = code.substring(4);
//                if (city.equals("00")) {//市区县都是0，表示省
//                    level = 1;
//                    parentCode = "0";
//                } else {//市不是0
//                    if (district.equals("00")) {//区县是0，表示市级
//                        level = 2;
//                        parentCode = province + "0000";
//                    } else {//区县不是0，表示区县级
//                        level = 3;
//                        parentCode = province + city + "00";
//                    }
//                }
//                System.out.println("INSERT INTO `administrative_division`(code,name,level,parent_code) VALUES ('" + code + "', '" + split[1] + "', '" + level + "','" + parentCode + "');");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public List<DivisionBo> selectProvinces() {
        Example example = new Example(DivisionDo.class);
        example.createCriteria().andEqualTo("level", 1);
        List<DivisionDo> administrativeDivisionDos = divisionDoMapper.selectByExample(example);
        return DivisionConverter.dosToBos(administrativeDivisionDos);
    }

    @Override
    public List<DivisionBo> selectByParentCode(String parentCode) {
        Example example = new Example(DivisionDo.class);
        example.createCriteria().andEqualTo("parentCode", parentCode);
        List<DivisionDo> administrativeDivisionDos = divisionDoMapper.selectByExample(example);
        return DivisionConverter.dosToBos(administrativeDivisionDos);
    }

    @Override
    public DivisionBo selectByCode(String code) {
        DivisionDo _do = new DivisionDo();
        _do.setCode(code);
        DivisionDo one = divisionDoMapper.selectOne(_do);
        return DivisionConverter.doToBo(one);
    }

}
