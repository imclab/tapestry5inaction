package com.tapestry5inaction.pages.chapter12;

import com.tapestry5inaction.entities.Article;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

public class Read {

    @PageActivationContext
    @Property
    private Article article;

}