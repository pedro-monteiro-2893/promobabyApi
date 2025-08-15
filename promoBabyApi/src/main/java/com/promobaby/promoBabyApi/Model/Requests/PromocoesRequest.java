package com.promobaby.promoBabyApi.Model.Requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromocoesRequest {

    private Filters filters;
    private Pagination pagination;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Filters {
        private List<Long> advertiserIds;
        private boolean exclusiveOnly;
        private String membership;
        private List<String> regionCodes;
        private String status;
        private String type;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pagination {
        private int page;
        private int pageSize;
    }
}
