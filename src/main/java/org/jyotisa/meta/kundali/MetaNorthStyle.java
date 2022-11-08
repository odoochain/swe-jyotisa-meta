/*
 * Copyright (C) By the Author
 * Author    Yara Krymlov
 * Created   2022-11
 */
package org.jyotisa.meta.kundali;

import org.jyotisa.meta.api.IMetaJyotisaPojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yura Krymlov
 * @version 1.0, 2022-11
 */
public class MetaNorthStyle implements IMetaJyotisaPojo {
    protected final List<Integer> infoBox = new ArrayList<>(4);
    protected final List<MetaBhavaSeq> viewBox = new ArrayList<>(12);
    protected final Map<String, List<MetaBhavaSeq>> objects = new LinkedHashMap<>();

    public List<Integer> infoBox() {
        return infoBox;
    }

    public List<MetaBhavaSeq> viewBox() {
        return viewBox;
    }

    public Map<String, List<MetaBhavaSeq>> objects() {
        return objects;
    }
}