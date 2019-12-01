package cn.dsh.sessionandcookietime.mapper;

import cn.dsh.sessionandcookietime.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AcconuntMapper {

    @Select("select * from account where number = #{number} and password = #{password}")
    public Account findAccount(Account account);

    @Insert("insert into account values(#{username},#{number},#{password})")
    public void insertOne(Account account);
}
