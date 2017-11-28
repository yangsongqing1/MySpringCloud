package ysq.com.app.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Describle: 通用mapper, 有基本的单表增删改查功能
 * @Author: yangsongqing
 * @Date: 2017/11/28 10:59
 */
public interface SuperMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
