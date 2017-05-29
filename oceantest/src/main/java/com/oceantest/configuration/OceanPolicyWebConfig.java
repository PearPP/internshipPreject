package com.oceantest.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//@EnableWebMvc
//@Configuration
//@ComponentScan(basePackages = "com.oceantest.web")
public class OceanPolicyWebConfig extends WebMvcConfigurerAdapter {

	// TODO : จะคอนฟิคพาร์ทของไฟล์ ไว้ที่นี้ หรือจะเรียก path แบบเต็ม ๆเองก็ได้
	/*@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        final boolean DO_NOT_USE_SUFFIX_PATTERN_MATCHING = false;
        configurer.setUseSuffixPatternMatch(DO_NOT_USE_SUFFIX_PATTERN_MATCHING);
    }*/
	
}
