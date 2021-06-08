package dao;

import dto.Mania;

public interface AnneManiaDao {
	Mania selectOne(String id) throws Exception;
	Mania exist(String id, String pwd)throws Exception;
}
