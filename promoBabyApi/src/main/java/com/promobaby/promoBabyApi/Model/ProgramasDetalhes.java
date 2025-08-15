package com.promobaby.promoBabyApi.Model;

import java.util.List;

import com.promobaby.promoBabyApi.Model.Auxiliares.CommissionRange;
import com.promobaby.promoBabyApi.Model.Auxiliares.Kpi;
import com.promobaby.promoBabyApi.Model.Auxiliares.ProgrammeInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramasDetalhes {
	

	    private ProgrammeInfo programmeInfo;
	    private Kpi kpi;
	    private List<CommissionRange> commissionRange;

}
