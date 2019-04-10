package com.outreach.feedback.addresses.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Errors {
	private final Map<String, List<String>>	errors				= new HashMap<String, List<String>>();
}
