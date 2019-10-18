package bytecodeGenerator;

import symbolTable.OfpType;
import symbolTable.Symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends Symbol {

    private int varCount = 0;
    public Map<String,Integer> indecies = new LinkedHashMap<String,Integer>();



    public void addVariable(Symbol varSym){
        System.out.println(varSym.hashCode());
        if(varSym.getType() == OfpType.Float){
            indecies.put(varSym.getId(), varCount+=varCount+2);
        }else{
            indecies.put(varSym.getId(), varCount++);
        }
    }

    public void addParameter(ParamSymbol parSym){
        if(parSym.getType() == OfpType.Float){
            indecies.put(parSym.getId(), varCount+=varCount+2);
        }else{
            indecies.put(parSym.getId(), varCount++);
        }
    }

    public int indexOf(Symbol sym){
        return indecies.get(sym.getId());
    }




}
