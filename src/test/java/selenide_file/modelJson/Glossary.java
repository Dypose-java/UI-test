package selenide_file.modelJson;

import com.google.gson.annotations.SerializedName;

public class Glossary {
    public String title;
    public Boolean flag;
    @SerializedName("GlossDiv")
    public GlossDiv glossDiv;


    public static class GlossDiv {
        public String title;
        @SerializedName("GlossList")
        public GlossList glossList;
    }

    public static class GlossList {
        @SerializedName("GlossEntry")
        public GlossEntry glossEntry;
    }

    public static class GlossEntry {
        @SerializedName("ID")
        public String id;
        @SerializedName("SortAs")
        public String sortAs;
        @SerializedName("GlossTerm")
        public String glossTerm;
        @SerializedName("Acronym")
        public String acronym;
        @SerializedName("Abbrev")
        public String abbrev;
        @SerializedName("GlossDef")
        public GlossDef glossDef;
        @SerializedName("GlossSee")
        public String glossSee;

    }

    public static class GlossDef {
        public String para;
        @SerializedName("GlossSeeAlso")
        public String[] glossSeeAlso;

    }
}
/**
 * {
 * "glossary": {
 * "title": "example glossary",
 * "flag": true,
 * "GlossDiv": {
 * "title": "S",
 * "GlossList": {
 * "GlossEntry": {
 * "ID": "SGML",
 * "SortAs": "SGML",
 * "GlossTerm": "Standard Generalized Markup Language",
 * "Acronym": "SGML",
 * "Abbrev": "ISO 8879:1986",
 * "GlossDef": {
 * "para": "A meta-markup language, used to create markup languages such as DocBook.",
 * "GlossSeeAlso": ["GML", "XML"]
 * },
 * "GlossSee": "markup"
 * }
 * }
 * }
 * }
 * }
 */