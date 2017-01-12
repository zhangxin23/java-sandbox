package com.sandbox.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: zhangxin
 * Date: 2016-12-29
 * Time: 10:50:00
 */
public class SortedList {

    public static class Food {
        private long spu_id = 0l;
        private long sku_id = 0l;
        private String name = "";

        public Food() {

        }

        public Food(long spu_id, long sku_id, String name) {
            this.spu_id = spu_id;
            this.sku_id = sku_id;
            this.name = name;
        }

        public long getSpu_id() {
            return spu_id;
        }

        public void setSpu_id(long spu_id) {
            this.spu_id = spu_id;
        }

        public long getSku_id() {
            return sku_id;
        }

        public void setSku_id(long sku_id) {
            this.sku_id = sku_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Food food = (Food) o;

            if (spu_id != food.spu_id) return false;
            return sku_id == food.sku_id;

        }

        @Override
        public int hashCode() {
            int result = (int) (spu_id ^ (spu_id >>> 32));
            result = 31 * result + (int) (sku_id ^ (sku_id >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "spu_id=" + spu_id +
                    ", sku_id=" + sku_id +
                    ", name='" + name + '\'' +
                    '}';
        }


    }

    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food(1, 1, "one"));
        foodList.add(new Food(1, 1, "one"));
        foodList.add(new Food(2, 2, "two"));
        foodList.add(new Food(2, 2, "two"));
        foodList.add(new Food(3, 3, "three"));
        foodList.add(new Food(3, 3, "three"));

        Set<Food> foodSet = new HashSet<>(foodList);
        for(Food item: foodSet) {
            System.out.println(item);
        }
    }
}
