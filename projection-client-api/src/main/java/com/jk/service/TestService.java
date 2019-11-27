package com.jk.service;

import com.jk.model.Fufei;

import java.util.List;
import java.util.Map;

public interface TestService {

    Map<String, Object> queryCars(Integer page, Integer rows);

    List<Fufei> findFufei();
}
