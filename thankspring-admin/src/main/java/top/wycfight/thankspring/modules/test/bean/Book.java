package top.wycfight.thankspring.modules.test.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author: wycfight@163.com
 * @description: 测试类
 * @create: 2018-11-26 16:40
 * @modified By:
 **/
@Document(indexName = "wyc",type = "book")
public class Book {
    /** 书名 */
    private String bookName;
    /** 作者 */
    private String author;

    private Long id;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
