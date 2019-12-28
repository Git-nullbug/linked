package cn.xdl.Test;

import cn.xdl.SingleLinkedCycle.SingleLinkedCycle;

import java.util.ArrayList;
import java.util.LinkedList;

public class SingleLinkedCycleTest {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------");
        SingleLinkedCycle slc = new SingleLinkedCycle();
        slc.append(1);
        slc.append(2);
        slc.append(3);
        slc.append(4);
        slc.append(5);
        slc.append(6);
        boolean delete = slc.delete(1);
        System.out.println("delete："+delete);
        boolean setData = slc.setData(6, 99);
        System.out.println("setData："+setData);
        boolean select = slc.exist(99);
        System.out.println("select："+select);
        slc.findAll();
        //int size = slc.size();
        //System.out.println("size : "+size);
        System.out.println(15 >> 1);
        System.out.println(slc);
    }
}
