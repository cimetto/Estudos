import java.util.ArrayList;

public class Multiplier implements ListModifier{

    @Override
    public void listModifier(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) * 2);
        }
    }
    
}
