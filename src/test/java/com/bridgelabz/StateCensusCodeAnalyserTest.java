package com.bridgelabz;

import com.bridgelabz.StateCode.CodeAnalyserException;
import com.bridgelabz.StateCode.StateCode;
import com.bridgelabz.StateCode.StateCodeAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusCodeAnalyserTest {
    public static final String STATECODES_CSVFILE = "D:\\fellowshipBreid\\indianCensusCsv\\src\\main\\resources\\IndiaStateCode.csv";
    public static final String STATECENSUS_CSVFILE = "D:\\fellowshipBreid\\indianCensusCsv\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String WRONG_FILE = "useless.txt";

    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCode.class);
            System.out.println(count);
            Assert.assertEquals(37, count);
        } catch (CodeAnalyserException e) {
            e.printStackTrace();
        }
    }
}
   