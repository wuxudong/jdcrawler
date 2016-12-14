package com.mrkid.crawler.jd.repository;

import com.mrkid.crawler.jd.model.JDCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: xudong
 * Date: 21/10/2016
 * Time: 11:43 AM
 */
public interface JDCategoryRepository extends JpaRepository<JDCategory, Long> {
}
