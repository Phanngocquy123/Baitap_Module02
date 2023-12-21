import java.util.Arrays;

public class Manager {
    private BaseEntity[] entities;
    private int defaultE1 = 5;
    private int index = 0;

    public Manager(){
        this.entities = new BaseEntity[defaultE1];
    }
    public void add(BaseEntity item){
        if (index == defaultE1){
            entities = Arrays.copyOf(entities,entities.length+defaultE1);
        }
        entities[index++] = item;
    }

    public void show(){
        for (int i = 0; i < index; i++){
            entities[i].show();
        }
    }

    public BaseEntity findId(Object id){
        for (int i = 0; i < index; i++){
            if (entities[i].checkId(id)){
                return entities[i];
            }
        }
        return null;
    }



}
