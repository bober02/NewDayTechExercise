package org.newday;

// we could hide this behind interface, but it seems too much of an overkill for a simple task like this
public class DiamondDrawer {

    public DiamondDrawer() {

    }

    public String drawDiamond(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Character specified is not a letter: " + letter);
        }
        // include lowercase too
        letter = Character.toUpperCase(letter);
        if (letter > 'Z' || letter < 'A') {
            throw new IllegalArgumentException("The diamond shape should only be within the alphabet [A-Z]. Supplied value: " + letter);
        }

        if (letter == 'A') {
            return "A";
        }

        // figure out how wide the middle of the diamond is
        int midLevel = letter - 'A'; // B is at level 1, C is at level 2 etc
        int diamondWidth = 2 * midLevel + 1;
        // each level will have a certain amount of leading and trailing spaces (equal amount) as well as middle spaces
        // we can calculate based on level what the middle space count is and then we have everything:
        //    1. leading + char+ trailing or
        //    2. leading + char + middle + char + trailing
        StringBuilder result = new StringBuilder();
        for (char currChar = 'A'; currChar <= letter; currChar++) {
            addRow(currChar, diamondWidth, result);
        }
        for (char currChar = (char) (letter - 1); currChar >= 'A'; currChar--) {
            addRow(currChar, diamondWidth, result);
        }


        return result.toString();
    }

    private void addRow(char c, int diamondWidth, StringBuilder result) {
        int currlevel = c - 'A';
        int middleSpaces = Math.max(2 * currlevel - 1, 0);
        int charOccurence = middleSpaces > 0 ? 2 : 1;
        int trailingSpaces = (diamondWidth - middleSpaces - charOccurence) / 2;

        // process all spaces and characters to build a row


        result.append(" ".repeat(trailingSpaces));
        result.append(c);
        //not the top of the diamond
        if (charOccurence > 1) {
            result.append(" ".repeat(middleSpaces));
            result.append(c);
        }
        result.append(" ".repeat(trailingSpaces));
        result.append("\n");
    }
}
