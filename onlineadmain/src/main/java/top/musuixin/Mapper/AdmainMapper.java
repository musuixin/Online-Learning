package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.AdmainPojo;

/**
 * @author musuixin
 * @date 2019-04-21 14:39
 */
@Repository
@Mapper
public interface AdmainMapper {
    @Insert("insert  into admain(`admainName`, `admainEmail`, `admainPwd`) values (#{admainName} ,#{admainEmail} ,#{admainPwd}  )")
    void register(AdmainPojo admainPojo);

    @Select("select admainEmail from admain where admainEmail=#{admainEmail} ")
    AdmainPojo selectEmail(AdmainPojo admainPojo);

    @Select("select * from admain where admainEmail=#{admainEmail} and admainPwd=#{admainPwd}  ")
    AdmainPojo login(AdmainPojo admainPojo);
}
