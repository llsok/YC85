package com.yc.crbook.bean;

public class Book {
    private Integer id;

    private String name;

    private String categroy1;

    private String categroy2;

    private String pic;

    private String price;

    private String author;

    private String publisher;

    private String pressDate;

    private String isbn;

    private String pressSn;

    private String pages;

    private String words;

    private String printTime;

    private String bookSize;

    private String printSn;

    private String packing;

    private String format;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategroy1() {
        return categroy1;
    }

    public void setCategroy1(String categroy1) {
        this.categroy1 = categroy1 == null ? null : categroy1.trim();
    }

    public String getCategroy2() {
        return categroy2;
    }

    public void setCategroy2(String categroy2) {
        this.categroy2 = categroy2 == null ? null : categroy2.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getPressDate() {
        return pressDate;
    }

    public void setPressDate(String pressDate) {
        this.pressDate = pressDate == null ? null : pressDate.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getPressSn() {
        return pressSn;
    }

    public void setPressSn(String pressSn) {
        this.pressSn = pressSn == null ? null : pressSn.trim();
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages == null ? null : pages.trim();
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words == null ? null : words.trim();
    }

    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime == null ? null : printTime.trim();
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize == null ? null : bookSize.trim();
    }

    public String getPrintSn() {
        return printSn;
    }

    public void setPrintSn(String printSn) {
        this.printSn = printSn == null ? null : printSn.trim();
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing == null ? null : packing.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }
}