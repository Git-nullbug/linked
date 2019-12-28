package cn.xdl.SingleLinkedCycle;

import cn.xdl.node.Node;

public class SingleLinkedCycle {

    private Node head = null;

    /* 尾部增加 */
    public void append(int data){
        Node newNode = new Node(data);  //要增加的新对象
        Node node = head;   //定义一个临时变量
        //当链表为空时
        if(node == null){
            head = newNode;
            head.setNext(head);
            return;
        }
        //循环遍历拿到最后一个节点 ：node.getNext == head 时，while循环当()括号内条件不成立时结束循环
        while(node.getNext() != head){
            node = node.getNext();
        }
        node.setNext(newNode);      //此时node指向的是最后一个节点，将新的对象节点加入到最后
        newNode.setNext(head);      //将新加入的节点的下一个指向头节点这样继续形成循环
    }


    /* 循环遍历链表 */
    public void findAll(){
        if(head == null) {
            System.out.println("null");
            return;
        }
        Node node = head;
        while (node.getNext() != head){
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println(node.getData());

    }

    /* 删除指定数据 */
    public boolean delete(int data){
        if(head == null) return false;      //如果链表为空直接返回false
        Node preNode = head;    //要删除的节点前面的节点
        Node deleteNode = head.getNext();     //要删除的节点
        //循环遍历查找链表中数据于要删除一致的数据
        while(deleteNode != head){
            if(data == deleteNode.getData()) break;     //当该数据与要删除的数据一致时结束循环
            preNode = deleteNode;       //前面的节点同步后移
            deleteNode = deleteNode.getNext();  //要删除的节点后移 形成循环
        }
        // 当循环结束 删除节点等于头节点并且要删除的数据等于删除节点中的数据则进说明是删除头节点进if
        if(deleteNode == head && data == deleteNode.getData()){
            head = deleteNode.getNext();
            preNode.setNext(head);
            deleteNode.setNext(null);
            return true;
        }else if(data == deleteNode.getData()){         // 如果要删除的数据与循环后得到的删除节点中的数据一致则删除该节点
            preNode.setNext(deleteNode.getNext());
            deleteNode.setNext(null);
            return true;
        }else{      // 如果以上都没执行 则说明链表中没有该数据，直接返回 false
            return false;
        }
    }

    /* 修改数据 */
    public boolean setData(int data,int newData){
        if(head == null) return false;      //如果链表为空直接返回空
        Node node = head;       //定义一个临时变量
        //循环遍历查找与节点中一致的数据
        while(node.getNext() != head){
            if(data == node.getData()) break;
            node = node.getNext();
        }
        if(data == node.getData()){
            node.setData(newData);
            return true;
        }
        return false;
    }

    /* 查询单个数据是否存在 */
    public boolean exist(int data){
        if(head == null) return false;
        Node node = head;
        while(node.getNext() != head){
            node = node.getNext();
            if(data == node.getData()) return true;
        }
        return false;
    }


    /* 链表长度 */
    public int size(){
        Node node = head;
        int size = 0;
        if(node == null) return size;
        while(node.getNext() != head){
            size++;
            node = node.getNext();
        }
        return size+1;
    }

    @Override
    public String toString() {
        if(head == null) return null;
        Node node = head;
        int data = 0;
        StringBuilder sb = new StringBuilder();
        while(node.getNext() != head){
            data = node.getData();
            node = node.getNext();
            sb.append(data+" ");
        }
        data = node.getData();
        sb.append(data);
        String str = sb.toString();
        return str;
    }


}
