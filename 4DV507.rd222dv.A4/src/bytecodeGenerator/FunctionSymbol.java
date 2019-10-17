package bytecodeGenerator;

import symbolTable.OfpType;
import symbolTable.Symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends Symbol {

    private int varCount = 0;
    private Map<Symbol,Integer> indecies = new LinkedHashMap<Symbol,Integer>();



    public void addVariable(Symbol varSym){
        if(varSym.getType() == OfpType.Float){
            indecies.put(varSym, varCount+=varCount+2);
        }else{
            indecies.put(varSym, varCount++);
        }
    }

    public void addParameter(Symbol parSym){
        if(parSym.getType() == OfpType.Float){
            indecies.put(parSym, varCount+=varCount+2);
        }else{
            indecies.put(parSym, varCount++);
        }
    }

    public int indexOf(Symbol sym){
        return indecies.get(sym);
    }




}
