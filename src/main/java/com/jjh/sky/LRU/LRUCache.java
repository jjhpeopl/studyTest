package com.jjh.sky.LRU;

import java.util.Hashtable;

/**
 * Created by jjh on 16/10/9.
 */
public class LRUCache {

    private int currentSize;

    private int cacheSize;

    private Hashtable nodes;

    private CacheNode first;        // 链表头

    private CacheNode last;         // 链表尾

    /**
     * 链表节点
     */
    class CacheNode {
        CacheNode prev;     // 前一节点
        CacheNode next;     // 后一节点
        Object value;       // 值
        Object key;         // 键

        CacheNode() {}
    }

    public LRUCache(int i) {
        currentSize = 0;
        cacheSize = i;
        nodes = new Hashtable(i);
    }

    /**
     * 获取缓存中的对象
     * @param key
     * @return
     */
    public Object get(Object key) {
        CacheNode cacheNode = (CacheNode)nodes.get(key);
        if (cacheNode != null) {
            moveToHead(cacheNode);
            return cacheNode.value;
        } else {
            return null;
        }
    }

    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        CacheNode cacheNode = (CacheNode) nodes.get(key);

        if (cacheNode == null) {
            // 缓存容器是否已经超过大小
            if (currentSize > cacheSize) {
                if (last != null) {
                    // 将最少使用的删除
                    nodes.remove(last.key);
                }
                removeLast();
            } else {
                currentSize ++;
            }

            cacheNode = new CacheNode();
        }

        cacheNode.key = key;
        cacheNode.value = value;
        // 将最新节点放到链表头
        moveToHead(cacheNode);
        nodes.put(key, cacheNode);
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public Object remove(Object key) {
        CacheNode cacheNode = (CacheNode) nodes.get(key);

        if (cacheNode != null) {
            if (cacheNode.prev != null) {
                cacheNode.prev.next = cacheNode.next;
            }

            if (cacheNode.next != null) {
                cacheNode.next.prev = cacheNode.prev;
            }

            if (last == cacheNode) {
                last = cacheNode.prev;
            }

            if (first == cacheNode) {
                first = cacheNode.next;
            }
        }

        return cacheNode;
    }

    public void clear() {
        first = null;
        last = null;
    }

    /**
     * 删除链表尾部节点
     */
    private void removeLast() {
        if (last != null) {
            if (last.prev != null) {
                last.prev.next = null;
            } else {
                first = null;
            }
            last = last.prev;
        }
    }

    /**
     * 移动到链表头,表示这个节点最新使用过
     * @param cacheNode
     */
    private void moveToHead(CacheNode cacheNode) {
        if (cacheNode == first) {
            return;
        }
        if (cacheNode == last) {
            last = cacheNode.prev;
        }
        if (cacheNode.prev != null) {
            cacheNode.prev.next = cacheNode.next;
        }
        if (cacheNode.next != null) {
            cacheNode.next.prev = cacheNode.prev;
        }
        if (first != null) {
            cacheNode.next = first;
            first.prev = cacheNode;
        }
        first = cacheNode;
        cacheNode.prev = null;
        if (last == null) {
            last = first;
        }
    }

}
