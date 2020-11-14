package com.example.logging.binding;

import com.example.logging.datamodel.Response;
import com.example.logging.service.BusinessServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import javax.xml.ws.Service;

@RestController
@RequestMapping("/api/v1/customer")
public class ServiceController {

    Logger logger = LoggerFactory.getLogger(Service.class);

    @Autowired
    BusinessServiceImpl businessService;

    @GetMapping()
    public Response getCustomer(@RequestParam(required = true, name = "cid") String customerId){
        logger.info("gerMerchant request received for customerId: {}", customerId);

        //Some processing
        Response response = businessService.getCustomerDetails(customerId);

        logger.info("getMerchant request for customerId {} processed: {}", customerId, response);

        return response;
    }

    @GetMapping("/exists")
    public Response customerExists(@RequestParam(required = true, name = "mobileNumber") String mobileNumber){
        logger.info("customerExists request received for mobileNumber: {}", mobileNumber);

        //Some processing
        try{
            Response response = businessService.customerExists(mobileNumber);
            logger.info("customerExists request for mobileNumber {} processed: {}", mobileNumber, response);
            return response;
        }
        catch (ResourceAccessException e){
            logger.error("ResourceAccessException when accessing customerExists API of endSystem ",e.getLocalizedMessage());
            return new Response("908", e.getLocalizedMessage());
        }
        catch (HttpServerErrorException e){
            logger.error("HttpServerErrorException when accessing customerExists API of endSystem ",e.getLocalizedMessage());
            return new Response("909", e.getLocalizedMessage());
        }
        catch (HttpClientErrorException e){
            logger.error("HttpClientErrorException when accessing customerExists API of endSystem ",e.getLocalizedMessage());
            return new Response("910", e.getLocalizedMessage());
        }

    }
}