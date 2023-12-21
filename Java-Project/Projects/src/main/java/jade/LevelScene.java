package jade;

public class LevelScene extends Scene{

    public LevelScene(){
        System.out.println("Inside Of The Level Scene");
        Window.getWindow().r = 1;
        Window.getWindow().g = 1;
        Window.getWindow().b = 1;
    }

    @Override
    public void update(float dt){

    }
}
