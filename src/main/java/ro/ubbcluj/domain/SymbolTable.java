package ro.ubbcluj.domain;

import java.util.ArrayList;

public class SymbolTable {
    public int id = 0;
    private Node root = null;

    public Boolean insert(String data){
        if (this.root != null){
            return this.root.insert(data);
        }
        else {
            this.root = new Node(data, this.id, this);
            this.id++;
            return true;
        }
    }

    public boolean search (String data){
        if (this.root != null){
            return this.root.search(data);
        }
        return false;
    }

    public ArrayList<String> getInorder(){
        if (this.root != null){
            return this.root.getInorder(new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
