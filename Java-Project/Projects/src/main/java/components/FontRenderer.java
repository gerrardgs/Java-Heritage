package components;

import jade.Component;
import jade.GameObject;

public class FontRenderer extends Component {



    @Override
    public void start(){
        if (GameObject.getComponent(SpriteRenderer.class) != null){
            System.out.println("Found Font Renderer!");
        }
    }

    @Override
    public void update(float dt){

    }
}
