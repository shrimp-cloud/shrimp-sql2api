package com.wkclz.sql2api.manager.dao;

import com.wkclz.sql2api.manager.domain.vo.TableInfoPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchemaMapper {

    List<TableInfoPo> getTables(TableInfoPo po);

}
