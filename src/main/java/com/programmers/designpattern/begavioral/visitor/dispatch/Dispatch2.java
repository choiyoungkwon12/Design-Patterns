package com.programmers.designpattern.begavioral.visitor.dispatch;

import java.util.Arrays;
import java.util.List;

public class Dispatch2 {
    interface Post{ void postOn(SNS sns); }
    static class Text implements Post{
        @Override
        public void postOn(SNS sns){
            System.out.println("text -> " + sns.getClass().getSimpleName());
        }
    }
    static class Picture implements Post{
        @Override
        public void postOn(SNS sns) {
            System.out.println("picture -> " + sns.getClass().getSimpleName());
        }
    }

    interface SNS { }
    static class Facebook implements SNS{ };
    static class Twitter implements SNS{ };

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter());

        /*for (Post post : posts) {
            for (SNS sn : sns) {
                post.postOn(sn);
            }
        }*/
        posts.forEach(p -> sns.forEach(s -> p.postOn(s)));
    }
}