package com.tapestry5book.pages.chapter06.blog;

import com.tapestry5book.entities.Article;
import com.tapestry5book.entities.Blog;
import com.tapestry5book.services.BlogService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.Date;

public class Post {

    @Property
    private Article article;

    @SessionState
    @Property
    private Blog blog;

    @Inject
    private BlogService blogService;

    void onPrepare() {
        article = new Article();
    }

    void onPublish() {
        article.setPublishDate(new Date());
    }

    @CommitAfter
    void onSuccess() {
        this.article.setBlog(this.blog);

        blogService.persistArticle(this.article);
    }
}