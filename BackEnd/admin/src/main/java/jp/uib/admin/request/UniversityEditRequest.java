package jp.uib.admin.request;

import lombok.Data;

@Data
public class UniversityEditRequest {

    /** 大学名 */
    private int id;

    /** 大学名 */
    private String name;

    /** フリガナ */
    private String furikana;
}
