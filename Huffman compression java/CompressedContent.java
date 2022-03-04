/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancomp;

/**
 *
 * @author Robenus
 */
class CompressedContent {
     public String bitString;
    public char[] symbols;
    public String[] codeForSymbols;
    
    CompressedContent(){
        this.bitString = null;
        this.symbols = null;
        this.codeForSymbols = null;
    }
    CompressedContent(String bitString, char[] symbols, String[] codeForSymbols){
        this.bitString = bitString;
        this.symbols = symbols;
        this.codeForSymbols = codeForSymbols;
}
}
