package ro.ubbcluj.domain;

import ro.ubbcluj.domain.Symbol.SymbolTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LexicalAnalyzer {
    private File program;
    private File lexic;
    private File syntax;
    private File tokens;
    private SymbolTable symbolTable;

    public LexicalAnalyzer(String program, String lexic, String syntax, String tokens, SymbolTable symbolTable){
        this.program = new File("D:\\FCLD\\Lab2\\src\\main\\resources\\" + program);
        this.lexic = new File("D:\\FCLD\\Lab2\\src\\main\\resources\\" + lexic);
        this.syntax = new File("D:\\FCLD\\Lab2\\src\\main\\resources\\" + syntax);
        this.tokens = new File("D:\\FCLD\\Lab2\\src\\main\\resources\\" + tokens);
        this.symbolTable = symbolTable;
    }

    public void scan(){
        try {
            Scanner programFileScanner = new Scanner(this.program);
            int lineIndex = 0;

            while (programFileScanner.hasNext()){
                String line = programFileScanner.nextLine();
                lineIndex++;

                List<String> tokens = this.detectToken(line);

                for (String token : tokens) {
                    if (this.validateToken(token)){
                        this.generatePIF(token, -1);
                    }
                    else if (this.isConstant(token)){
                        this.symbolTable.insert(token);
                        int index = this.symbolTable.search(token);
                        this.generatePIF(token, index);
                    }
                    else {
                        System.out.println("Lexical error! line: " + lineIndex + " - " + token);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isConstant(String token) {
        return "^[a-zA-Z]([a-zA-Z]|[0-9])$".contains(token) || "^(0|[-]?[1-9][0-9]*)$".contains(token)
                || "^\".*\"$".contains(token) || "^'.*'$".contains(token);
    }

    private void generatePIF(String token, int i) {
    }

    private boolean validateToken(String token) {
        List<String> possible = Arrays.asList("+", "*", "/", "%","=", "==", "!=", "<=", ">=", "<", ">", "^", "&", "|", "!",
                "(", ")", "[", "]", "{", "}", ":", ";", ",", " ", "\t", "\n",
                "fun", "if", "else", "while", "for", "from", "to", "console.write", "console.read",
                "int", "boolean", "real", "char", "const", "let", "string", "true", "false");
        return possible.contains(token);
    }

    private List<String> detectToken(String line) {
        List<String> tokens = new ArrayList<>();
        String[] l = line.strip().split( "[+*\"/=!<>^&|(){}:;,\t\n ]");

        for (String element : l) {
            if (!" \n\t".contains(element)){
                System.out.println(element);
                tokens.add(element);
            }
        }

        return tokens;
    }


}
