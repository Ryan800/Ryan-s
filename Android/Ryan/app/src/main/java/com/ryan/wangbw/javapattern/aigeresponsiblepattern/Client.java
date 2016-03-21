package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 09:22
 * Desc:
 */
public class Client {
    public static void main(String[] args) {
        ProgramApe ape = new ProgramApe((int) (Math.random() * 30000));
        Leader leader = new GroupLeader();
        Leader director = new Director();
        Leader manager = new Manager();
        Leader boss = new Boss();

        leader.setLeader(director);
        director.setLeader(manager);
        manager.setLeader(boss);

        leader.handleRequest(ape);
    }
}
