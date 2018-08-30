package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
public interface BannerService {
    //查询所有
    List<Banner> queryAll();

    //添加
    void add(Banner banner);

    //修改状态
    void update(Banner banner);

    //删除
    void delete(Banner banner);

}
