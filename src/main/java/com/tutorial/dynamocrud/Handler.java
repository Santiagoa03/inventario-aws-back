package com.tutorial.dynamocrud;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {
        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        Propiedad propiedad = null;

        try {
            switch (request.getHttpMethod()) {
                case "GET":
                    if (request.getId() == 0) {
                        List<Propiedad> productos = new ArrayList<>();
                        productos = mapper.scan(Propiedad.class, new DynamoDBScanExpression());
                        return productos;
                    } else {
                        propiedad = mapper.load(Propiedad.class, request.getId());
                        return propiedad;
                    }
                case "POST":
                    propiedad = request.getPropiedad();
                    if (propiedad != null) {
                        mapper.save(propiedad);
                        return propiedad;
                    } else {
                        return "Invalid input: Propiedad is null";
                    }
                case "DELETE":
                    propiedad = mapper.load(Propiedad.class, request.getId());
                    if (propiedad != null) {
                        mapper.delete(propiedad);
                        return propiedad;
                    } else {
                        return "Propiedad not found with id: " + request.getId();
                    }
                default:
                    return "Unsupported HTTP method: " + request.getHttpMethod();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
