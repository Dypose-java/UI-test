package selenide_file.modelJson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonDypose {
public Dypose dypose;
    public static class Dypose{
        public String names;
       public Biography biography;
    }

    public static class Biography{
        public String name;
        public String age;
        public Boolean tall;
        public Work work;
    }

    public static class Work{
        @SerializedName("AqaStack")
       public String []aqaStack;
        @SerializedName("AqaStack1")
        public List<String> aqaStack1;
    }

}


