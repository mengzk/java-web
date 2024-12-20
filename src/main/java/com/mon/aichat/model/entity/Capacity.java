package com.mon.aichat.model.entity;

/**
 * Author: Meng
 * Date: 2024-08-23
 * Desc:
 */
public class Capacity {
    private Item used;
    private Item total;

    public Item getUsed() {
        return used;
    }

    public void setUsed(Item used) {
        this.used = used;
    }

    public Item getTotal() {
        return total;
    }

    public void setTotal(Item total) {
        this.total = total;
    }

    public static class Item {
        private long word_num;
        private long length;

        public long getWord_num() {
            return word_num;
        }

        public void setWord_num(long word_num) {
            this.word_num = word_num;
        }

        public long getLength() {
            return length;
        }

        public void setLength(long length) {
            this.length = length;
        }
    }
}
