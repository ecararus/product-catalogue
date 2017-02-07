package com.eca;

import com.eca.catalogue.facade.CatalogueService;
import com.eca.catalogue.product.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CatalogueAppConfiguration implements CommandLineRunner {

    @SuppressWarnings("unused")
    @Autowired
    private CatalogueService catalogueService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(CatalogueAppConfiguration.class).web(true).run(args);
    }

    /**
     * Temporary solution made only for create static predefined data set.
     * To investigate integration with liquibase.
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public void run(String... args) throws Exception {
        catalogueService.save(ProductVO.builder().setCategory("Sport").setName("Arsenal TV").setLocationId("London").build());
        catalogueService.save(ProductVO.builder().setCategory("Sport").setName("Chelsea TV").setLocationId("London").build());
        catalogueService.save(ProductVO.builder().setCategory("Sport").setName("Liverpool TV").setLocationId("Liverpool").build());
        catalogueService.save(ProductVO.builder().setCategory("News").setName("Sky News").build());
        catalogueService.save(ProductVO.builder().setCategory("News").setName("Sky Sport News").build());
    }

}
