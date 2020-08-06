package com.laioffer.tinnews.UI.save;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;

import java.util.List;

import Repository.NewsRepository;

public class SaveViewModel extends ViewModel {
    private final NewsRepository repository;
    public SaveViewModel(NewsRepository repository) {
        this.repository = repository;
    }
    public LiveData<List<Article>> getAllSavedArticles() {
        return repository.getAllSavedArticles();
    }
    public void deleteSavedArticle (Article article) {
        repository.deleteSavedArticle(article);
    }
}
