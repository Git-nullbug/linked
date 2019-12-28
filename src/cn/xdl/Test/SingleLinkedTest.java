package cn.xdl.Test;

import cn.xdl.SingleLinkedCycle.SingleLinkedCycle;
import cn.xdl.Singlelinked.SingleLinked;

public class SingleLinkedTest {

    public static void main(String[] args) {
        SingleLinked l = new SingleLinked();
        // 尾部增加
        l.append(1);
        l.append(2);
        l.append(3);
        l.append(4);
        l.append(5);
        l.append(6);
        l.append(7);
        l.append(8);
        // 中间插入
        l.insert(4,9);
        // 修改数据在某个数据之后
        l.setData(5,99);
        // 删除数据
        String str = l.delete(7);
        System.out.println(str);
        //System.out.println(flag);
        // 查询所有
        l.findAll();
        // 链表长度
        int size = l.size();
        System.out.println("size = "+size);



    }
}
