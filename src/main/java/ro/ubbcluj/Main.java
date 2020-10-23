package ro.ubbcluj;

import ro.ubbcluj.domain.LexicalAnalyzer;
import ro.ubbcluj.domain.Symbol.SymbolTable;

public class Main {
    private static void testSymbolTable(){
        SymbolTable symbolTable = new SymbolTable();

        System.out.println("\nINSERTION");
        System.out.println(symbolTable.insert("buna"));
        System.out.println(symbolTable.insert("ziua"));
        System.out.println(symbolTable.insert("seara"));
        System.out.println(symbolTable.insert("ziua"));
        System.out.println(symbolTable.insert("merge"));
        System.out.println(symbolTable.insert("acum"));
        System.out.println(symbolTable.insert("gata"));

        System.out.println("\nINORDER");
        System.out.println(symbolTable.getInorder());

        System.out.println("\nFIND");
        System.out.println(symbolTable.search("salut"));
        System.out.println(symbolTable.search("ziua"));
        System.out.println(symbolTable.search("merge"));

        System.out.println("\nFIND BY ID");
        System.out.println(symbolTable.searchById(1));
        System.out.println(symbolTable.searchById(0));
    }

    private static void testScanner(){
        SymbolTable symbolTable = new SymbolTable();
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer("Problem1.txt", "Lexic.txt", "Syntax.txt", "Token.txt", symbolTable);
        lexicalAnalyzer.scan();
    }

    public static void main(String[] args) {
        System.out.println("\n SYMBOL TABLE \n");
        testSymbolTable();
        System.out.println("\n SCANNER \n");
        testScanner();
    }
}
