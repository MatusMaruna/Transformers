package bytecodeGenerator;

import symbolTable.OfpType;
import symbolTable.Symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends Symbol {

    private int varCount = 1;
    public Map<String,Integer> variableIndecies = new LinkedHashMap<String,Integer>();
    public Map<String,Integer> paramIndecies = new LinkedHashMap<String,Integer>();



    public void addVariable(Symbol varSym){
        if(varSym.getType() == OfpType.Float){
            variableIndecies.put(varSym.getId(), varCount+=varCount+2);
        }else{
            variableIndecies.put(varSym.getId(), varCount++);
        }
    }

    public void addParameter(ParamSymbol parSym){
        if(parSym.getType() == OfpType.Float){
            paramIndecies.put(parSym.getId(), varCount+=varCount+2);
        }else{
            paramIndecies.put(parSym.getId(), varCount++);
        }
    }

    public int indexOf(Symbol sym){
        if(paramIndecies.get(sym.getId()) == null)
        return variableIndecies.get(sym.getId());
        else
        return paramIndecies.get(sym.getId());
    }




}
