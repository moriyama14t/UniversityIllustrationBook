package jp.uib.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class University {

    /** ID */
    private int id;

    /** 大学名 */
    private String name;

    /** フリガナ */
    private String furikana;

}
