package org.newday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiamondDrawerTest {

    DiamondDrawer diamondDrawer;


    @BeforeEach
    public void setUp() {
        diamondDrawer = new DiamondDrawer();
    }

    @Test
    void testADiamond() {
        String expected = "A";

        String result = diamondDrawer.drawDiamond('A');

        assertThat(result).isEqualTo(expected);
    }


    @Test
    void testBDiamond() {
        String shape = """
                _A_
                B_B
                _A_
                """;
        String expected = shape.replace("_", " ");

        String result = diamondDrawer.drawDiamond('B');

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testCDiamond() {
        String shape =
                """
                        __A__
                        _B_B_
                        C___C
                        _B_B_
                        __A__
                        """;
        String expected = shape.replace("_", " ");

        String result = diamondDrawer.drawDiamond('C');

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGDiamond() {
        String shape =
                """
                        ______A______
                        _____B_B_____
                        ____C___C____
                        ___D_____D___
                        __E_______E__
                        _F_________F_
                        G___________G
                        _F_________F_
                        __E_______E__
                        ___D_____D___
                        ____C___C____
                        _____B_B_____
                        ______A______
                        """;
        String expected = shape.replace("_", " ");

        String result = diamondDrawer.drawDiamond('G');

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testLowerCaseLetterFDiamond() {
        String shape =
                """
                        _____A_____
                        ____B_B____
                        ___C___C___
                        __D_____D__
                        _E_______E_
                        F_________F
                        _E_______E_
                        __D_____D__
                        ___C___C___
                        ____B_B____
                        _____A_____
                        """;
        String expected = shape.replace("_", " ");

        // I made it work for both lower and uppercase
        String result = diamondDrawer.drawDiamond('f');

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testNonAlphabeticCharacter() {
        assertThrows(IllegalArgumentException.class, () -> diamondDrawer.drawDiamond('#'));
        assertThrows(IllegalArgumentException.class, () -> diamondDrawer.drawDiamond('2'));
    }
}
