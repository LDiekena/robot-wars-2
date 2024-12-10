package org.example.Client.View;

public class IntroScreenView {
    //Farbcodes
    public final String farbReset = "\u001B[0m";
    public final String gelb = "\u001B[33m";

    //Ausgabe Introscreen
    public void displayIntroScreen() {
        System.out.println("      Herzlich willkommen bei Robot Wars!");

        String welcomeASCII = gelb + "           ___\n" +
                "          |_|_|\n" +
                "          |_|_|              _____\n" +
                "          |_|_|     ____    |*_*_*|\n" +
                " _______   _\\__\\___/ __ \\____|_|_   _______\n" +
                "/ ____  |=|      \\  <_+>  /      |=|  ____ \\\n" +
                "~|    |\\|=|======\\\\______//======|=|/|    |~\n" +
                " |_   |    \\      |      |      /    |    |\n" +
                "  \\==-|     \\     | Robot|     /     |----|~~/\n" +
                "  |   |      |    | Wars |    |      |____/~/\n" +
                "  |   |       \\____\\____/____/      /    / /\n" +
                "  |   |         {----------}       /____/ /\n" +
                "  |___|        /~~~~~~~~~~~~\\     |_/~|_|/\n" +
                "   \\_/        |/~~~~~||~~~~~\\|     /__|\\\n" +
                "   | |         |    ||||    |     (/|| \\)\n" +
                "   | |        /     |  |     \\       \\\\\n" +
                "   |_|        |     |  |     |\n" +
                "              |_____|  |_____|\n" +
                "              (_____)  (_____)\n" +
                "              |     |  |     |\n" +
                "              |     |  |     |\n" +
                "              |/~~~\\|  |/~~~\\|\n" +
                "              /|___|\\  /|___|\\\n" +
                "             <_______><_______>\n" + farbReset;

        System.out.println(welcomeASCII);
    }
}
