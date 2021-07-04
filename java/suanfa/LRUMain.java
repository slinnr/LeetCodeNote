package main.Java.com.sunlin.suanfa;

import java.util.HashMap;
import java.util.Map;

public class LRUMain{
    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        System.out.println(lru.remove());
        lru.get(2);
        lru.get(3);
        System.out.println(lru.remove());
    }
}

/*
LRU 最近最久未使用
 */
class LRU {

 private DoubleList doubleList = new DoubleList();

 public Integer get(Integer val){
     return doubleList.get(val);
 }

 public void add(Integer val){
     doubleList.add(val);
 }

 public Integer remove(){
     return doubleList.removeLast();
 }


}

class Node{
    Integer value;
    Node last;
    Node next;
}

class DoubleList{

    Node head;
    Node end;
    Integer size;

    Map<Integer , Node> map = null;

    public DoubleList(){
        this.size = 0;
        map = new HashMap<>();
        head = new Node();
        end = new Node();
    }

    //添加到双向链表的头
    public Integer add(Integer value){

        Node node = new Node();
        node.value = value;
        map.put(node.value , node);
        if (size == 0){
            head.next = node;
            node.next = end;
            end.last = node;
        }else {
            node.next = head.next;
            head.next.last = node;
            head.next = node;
        }
        size++;
        return node.value;
    }

    //移除末尾的那个节点
    public Integer removeLast(){

        if (size == 0){
            throw new RuntimeException("没有数据，不能移除");
        }
        Integer value = end.last.value;
        map.remove(value);
        end.last = end.last.last;
        end.last.next = end;
        return value;
    }

    //将该节点移动到链表头
    public void move(Node node){

        if (node.last == head){
            return;
        }
        Node listNode = map.get(node.value);
        listNode.last.next = listNode.next;
        listNode.next.last = listNode.last;
        listNode.next = head.next;
        head.next.last = listNode;
        head.next = listNode;
        listNode.last = head;
    }

    public Integer get(Integer value){
        Node node = map.get(value);

        if (node == null)
            return null;
        this.move(node);
        return node.value;
    }
}



