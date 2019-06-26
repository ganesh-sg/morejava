package com.ganesh.learn.more.java;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class Main1 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Coffee coffee = new Coffee("Coffee taste", "Lot of sugar");
        //Tea tea = new Tea();

        //BeanUtils.copyProperties(tea, coffee);
        PropertyUtils.setProperty(coffee, "sugar", "Added Sugar");
        System.out.println(coffee);

//        List<?> someList = new ArrayList<String>();
//        someList.add(new Object());
//
//        List<Object> someObjectList = new ArrayList<>();
//        someObjectList.add("One");
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("One");
        listOfStrings.add("Two");
        listOfStrings.add("Three");

        Iterator<String> iterator = listOfStrings.iterator();
        boolean removed = false;

    }
}
