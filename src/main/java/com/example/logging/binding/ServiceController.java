package com.example.logging.binding;

import com.example.logging.datamodel.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

@RestController
@RequestMapping("/api/v1/customer")
public class ServiceController {

    Logger logger = LoggerFactory.getLogger(Service.class);

    @GetMapping()
    public Response getCustomer(@RequestParam(required = true, name = "cid") String customerId){
        logger.info("gerMerchant request received for customerId: {}", customerId);

        //Some processing
        Response response = new Response("200","SUCCESS");

        logger.info("getMerchant request for customerId {} processed: {}", customerId, response);

        return response;
    }
}