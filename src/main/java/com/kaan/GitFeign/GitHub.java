package com.kaan.GitFeign;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHub {
    @RequestLine("GET /users/{username}")
    User getUser(@Param("username") String username);

    @RequestLine("GET /users/{username}/repos")
    List<Repository> getUserRepos(@Param("username") String username);
}



// https://api.github.com/users/kaankhrmn/repos