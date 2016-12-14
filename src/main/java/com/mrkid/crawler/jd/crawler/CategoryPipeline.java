package com.mrkid.crawler.jd.crawler;

import com.mrkid.crawler.Request;
import com.mrkid.crawler.ResultItems;
import com.mrkid.crawler.jd.dto.JDCategoryDTO;
import com.mrkid.crawler.jd.facade.JDFacade;
import com.mrkid.crawler.pipeline.SubPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: xudong
 * Date: 08/11/2016
 * Time: 7:09 PM
 */
@Component
public class CategoryPipeline implements SubPipeline {

    @Autowired
    private JDFacade jdFacade;

    @Override
    public MatchOther processResult(ResultItems resultItems) {

        List<JDCategoryDTO> categories = resultItems.get("categories");
        for (JDCategoryDTO categoryDTO : categories) {

            jdFacade.saveCategory(categoryDTO);
        }

        return MatchOther.NO;
    }

    @Override
    public boolean match(Request page) {
        final Integer pageType = page.getPageType();
        return PageType.TOP_CATEGORY.equals(pageType) || PageType.SUB_CATEGORY.equals(pageType);
    }
}
