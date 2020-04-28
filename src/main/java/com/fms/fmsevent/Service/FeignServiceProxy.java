/*
 * package com.fms.fmsevent.Service;
 * 
 * import org.springframework.cloud.netflix.ribbon.RibbonClient; import
 * org.springframework.cloud.openfeign.FeignClient; import
 * org.springframework.web.bind.annotation.GetMapping;
 * 
 * import com.fms.fmsevent.model.FeedbackQuestion;
 * 
 * import reactor.core.publisher.Flux;
 * 
 * //@FeignClient(name="currency-exchange-service" ,
 * url="http://localhost:8000") No need with url if enable ribbon
 * //@FeignClient(name="currency-exchange-service")
 * 
 * @FeignClient(name="netflix-zuul-gateway")
 * 
 * @RibbonClient(name="fms-feedback") public interface FeignServiceProxy {
 * 
 * // @GetMapping("/currencyEx/from/{from}/to/{to}")
 * 
 * @GetMapping("/fms-feedback/feedback") public Flux<FeedbackQuestion>
 * getConvertValue(); }
 */