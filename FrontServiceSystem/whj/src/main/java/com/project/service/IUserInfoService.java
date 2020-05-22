package com.project.service;


import com.project.entity.FrontUserInfoEntity;

import java.util.Optional;

public interface IUserInfoService {

    Optional<FrontUserInfoEntity> findByIdUserinfo(int id);
}
