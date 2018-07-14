package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Specialization of {@link Reference}.
 *
 * This class exists because CCB has two different names for the "id"
 * attribute of a reference.
 */
@XmlAccessorType(XmlAccessType.NONE)
/* package-private */ class CCBIDReference {
    @XmlAttribute(name="ccb_id")
    private int id;

    @XmlValue
    private String name;

    public CCBIDReference() {}

    public CCBIDReference(Reference r) {
        this.id = r.getId();
        this.name = r.getName();
    }

    public Reference toReference() {
        final Reference r = new Reference();
        r.setId(id);
        r.setName(name);
        return r;
    }

    public static final class Adapter extends XmlAdapter<CCBIDReference, Reference> {
        @Override
        public Reference unmarshal(CCBIDReference ccbidReference) throws Exception {
            return ccbidReference.toReference();
        }

        @Override
        public CCBIDReference marshal(Reference reference) throws Exception {
            return new CCBIDReference(reference);
        }
    }
}
