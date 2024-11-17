package com.kaan.GitFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GitFeignApplication {

	public static void main(String[] args) {

		GitHubService gitHubService = new GitHubService();

		// Kullanıcı bilgilerini alma
		User user = gitHubService.getUserInfo("kullanıcı adınızı girin");
		System.out.println("Kullanıcı: " + user.getName());
		System.out.println("Kullanıcı Adı: " + user.getLogin());

		// Kullanıcının repo bilgilerini alma
		List<Repository> repos = gitHubService.getUserRepositories("kullanıcı adınızı girin");
		for (Repository repo : repos) {
			System.out.println("Repo Adı: " + repo.getName());
			System.out.println("Dil: " + repo.getLanguage());
		}
	}
}

