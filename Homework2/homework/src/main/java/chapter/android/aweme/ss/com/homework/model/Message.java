package chapter.android.aweme.ss.com.homework.model;


/**
 * 消息  data class
 */
public class Message {

    private boolean isOfficial;//是否官方
    private String title;//title
    private String time;//时间
    private String description;//描述
    private String icon;//icon

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    @Override
    public String toString() {
        return "Message{" +
                "isOfficial=" + isOfficial +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
