package dierji.paixu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements Comparable<NewsItem>{
    private Date pubTime;
    private Integer hits;
    private String title;

    public NewsItem() {
    }

    public NewsItem(Date pubTime, Integer hits, String title) {
        this.pubTime = pubTime;
        this.hits = hits;
        this.title = title;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //时间降序 -> 点击量升序 -> 标题
    @Override
    public int compareTo(NewsItem o) {
        int result = 0;
        result = -this.pubTime.compareTo(o.pubTime);
        //如果时间相同
        if (result == 0) {
            result = -this.hits.compareTo(o.hits);
            //点击量相同
            if (result == 0) {
                result = this.title.compareTo(o.title);
            }
        }
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("标题:").append(this.title);
        sb.append("时间:").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.pubTime));
        sb.append("点击量:").append(this.hits);
        sb.append("\n");
        return sb.toString();
    }
}
