package jp.uib.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jp.uib.admin.controllers.UniversityController;

public class UniversityControllerTest {

    @Test
    public void test1() {
        UniversityController universityController = new UniversityController();
        boolean actual = universityController instanceof UniversityController;
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
