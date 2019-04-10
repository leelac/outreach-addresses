package com.outreach.feedback.addresses.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;

import lombok.Data;

@Data
public class RestfulResponse {
	private RestStatus status;
	private Payload data = new Payload();
	private List<Violation> errors = new ArrayList<Violation>();
	private Payload meta = new Payload();
	
	public enum RestStatus {
        ERROR, SUCCESS, FAIL
    }
	
	public Response ok(Payload responsePayload) {
        return Response.ok(wrap(responsePayload)).build();
    }
	
	public RestfulResponse wrap(Payload responsePayload) {
        return wrap(responsePayload, RestStatus.SUCCESS, new Errors());
    }

    public RestfulResponse wrap(Payload responsePayload, RestStatus status, Errors errors) {
        RestfulResponse response = new RestfulResponse();
        response.setData(responsePayload);
        response.setStatus(status);
        response.setErrors(convertErrors(errors));
        return response;
    }
    
    public List<Violation> convertErrors(Errors errors) {
        List<Violation> violations = new ArrayList<Violation>();
        for (Entry<String, List<String>> entry : errors.getErrors().entrySet()) {
            for (String value : entry.getValue()) {
                Violation violation = new Violation();
                violation.setCode(entry.getKey());
                violation.setMessage(value);
                violations.add(violation);
            }
        }

        return violations;
    }
}