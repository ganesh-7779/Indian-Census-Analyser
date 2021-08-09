/************************************************************************
 * Purpose : Pojo model for Census csv file
 * Entries in state code csv file will be made as objects of this class
 * @author Ganesh Gavhad
 * @Since 09-08-2021
 * @Version 1.0
 *********************************************************************/
package com.bridgelabz.StateCode;

import com.opencsv.bean.CsvBindByName;

public class StateCode {

    @CsvBindByName(column = "Sr.No")
    private int srNo;

    @CsvBindByName(column = "StateName")
    private String stateName;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "StateCode")
    private String stateCode;

    public StateCode() {

    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public int getTin() {
        return tin;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return  "stateName='" + stateName + '\'' +
                ", Sr.No='" + srNo + '\'' +
                ", TIN ='" + tin + '\'' +
                ", StateCode='" + stateCode + '\''
                +"\n";
    }
}
