package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APP {
    Scanner sc;

    APP(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("==게시판 앱==");

        int lastId = 1;
        List<Article> articleList = new ArrayList<>();

//        번호 id = new 번호();
//        제목 subject = new 제목();
//        내용 content = new 내용();


        while (true) {
            System.out.print("명령)");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("제목 :");
                String text = sc.nextLine().trim();
                System.out.print("내용 :");
                String body = sc.nextLine().trim();

                Article article = new Article(lastId, text, body);
                articleList.add(article);

                System.out.printf("%d번 게시글이 등록되었습니다.\n", lastId);
                lastId++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 제목 / 내용");
                System.out.println("-------------------");

                for (int i = articleList.size() -1; i >= 0; i--) {
                    Article article = articleList.get(i);
                    System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
                }
            } else if (command.startsWith("삭제")) {
                String [] commandList = command.split("\\?", 2);
                //split 쪼개다 commandList[0] = "삭제", commandList[1] = "id =1"
                String[] paramsStr = commandList[1].split("=", 2);

                String value = paramsStr[1];
                int idx = Integer.parseInt(value);

                Article article = null;

                for (int i = 0; i < articleList.size(); i++) {
                    if (articleList.get(i).getId() == idx) {
                        article = articleList.get(i);
                    }
                }

                if ( article == null ) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                }
                else {
                    articleList.remove(article);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
                }

            }
        }
    }
}

