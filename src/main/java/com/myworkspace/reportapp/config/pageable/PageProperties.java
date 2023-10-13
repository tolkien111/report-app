package com.myworkspace.reportapp.config.pageable;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Data
public class PageProperties {

    @Value(value = "${default.page}")
    private int defaultPage;

    @Value(value = "${default.size}")
    private int defaultSize;

    @Value(value = "${default.direction}")
    private String defaultDirection;

    @Value(value = "${default.sortBy}")
    private String defaultSortBy;
}
