package com.promobaby.promoBabyApi.Model.Auxiliares;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kpi {
	
	private String averagePaymentTime;
    private double approvalPercentage;
    private double epc;
    private double conversionRate;
    private int validationDays;
    private double awinIndex;

}
