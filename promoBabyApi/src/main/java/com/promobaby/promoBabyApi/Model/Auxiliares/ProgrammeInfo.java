package com.promobaby.promoBabyApi.Model.Auxiliares;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgrammeInfo {
	
	private String displayUrl;
    private String clickThroughUrl;
    private String logoUrl;
    private long id;
    private String name;
    private String currencyCode;
    private boolean deeplinkEnabled;
    private String description;
    private String membershipStatus;
    private PrimaryRegion primaryRegion;
    private String primarySector;
    private List<ValidDomain> validDomains;
    private List<String> trackingTransparency;
    private String linkStatus;

}
