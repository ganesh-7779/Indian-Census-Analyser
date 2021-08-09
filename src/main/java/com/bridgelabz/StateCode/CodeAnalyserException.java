
package com.bridgelabz.StateCode;

import com.bridgelabz.CensusAnalyserException;

public class CodeAnalyserException extends Exception {

    public enum CodeExceptionType {
        NO_SUCH_FILE, INCORRECT_DATA_ISSUE, SOME_OTHER_IO_EXCEPTION, DELIMITER_ISSUE,
    }

    public CodeExceptionType type;
    public String message;

    public CodeAnalyserException() {
    }

    public CodeAnalyserException(CodeExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}