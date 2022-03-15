package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;

public class HomeViewModel extends ViewModel {

    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();

    //temp
    public HomeViewModel(NewsRepository newsRepository) {
        this.repository = newsRepository;
    }
    // event
    public void setCountryInput(String country) {
        countryInput.setValue(country);
    }
    // state
    public LiveData<NewsResponse> getTopHeadlines() {
        //oberseve countryInput
        //switchMap: input to topheadlines
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
    }

    public void setFavoriteArticleInput(Article article) {
        repository.favoriteArticle(article);
    }

}
