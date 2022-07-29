package com.illiapinchuk.carrentalsystem.service;

import com.illiapinchuk.carrentalsystem.model.Comment;
import com.illiapinchuk.carrentalsystem.repository.CommentRepository;
import com.illiapinchuk.carrentalsystem.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllCommentsForCar(Long carId) {
        return commentRepository.getCommentsByCarId(carId);
    }
}
