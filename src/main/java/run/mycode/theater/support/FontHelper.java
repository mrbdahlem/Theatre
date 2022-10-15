package run.mycode.theater.support;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.code.media.FontStyle;

public class FontHelper {
    private static Map<String, Font> fontMap;
    private static final String FONT_FOLDER_NAME = "fonts";
    private static final String[] FONT_FILE_NAMES =
            new String[] {
                    "LiberationMono-Bold.ttf",
                    "LiberationMono-BoldItalic.ttf",
                    "LiberationMono-Italic.ttf",
                    "LiberationMono-Regular.ttf",
                    "LiberationSans-Bold.ttf",
                    "LiberationSans-BoldItalic.ttf",
                    "LiberationSans-Italic.ttf",
                    "LiberationSans-Regular.ttf",
                    "LiberationSerif-Bold.ttf",
                    "LiberationSerif-BoldItalic.ttf",
                    "LiberationSerif-Italic.ttf",
                    "LiberationSerif-Regular.ttf"
            };

    public static Map<String, Font> getFontMap()  {
        if (fontMap != null) {
            return fontMap;
        }

        try {
            fontMap = new HashMap<>();
            for (String filename : FONT_FILE_NAMES) {
                String filePath = FONT_FOLDER_NAME + "/" + filename;
                InputStream fileStream = FontHelper.class.getClassLoader().getResourceAsStream(filePath);
                fontMap.put(filename, java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, fileStream));
                fileStream.close();
            }
        }
        catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }

        return fontMap;
    }

    public static java.awt.Font getFont(org.code.media.Font font, FontStyle fontStyle) {
        return getFontMap().get(getFontFilename(font, fontStyle));
    }

    private static String getFontFilename(org.code.media.Font font, FontStyle fontStyle) {
        return fontToFilenamePrefix.get(font) + fontStyleToFilenameSuffix.get(fontStyle);
    }

    private static final Map<org.code.media.Font, String> fontToFilenamePrefix =
            Map.ofEntries(
                    Map.entry(org.code.media.Font.MONO, "LiberationMono"),
                    Map.entry(org.code.media.Font.SANS, "LiberationSans"),
                    Map.entry(org.code.media.Font.SERIF, "LiberationSerif"));

    private static final Map<FontStyle, String> fontStyleToFilenameSuffix =
            Map.ofEntries(
                    Map.entry(FontStyle.NORMAL, "-Regular.ttf"),
                    Map.entry(FontStyle.BOLD, "-Bold.ttf"),
                    Map.entry(FontStyle.ITALIC, "-Italic.ttf"),
                    Map.entry(FontStyle.BOLD_ITALIC, "-BoldItalic.ttf"));
}
