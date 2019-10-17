package bytecodeGenerator;

import symbolTable.Symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class functionSymbol extends Symbol {

    private int varCount = 0;
    private Map<Symbol,Integer> indecies = new LinkedHashMap<Symbol,Integer>();



    public void addVariable(Symbol varSym){

    }

    public void addParameter(Symbol parSym){

    }

    public int indexOf(Symbol sym){
        return 0;
    }




}
