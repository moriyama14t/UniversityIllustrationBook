package jp.uib.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.uib.admin.Service.UniversityService;
import jp.uib.admin.model.University;
import jp.uib.admin.request.UniversityRequest;

@RestController
@RequestMapping("/api")
public class UniversityController {
    @Autowired
    UniversityService postsService;

    @GetMapping("/")
    List<University> getAllPosts() {
        return postsService.getAllPosts();
    }

    @GetMapping("/{id}")
    University getUniversity(@PathVariable("id") int id) {
        return postsService.getPost(id);
    }

    @PostMapping("/add")
    void addUniversity(@RequestBody UniversityRequest universityRequest) {

        postsService.add(universityRequest);

    }
}
