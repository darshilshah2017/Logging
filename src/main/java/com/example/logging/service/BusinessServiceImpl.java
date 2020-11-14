package com.example.logging.service;

import com.example.logging.datamodel.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

@Component
public class BusinessServiceImpl {

    Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    public Response getCustomerDetails(String customerId){
        logger.debug("getCustomerDetails request sent to endSystem : {}",customerId);

        //Some internal processing

        Response response = new Response("200","SUCCESS");
        logger.debug("getCustomerDetails response received from endSystem: {}",response);
        return response;
    }

    public Response customerExists(String mobileNumber){
        logger.debug("customerExists request sent to endSystem: {}",mobileNumber);

        //Some internal processing
        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Unhandled interval server error");
//        Response response = new Response("200","SUCCESS");
//        logger.debug("customerExists response received from endSystem: {}",response);
//        return response;
    }
}
