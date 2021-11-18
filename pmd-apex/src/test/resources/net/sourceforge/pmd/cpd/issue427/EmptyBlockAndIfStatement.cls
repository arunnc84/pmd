public with sharing class EmptyBlockAndIfStatement {
    public String bugTest(String errorMessage){
        if(String.isEmpty(errorMessage)){

        }
        return errorMessage;
    }
}
