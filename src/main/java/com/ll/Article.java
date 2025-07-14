package com.ll;


public class Article{
    private int id;
    private String subject;
    private String content;

    public Article(int id, String subject, String content) {
        this. id = id;
        this. subject = subject;
        this. content = content;
    }

    int getId (){
        return this.id;
    }

    String getSubject(){
        return  this.subject;
    }
    String getContent(){
        return  this.content;
    }
}

//static <id, subject, content> Article<id, subject, content> getArticle(id, subject, content) {
//    return new Article<id, subject, content>();
//}