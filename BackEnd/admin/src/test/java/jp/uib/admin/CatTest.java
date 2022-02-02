package jp.uib.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.uib.admin.test.Test1;

public class CatTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpSteams() {
        System.setOut(new PrintStream(outContent));
        System.out.println(1 + outContent.toString());
    }

    @AfterEach
    public void cleanUpSteams() {
        System.setOut(System.out);
        System.out.println(2 + outContent.toString());
    }

    @Test
    public void oilingTest01() {

        Test1 c = new Test1();

        // 値をセット
        c.carName = "テスト車";
        // 給油メソッドを実行
        c.oiling();

        // 期待値を設定
        final String expected = "テスト車は、ガソリンスタンドで給油をした" + System.lineSeparator();

        // 実際の値を取得
        final String actual = outContent.toString();

        System.out.println(3 + expected);
        assertEquals(expected, actual);

    }

    @Test
    public void distanceTest01() {

        Test1 c = new Test1();
        StringBuilder sb = new StringBuilder();

        // 改行
        String ln = System.lineSeparator();

        // 値をセット
        int km = 100;
        c.fuel = 60;
        // distanceメソッドを実行
        c.destance(km);

        // 期待値を設定
        sb.append("100km走って10Lのガソリンを消費した");
        sb.append(ln);
        sb.append("残りの燃料は50Lです。");
        sb.append(ln);
        final String expected = sb.toString();

        // 実際の値を取得
        final String actual = outContent.toString();

        System.out.println(4 + expected);

        assertEquals(expected, actual);

    }

}
