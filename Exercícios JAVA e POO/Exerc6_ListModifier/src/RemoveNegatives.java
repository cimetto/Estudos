import java.util.ArrayList;

public class RemoveNegatives implements ListModifier{

    @Override
    public void listModifier(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++){
            list.removeIf(number -> number < 0);
        }
    }
    
}
