package com.garfield.travelnote.biz.repository;

import com.garfield.travelnote.biz.realm.UserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author treezhu
 * @version 1.0
 * @date 2018/2/25 17:25
 */
@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail,String> {
}
