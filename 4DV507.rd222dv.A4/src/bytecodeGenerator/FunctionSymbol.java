package bytecodeGenerator;

import symbolTable.OfpType;
import symbolTable.Symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends Symbol {

    public int varCount = 0;
    public Map<String,Integer> variableIndecies = new LinkedHashMap<String,Integer>();
    public Map<String,Integer> paramIndecies = new LinkedHashMap<String,Integer>();



    public void addVariable(Symbol varSym){
        if(varSym.getType() == OfpType.Float){
            variableIndecies.put(varSym.getId(), varCount);
            varCount++;
            varCount++;
        }else{
            variableIndecies.put(varSym.getId(), varCount);
            varCount++;
        }
    }

    public void addParameter(ParamSymbol parSym){
        if(parSym.getType() == OfpType.Float){
            paramIndecies.put(parSym.getId(), varCount);
            varCount++;
            varCount++;
        }else{
            paramIndecies.put(parSym.getId(), varCount);
            varCount++;
        }
    }

    public int indexOf(Symbol sym){
        if(paramIndecies.get(sym.getId()) == null)
        return variableIndecies.get(sym.getId());
        else
        return paramIndecies.get(sym.getId());
    }




}
