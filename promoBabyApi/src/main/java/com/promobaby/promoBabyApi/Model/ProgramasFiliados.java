package com.promobaby.promoBabyApi.Model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramasFiliados {
	
	
	private String description;
    private String displayUrl;
    private String logoUrl;
    private String clickThroughUrl;
    private int id;
    private String name;
    private String currencyCode;
    private PrimaryRegion primaryRegion;
    private String status;
    private String primarySector;
    private List<ValidDomain> validDomains;

}
