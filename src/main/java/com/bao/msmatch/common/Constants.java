package com.bao.msmatch.common;

import com.bao.msmatch.model.User;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author baocy
 * @Description //TODO
 * @Date 2020/2/26 22:13
 **/
public class Constants {
    public static List<User> maleList = new ArrayList<>();
    public static List<User> femaleList = new ArrayList<>();
    public static List<Pair<User, User>> afterList = new ArrayList<>();

    public final static User u = User.builder().uid("?").name("?").imgUrl("/img/face.png").build();

    public static void initData() {
        maleList.clear();
        femaleList.clear();
        afterList.clear();

        femaleList.add(User.builder().uid("1").sex("female").name("san1").imgUrl("/img/female.png").build());
        femaleList.add(User.builder().uid("2").sex("female").name("san2").imgUrl("/img/female.png").build());
        maleList.add(User.builder().uid("3").sex("male").name("haha3").imgUrl("/img/male.png").build());
        maleList.add(User.builder().uid("4").sex("male").name("haha4").imgUrl("/img/male.png").build());
        maleList.add(User.builder().uid("5").sex("male").name("haha5").imgUrl("/img/male.png").build());
        maleList.add(User.builder().uid("6").sex("male").name("haha6").imgUrl("/img/male.png").build());
        maleList.add(User.builder().uid("7").sex("male").name("haha7").imgUrl("/img/male.png").build());

    }


    public static Pair<User, User> match() {
        int i = maleList.size();
        int k = femaleList.size();
        Pair<User, User> pair = null;
        if (i != 0 && k != 0) {
            final int j = (int) (Math.random() * i);
            final int s = (int) (Math.random() * k);
            pair = new Pair<>(maleList.get(j), femaleList.get(s));
            maleList.remove(j);
            femaleList.remove(s);
        } else if (i == 0 && k != 0) {
            if (k == 1) {
                pair = new Pair<>(femaleList.get(0), u);
                femaleList.remove(0);
            } else {
                final int s = (int) (Math.random() * k);
                User l = femaleList.get(s);
                femaleList.remove(s);
                final int m = (int) (Math.random() * (k - 1));
                User r = femaleList.get(m);
                femaleList.remove(m);
                pair = new Pair(l, r);
            }
        } else if (i != 0 && k == 0) {
            if (i == 1) {
                pair = new Pair<>(maleList.get(0), u);
                maleList.remove(0);
            } else {
                final int s = (int) (Math.random() * i);
                User l = maleList.get(s);
                maleList.remove(s);
                final int m = (int) (Math.random() * (i - 1));
                User r = maleList.get(m);
                maleList.remove(m);
                pair = new Pair(l, r);
            }
        } else {
            pair = new Pair<>(u, u);
        }

        if (pair.getKey().getUid().equals(u.getUid()) && pair.getValue().getUid().equals(u.getUid())) {

        } else {
            afterList.add(pair);
        }

        return pair;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");

        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }

}
