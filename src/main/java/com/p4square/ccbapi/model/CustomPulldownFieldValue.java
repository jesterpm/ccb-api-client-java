package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * A user-defined pulldown field and the associated value.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class CustomPulldownFieldValue extends CustomField {

    @XmlElement(name="selection")
    private PulldownSelection selection;

    public PulldownSelection getSelection() {
        return selection;
    }

    public void setSelection(final PulldownSelection selection) {
        this.selection = selection;
    }
}
