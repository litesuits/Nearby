package cn.huike.android.model;

/**
 * @author MaTianyu
 */
public class Theme {
    public static final String[] THEMES = new String[]{"white", "black"};

    public static final int WHITE = 0;
    public static final int BLACK = 1;

    private int theme;

    public Theme(int theme) {
        if (theme >= 0 && theme < THEMES.length) {
            this.theme = 0;
        }
        this.theme = theme;
    }

    public int getTheme() {
        return theme;
    }

    public String getThemeString() {
        if (theme < 0 || theme > THEMES.length) {
            return THEMES[0];
        } else {
            return THEMES[theme];
        }
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public boolean isBlack() {
        return theme == BLACK;
    }

    public boolean isWhite() {
        return theme == WHITE;
    }
}
