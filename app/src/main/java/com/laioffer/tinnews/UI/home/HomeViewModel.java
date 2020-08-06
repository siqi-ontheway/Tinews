package com.laioffer.tinnews.UI.home;

import android.os.Bundle;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.model.NewsResponse;

import Repository.NewsRepository;


public class HomeViewModel extends ViewModel {

    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();
    private View view;
    private HomeViewModel viewModel;
    @Nullable
    private Bundle savedInstanceState;

    public HomeViewModel(NewsRepository newsRepository) {
        this.repository = newsRepository;
    }

    public void setCountryInput(String country) {
        countryInput.setValue(country);
    }

    public LiveData<NewsResponse> getTopHeadlines() {
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
    }

    public void setFavoriteArticleInput(Article article) {
        repository.favoriteArticle(article);
    }

}
