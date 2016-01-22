package com.sandbox.basic;

import java.util.Date;

/**
 * Author: zhangxin
 * Date:   16-1-22
 */

//need final modifier
public final class ImmutableObject {
    //fields must final.
    private final double fMass;
    private final String fName;
    private final Date fDateOfDiscovery;

    public ImmutableObject(Date fDateOfDiscovery, String fName, double fMass) {
        //mutable object, need return new Object;
        this.fDateOfDiscovery = new Date(fDateOfDiscovery.getTime());

        this.fName = fName;
        this.fMass = fMass;
    }

    //primitive value
    public double getMass() {
        return fMass;
    }

    //immutable object
    public String getName() {
        return fName;
    }

    //mutable object, need return new Object.
    public Date getDateOfDiscovery() {
        return new Date(fDateOfDiscovery.getTime());
    }
}
