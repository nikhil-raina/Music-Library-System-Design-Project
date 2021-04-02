package Controller;

import Model.Request;
import ObjectModules.Response;

import java.text.ParseException;
import java.util.Stack;

public class UndoRedoManager {
    private Stack<Request> Undo;
    private Stack<Request> Redo;

    public UndoRedoManager(){
        this.Undo = new Stack<Request>();
        this.Redo = new Stack<Request>();
    }

    public Response Undo() throws ParseException {
        if(!this.Undo.empty()){
            Request request = Undo.pop();
            this.pushToRedo(request);
            return request.undo();
        }
        else {
            System.out.println("Empty");
            return null;
        }
    }

    public Response Redo() throws ParseException {
        if(!this.Redo.empty()){
            Request request = Redo.pop();
            this.pushToUndo(request);
            return request.redo();
        }
        else {
            System.out.println("Empty");
            return null;
        }
    }

    public void pushToUndo(Request request){
        this.Undo.push(request);
    }
    public void pushToRedo(Request request){
        this.Redo.push(request);
    }
}