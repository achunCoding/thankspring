package top.wycfight.thankspring.modules.test.bean;

/**
 * @author: wycfight@163.com
 * @description: 文章
 * @create: 2018-11-27 10:35
 * @modified By:
 **/
public class Article {

    private Integer id;
    private String author;
    private String title;
    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
