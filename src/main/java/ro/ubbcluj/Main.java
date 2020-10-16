package ro.ubbcluj;

import ro.ubbcluj.domain.SymbolTable;

public class Main {
    public static void main(String[] args) {
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
    }
}
