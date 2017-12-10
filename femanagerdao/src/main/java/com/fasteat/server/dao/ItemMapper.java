package com.fasteat.server.dao;

import com.fasteat.server.pojo.Item;
import com.fasteat.server.pojo.ItemExample;
import com.fasteat.server.pojo.ItemKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {

    List<Item> selectItemfromOId(Integer oid);

    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(ItemKey key);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(ItemKey key);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}