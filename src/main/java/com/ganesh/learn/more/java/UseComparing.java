package com.ganesh.learn.more.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class UseComparing {

    static class ProductData {
        public ProductData(BigInteger sequenceId, String manufacturerName) {
            this.sequenceId = sequenceId;
            this.manufacturerName = manufacturerName;
        }

        BigInteger sequenceId;
        String manufacturerName;

        public BigInteger getSequenceId() {
            return sequenceId;
        }

        public void setSequenceId(BigInteger sequenceId) {
            this.sequenceId = sequenceId;
        }

        public String getManufacturerName() {
            return manufacturerName;
        }

        public void setManufacturerName(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String toString() {
            return "ProductData{ " + sequenceId +
                    "," + manufacturerName + " }";
        }
    }

    public static void main(String[] args) {
        List<ProductData> products = new ArrayList<>();

        products.add(new ProductData(BigInteger.valueOf(1), "B"));
        products.add(new ProductData(BigInteger.valueOf(4), "A"));
        products.add(new ProductData(BigInteger.valueOf(5), "C"));
        products.add(new ProductData(null, "D"));
        products.add(new ProductData(null, "E"));

        products.sort(Comparator.comparing(ProductData::getSequenceId, Comparator.nullsLast(naturalOrder())));

        System.out.println(products);
    }
}
