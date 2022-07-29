package com.illiapinchuk.carrentalsystem.service.interfaces;

import com.illiapinchuk.carrentalsystem.model.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(Comment comment);

    List<Comment> getAllCommentsForCar(Long carId);

}
