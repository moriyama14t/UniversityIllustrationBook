package jp.uib.admin.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.uib.admin.model.University;

@Mapper
public interface UniversityRepository {

    @Select("SELECT id, name, furikana FROM university")
    List<University> findAll();

    @Select("SELECT id, name, furikana FROM university WHERE id =#{id}")
    Optional<University> findById(Integer id);

    @Options(useGeneratedKeys = true) // 自動で連番のidを取得する
    @Insert("INSERT INTO  university(name, furikana) VALUES( #{name},#{furikana})")
    Integer create(University university);

    @Delete("DELETE FROM university WHERE id= #{id}")
    void delete(int id);

    @Update("  UPDATE university SET name = #{name}, furikana = #{furikana} WHERE id = #{id}")
    void edit(University university);
}
