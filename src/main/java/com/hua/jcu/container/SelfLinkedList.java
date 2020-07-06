package com.hua.jcu.container;

/**
 * 有序 从小到大(元素不为空)
 * @author huazai
 * @date 2020-07-04 10:07
 */
public class SelfLinkedList {

    private int size;

    private Node<Integer> first;

    private final Node<Integer> NULL_NODE = (Node<Integer>) null;


    public SelfLinkedList() {
        this.first = NULL_NODE;
    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Node<Integer> current = first;
        while (current != null) {
            builder.append(current.value.toString()).append(",");
            current = current.next;
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    public static SelfLinkedList of(Integer... elements) {

        final SelfLinkedList list = new SelfLinkedList();
        if(elements.length > 0){
            for(Integer e : elements){
                list.add(e);
            }
        }
        return list;
    }

    /**
     * 添加节点
     * @param e
     * @return
     */
    public boolean add(Integer e){

        if(e == null){
            System.out.print("元素为空，添加失败");
            return false;
        }

        final Node<Integer> newNode = new Node<Integer>(e);

        Node<Integer> current = this.first;
        Node<Integer> previous = null;

        while (current != null && current.value < e) {
            previous = current;
            current = current.next;
        }

        if(previous == null){
            //初次添加 或 添加值最小
            this.first = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;

        this.size ++;

        return true;
    }

    /**
     * 删除首节点
     * @return
     */
    public Integer removeFirst(){
        if(this.size == 0){
            return null;
        }
        Node<Integer> current = this.first;
        this.first = current.next;
        size--;
        return current.value;
    }

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    public boolean contains(Integer e){

        Node<Integer> current = this.first;

        while (current != null) {

            if(current.value.equals(e)){
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * 节点
     * @param <T>
     */
    private static class Node<T> {

        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        SelfLinkedList list = SelfLinkedList.of(10, 1, -10, -1, 100, 88, 90, 2);
        System.out.println(list.contains(-10));
        list.removeFirst();
        list.add(0);
        System.out.println(list.toString());
        System.out.println(list.contains(-10));
    }

}
