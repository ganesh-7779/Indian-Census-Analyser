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
    @Test
    public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(WRONG_FILE, StateCensus.class);
        } catch ( CodeAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CodeAnalyserException.CodeExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void GivenTheStateCensusCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCodeAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CodeAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CodeAnalyserException.CodeExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }
}
