package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.model.Comment;
import com.illiapinchuk.carrentalsystem.service.interfaces.CarService;
import com.illiapinchuk.carrentalsystem.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;

    @Autowired
    @Qualifier("carService")
    private CarService carService;

    @GetMapping( "/{carId}/all")
    public List<Comment> getAllCarComments(@PathVariable Long carId) {
        return commentService.getAllCommentsForCar(carId);
    }

    @PostMapping( "/{carId}")
    public Comment addCommentToCar(@PathVariable Long carId, @ModelAttribute Comment comment) {
        comment.setCar(carService.getCarById(carId));
        return commentService.addComment(comment);
    }
}
