package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Insert("INSERT INTO `postgraduate`.`comment` (`content`, `comment_user`, `comment_status`, `like_number`, `create_time`, `update_time`, `comment_invitation`) " +
            "VALUES (#{content}, #{comment_user}, #{comment_status}, #{like_number}, #{create_time}, #{update_time}, #{comment_invitation});")
    boolean addComment(Comment comment);

    @Update("UPDATE `postgraduate`.`comment` SET `comment`.`comment_status` = #{status} WHERE `comment`.`comment_id` = #{comment_id}")
    boolean changeStatus(Integer comment_id, Integer status);

    @Update("UPDATE `postgraduate`.`comment` SET `comment`.`like_number` = `comment`.`like_number` + 1 WHERE `comment`.`comment_id` = #{comment_id}")
    boolean addLike(Integer comment_id);

    @Select("SELECT * FROM `postgraduate`.`comment` WHERE `comment`.`comment_invitation` = #{invitation_id}")
    List<Comment> getInvitationComment(Integer invitation_id);

    @Delete("DELETE FROM `postgraduate`.`comment` WHERE `comment`.`comment_id` = #{comment_id};")
    boolean deleteComment(Integer comment_id);

    @Select("SELECT * FROM `postgraduate`.`comment` ORDER BY `comment`.`comment_invitation` ASC;")
    List<Comment> getAllComment();

    @Select("SELECT * FROM `postgraduate`.`comment` WHERE `comment`.`comment_user` = #{comment_user};")
    List<Comment> getCommentByUser(Integer comment_user);

    @Select("SELECT * FROM `postgraduate`.`comment` WHERE `comment`.`comment_id` = #{comment_id};")
    List<Comment> getCommentById(Integer comment_id);

    @Select("SELECT `postgraduate`.`user`.`username` FROM `postgraduate`.`user` WHERE `user`.`user_id` = #{comment_user};")
    String getUsername(Integer comment_user);
}
