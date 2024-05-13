package com.digiage.projectTask4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda
 * AWS s3 bucket => interview-digiage
 *
 * - [] AWS s3 bucket
 */
@SpringBootApplication
public class ProjectTask4Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTask4Application.class, args);
    }

}
