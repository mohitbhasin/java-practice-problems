package exceptions;

// Exception and Error: Both are subclasses of Throwable class.
// Both represents issues that can occur during program execution.

// Error: Represents severe, unrecoverable problems that programs
// generally cannot and should not attempt to recover from it.
// Eg. StackOverflowError, OutOfMemoryError

// Exception: Represents conditions that a reasonable program might want to catch and handle.
// Typically arise from internal issues with the code or
// external factors like user input, I/O problems
// Can be handled with try-catch or be thrown back.

// Checked(subclass of Exception) VS Unchecked Exception(subclass of RuntimeExceptions)
//                                  [Throwable]
//                                     /\
//                                    /  \
//                                [Error]  [Exception]
//                                          /\
//                                        /    \
//                                      /        \
//                     (All subclasses of      [RuntimeException]
//                   Exception, excluding      (All subclasses of RuntimeException
//                   RuntimeException are      are unchecked Exceptions)
//                    checked exceptions)

// Checked Exception: Any exception which is the subclass of Exception
// (excluding RuntimeException class and its subclasses) is a checked exception.
// Requires to be handled using try-catch or throws keyword.
// if a method can throw a checked exception, either throw it and use 'throws'
// in the method signature, or handle it using try-catch block.
// If not handled, the code will not compile.
// Eg: IOException, SQLException

// Unchecked(Runtime) Exception: They are exceptions which are a subclass of RuntimeException.
// Compiler does not require you to handle them, however, they can be handled using try-catch
// If a runtime exception occurs, and it has not been handled, the flow of program will break.
// Does not require explicit handling or declaration.

public class Introductory {
    public static void main(String[] args) {
        // Unchecked exception without error handling compiles fine.
        uncheckedExceptionExample(false);

        // Unchecked with error handling in order to maintain flow of the program.
        try {
            uncheckedExceptionExample(true);
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        // Checked exception requires handling, regardless of exception occurrence.
        // Code will not compile if not handled.
        // Called method is throwing exception, calling method catching it.
        try {
            checkedExceptionExample(true);
            // below method will not run because exception is raised by the call above.
            checkedExceptionExample(false);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        // After handling the exception and flow of program continues as normal.
        try {
            checkedExceptionExample(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // Unchecked exception = Runtime exception
    public static void uncheckedExceptionExample(boolean flag) {
        if(flag) {
            throw new RuntimeException("Unchecked Exception does not require 'throws' in the method signature.");
        } else {
            System.out.println("Unchecked exception not raised.");
        }
    }

    // Checked exception must be handled.
    public static void checkedExceptionExample(boolean flag) throws InterruptedException {
        if(flag) {
            throw new InterruptedException("Checked Exception requires 'throws' if throwing.");
        } else {
            System.out.println("Checked exception not raised.");
        }

    }
}
