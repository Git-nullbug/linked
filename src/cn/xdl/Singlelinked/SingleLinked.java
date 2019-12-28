package cn.xdl.Singlelinked;

import cn.xdl.node.Node;

public class SingleLinked {

    //初始化一个头节点，头节点不存放数据
    private Node head = null;

    /* 向链表中追加数据 尾节点的next始终为null */
    public void append(int data){
       Node newNode = new Node(data);
       //如果头节点为空
       if(head == null){
           head = newNode;
           return;
       }
       //当头节点不为空时定义temp变量 赋值头节点
        Node temp = head;
       //循环遍历 取到next为空的尾节点
       while(temp.getNext() != null){
           temp = temp.getNext();
       }
       //修改尾节点的next为要插入的数据
       temp.setNext(newNode);
    }

    /* 从头部开始加 */
    public void headAdd(int data){

        Node newNode = new Node(data,null);
        if(head == null){
            head = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        System.out.println(head);
    }
    /* 在指定的数据之后插入数据 */
    public String insert(int predata,int data){
        if(head == null) return "插入失败，链表为空";
        Node curNode = head;    //定义要添加之前的节点
        Node newNode = new Node(data);  //要加入的节点
        Node sufNode = curNode.getNext();   //要加入之后的节点
        //如果要加入的节点是在第一个之后
        if(curNode.getData() == predata){
            curNode.setNext(newNode);
            newNode.setNext(sufNode);
            return "插入成功";
        }
        // 如果要加入的节点不是在第一个之后 循环查找然后加入
        while(curNode.getNext() != null){
            curNode = curNode.getNext();    //要加入之前的那个节点同要加入之后的节点同步后移
            sufNode = curNode.getNext();    //要加入之后的那个节点同要加入之前的节点同步后移
            //判断指定的加在之前的的节点是否同定义的加在之前的节点数据是否相同
            if(predata == curNode.getData()){
               curNode.setNext(newNode);
               newNode.setNext(sufNode);
               return "插入成功";
            }
        }
        return "插入失败";
    }


    /* 遍历链表 */
    public void findAll(){
        Node curNode = head;
        if(curNode != null){
            int data = -1;
            // 由于是while循环 第一个取值不方便所以直接先将第一个打印
            System.out.println(curNode.getData());
            while(curNode != null){
                curNode = curNode.getNext();
                if(curNode == null){
                    System.out.println(head);
                    return;
                }
                data = curNode.getData();
                System.out.println(data);
            }
        }else{
            System.out.println("链表为空！");
        }

    }

    /* 删除数据 */
    public String delete(int data){

        if(head == null){
            return "删除失败，链表为空";
        }
        Node preNode = head;    //定义要删除的之前的节点
        Node curNode = preNode.getNext();   //定义要删除的节点
        // 如果是第一个节点直接删除
        if(data == preNode.getData()){
            preNode = preNode.getNext();
            return "删除成功";
        }

        // 循环遍历比较
        while(curNode != null){
            preNode = preNode.getNext();    //删除之前的节点往后移
            curNode = curNode.getNext();    //要删除的节点网后移，让遍历继续循环下去
            //如果要删除的数据跟要当前的节点中的数据相同了
            if(data == curNode.getData()){
                preNode.setNext(curNode.getNext());     //将删除之前的节点的下一个节点指向要删除的节点的下一个节点
                return "删除成功";
            }
        }
        System.out.println(head);
        return "删除失败";
    }

    /* 查询是否存在 */
    public boolean selectData(int data){
        Node curNode = head;
        if(curNode != null){
            int curDate = curNode.getData();
            if(data == curDate){
                return true;
            }
            while(curNode.getNext() != null){
                curNode = curNode.getNext();
                curDate = curNode.getData();
                if(data == curDate){
                    return true;
                }
            }
        }
        return false;
    }

    /* 修改数据 */
    public String setData(int data,int newData){
        Node curNode = head;
        if(curNode == null){
            return "链表为空";
        }
        if(data == curNode.getData()){
            curNode.setData(newData);
        }
        while(curNode.getNext() != null){
            curNode = curNode.getNext();
            if(curNode.getData() == data){
                curNode.setData(newData);
                return "修改成功";
            }
        }
        return "修改失败";

    }



    /* 链表长度 */
    public int size(){
        Node curNode = head;
        int size = 1;
        if(curNode == null){
            return 0;
        }else if(curNode.getNext() == null){
            return size;
        }
        while(curNode.getNext() != null){
            curNode = curNode.getNext();
            size++;
        }
        return size;

    }

}
