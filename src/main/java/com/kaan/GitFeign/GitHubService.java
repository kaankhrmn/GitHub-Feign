package com.kaan.GitFeign;

import feign.Feign;

import java.util.List;

public class GitHubService {

    GitHub github = Feign.builder()
            .decoder(new com.kaan.GitFeign.GsonDecoder())
            .target(GitHub.class,"https://api.github.com");

    // Kullanıcı bilgilerini almak için bir metot
    public User getUserInfo(String username) {
        return github.getUser(username);
    }

    // Kullanıcının repo bilgilerini almak için bir metot
    public List<Repository> getUserRepositories(String username) {
        return github.getUserRepos(username);
    }
}