package jp.uib.admin.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class University {

    /** ID */
    private int id;

    /** 大学名 */
    private String name;

    /** フリガナ */
    private String furikana;

    // private LocalDateTime created;

    // private LocalDateTime modified;

}
