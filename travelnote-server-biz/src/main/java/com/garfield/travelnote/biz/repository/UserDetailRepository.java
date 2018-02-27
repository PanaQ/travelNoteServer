package com.garfield.travelnote.biz.repository;

import com.garfield.travelnote.biz.shiro.bean.UserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 17:25
 */
@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail,String> {

    List<UserDetail> findByUserId(Long userId);
}
