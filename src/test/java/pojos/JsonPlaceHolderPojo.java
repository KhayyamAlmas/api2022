package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    /*
    1) Tum key'ler icin private varibale'lar olusturuyoruz
    2) Tum parametrelerle ve parametresiz constructor'larimizi olusturuyoruz
    3) Getters ve Setters'lerimiz olusturuyoruz
    4) toString() methodumuzu olusturuyoruz
     */

    // 1) Tum key'ler icin private varibale'lar olusturuyoruz
    private Integer userID;
    private  String title;
    private Boolean completed;

    // 2) Tum parametrelerle ve parametresiz constructor'larimizi olusturuyoruz

    public JsonPlaceHolderPojo(Integer userID, String title, Boolean completed) {
        this.userID = userID;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

    // 3) Getters ve Setters'lerimiz olusturuyoruz

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    // 4) toString() methodumuzu olusturuyoruz

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userID=" + userID +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    // Farkli key-value ikililerin uyusmazligini @JsonIgnoreProperties(ignoreUnknown = true)
    // anotation'ini pojo class'imizin basina yazarak cozebiliriz
}
