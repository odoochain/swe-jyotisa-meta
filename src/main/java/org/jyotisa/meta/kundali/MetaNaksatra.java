/*
 * Copyright (C) By the Author
 * Author    Yara Krymlov
 * Created   2022-11
 */
package org.jyotisa.meta.kundali;

import org.jyotisa.meta.base.MetaTheme;

/**
 * @author Yura Krymlov
 * @version 1.0, 2022-11
 */
public class MetaNaksatra extends MetaTheme {
    protected Integer lord;

    public Integer lord() {
        return lord;
    }

    public void lord(Integer lord) {
        this.lord = lord;
    }
}
