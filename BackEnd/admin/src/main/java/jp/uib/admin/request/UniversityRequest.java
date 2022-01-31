package jp.uib.admin.request;

import lombok.Data;

@Data
public class UniversityRequest {

    /** 大学名 */
    private String name;

    /** フリガナ */
    private String furikana;
}
