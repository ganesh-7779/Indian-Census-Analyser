/************************************************************
 * Purpose : To perform required operations on csv data
 * @author Ganesh Gavhad
 * @Version 1.0
 * @since 09-08-2021
 ************************************************************/
package com.bridgelabz.StateCode;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCodeAnalyser {

    public StateCodeAnalyser() {
    }

    public static <T>  int openCsvBuilder(String csvFilePath, Object myClass) throws CodeAnalyserException {
        int counter = 0;
        try {
            Iterator<Object> myIterator = getIterator(csvFilePath, myClass);
            while ( myIterator.hasNext() ) {
                counter++;
                Object myObj = myIterator.next();
                System.out.println(myObj.toString()+"\t");
            }
        } catch (CodeAnalyserException e){
            throw e;
        } catch (RuntimeException e){
            throw new CodeAnalyserException(CodeAnalyserException.CodeExceptionType.DELIMITER_ISSUE,
                    "might be some error related to delimiter at record no. : " +(counter+1));
        }
        return counter;
    }

    public static Iterator<Object> getIterator(String csvFilePath, Object myClass) throws CodeAnalyserException {
        Reader reader = null;
        CsvToBean<Object> csvToBean;
        try {
            reader = Files.newBufferedReader(Paths.get(csvFilePath));
            csvToBean = new CsvToBeanBuilder(reader)
                    .withType((Class) myClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Object> myIterator = csvToBean.iterator();
            return myIterator;
        } catch (NoSuchFileException e) {
            throw new CodeAnalyserException(CodeAnalyserException.CodeExceptionType.NO_SUCH_FILE,
                    "no such file exists. Please enter correct file");
        } catch (RuntimeException e){
            throw new CodeAnalyserException(CodeAnalyserException.CodeExceptionType.INCORRECT_DATA_ISSUE,
                    "delimiter error at line 1 OR might be some error " +
                            "related to headers or incorrect extension / input file ");
        } catch (IOException e) {
            throw new CodeAnalyserException(CodeAnalyserException.CodeExceptionType.SOME_OTHER_IO_EXCEPTION,
                    "Some other IO related exception");
        }
    }
}