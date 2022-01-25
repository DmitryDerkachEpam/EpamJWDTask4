package com.epam.textProcessing;

import java.util.Comparator;

import com.epam.textComponents.Composite;

public class ChildComponentsComparator implements Comparator<Composite> {
    @Override
    public int compare(Composite o1, Composite o2) {
        return o1.getNumberOfChildren() - o2.getNumberOfChildren();
    }
}
