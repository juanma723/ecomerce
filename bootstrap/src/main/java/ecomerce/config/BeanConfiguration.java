package ecomerce.config;

import ecomerce.ExceptionHandlerController;
import ecomerce.FindPriceService;
import ecomerce.in.PriceRestController;
import ecomerce.out.PriceJpaRepository;
import ecomerce.out.PriceRepositoryImpl;
import ecomerce.port.FindPriceUseCase;
import ecomerce.port.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    PriceJpaRepository priceJpaRepository;

    @Bean
    PriceRestController priceRestController() {
        return new PriceRestController(findPriceUseCase());
    }

    @Bean
    FindPriceUseCase findPriceUseCase() {
        return new FindPriceService(priceRepository());
    }

    @Bean
    PriceRepository priceRepository() {
        return new PriceRepositoryImpl(priceJpaRepository);
    }


    @Bean
    ExceptionHandlerController exceptionHandlerController() {
        return new ExceptionHandlerController();
    }
}
