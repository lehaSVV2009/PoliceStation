package com.kadet.java.policeStation.database;

import com.kadet.java.policeStation.entity.Policeman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class PolicemanDatabase {

    private final static PolicemanDatabase instance = new PolicemanDatabase();

    public static final PolicemanDatabase getInstance () {
        return instance;
    }


    private List<Policeman> policemen;

    public PolicemanDatabase() {
        this.policemen = new ArrayList<Policeman>();
    }

    public void addPoliceman (Policeman policeman) {
        policemen.add(policeman);
    }

    public List<Policeman> getPolicemen() {
        return policemen;
    }

    public boolean remove (Policeman policeman) {
        return policemen.remove(policeman);
    }

    public int getPolicemenNumberWithoutSomebody (List<Policeman> without) {
        return getListWithoutSomebody(without).size();
    }

    public List<Policeman> getListWithoutSomebody (List<Policeman> without) {
        List<Policeman> subPolicemen = new ArrayList<Policeman>();
        for (Policeman policeman : policemen) {
            if (!without.contains(policeman)) {
                subPolicemen.add(policeman);
            }
        }
        return subPolicemen;
    }

    public List<Policeman> subListWithoutSomebody(int firstIndex, int lastIndex, List<Policeman> without) {
        List<Policeman> policemenWithout
                = getListWithoutSomebody(without);
        if (firstIndex < 0 || lastIndex < 1 || firstIndex >= lastIndex || firstIndex > policemenWithout.size()) {
            throw new RuntimeException("Bad parameters error!");
        }
        List<Policeman> subPolicemen
                = new ArrayList<Policeman>();
        for (int policemanIndex = firstIndex; policemanIndex < lastIndex && policemanIndex < policemenWithout.size(); ++policemanIndex) {
            subPolicemen.add(
                    policemenWithout.get(policemanIndex)
            );
        }
        return subPolicemen;
    }
}
