package com.promobaby.promoBabyApi.Model.Auxiliares;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promocoes {

	private long promotionId;
    private String type;
    private Advertiser advertiser;
    private String title;
    private String description;
    private String terms;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String status;
    private String url;
    private String urlTracking;
    private OffsetDateTime dateAdded;
    private String campaign;
    private Regions regions;
}
