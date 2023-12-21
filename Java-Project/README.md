# Java Problem (Error): undeclare identifier, assertion error, and undetected assets

## If u found the error, please contact me on DISCORD. my username: gerrardsquins (ill read ur message as fast as possible i can.)

  
## SOURCE CODE (THE POTENTIAL ERROR)

package renderer;

import components.SpriteRenderer;

import jade.Window;

import org.joml.Vector4f;

import org.lwjgl.opengl.GL;

import javax.swing.*;

import static org.lwjgl.opengl.GL15.*;

import static org.lwjgl.opengl.GL20.*;

import static org.lwjgl.opengl.GL30.glBindVertexArray;

import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class RenderBatch {

    // Vertex
    // Pos                  Color
    // float, float         float, float, float, float
    private final int POS_SIZE = 2;
    private final int COLOR_SIZE = 4;

    private final int POS_OFFSET = 0;
    private final int COLOR_OFFSET = POS_OFFSET + POS_SIZE * Float.BYTES;
    private final int VERTEX_SIZE = 6;
    private final int VERTEX_SIZE_BYTES = VERTEX_SIZE * Float.BYTES;

    private SpriteRenderer[] sprites;
    private int numSprites;
    boolean hasRoom;
    private float[] vertices;

    private int vaoID, vboID;
    private int maxBatchSize;
    private Shader shader;

    public RenderBatch(int maxBatchSize){
        shader = new Shader("assets/shaders/default.glsl");
        shader.compile();
        this.sprites = new SpriteRenderer[maxBatchSize];
        this.maxBatchSize = maxBatchSize;

        // 4 Vertices Quads
        vertices = new float[maxBatchSize * 4 * VERTEX_SIZE ];

        this.numSprites = 0;
        this.hasRoom = true;
    }

    public void start(){
        // Generate and bind a vertex array objects
        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        // Allocate Space For Vertices
        vboID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, vertices.length * Float.BYTES, GL_DYNAMIC_DRAW);

        // CREATE AND UPLOAD THE INDICADES BUFFER
        int eboID = glGenBuffers();
        int[] indices = generateIndices();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);

        // Enable The Buffer Attribute Pointers
        glVertexAttribPointer(0, POS_SIZE, GL_FLOAT, false, VERTEX_SIZE_BYTES, POS_OFFSET);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, COLOR_SIZE, GL_FLOAT, false, VERTEX_SIZE_BYTES, COLOR_OFFSET);
        glEnableVertexAttribArray(1);

    }

    public void addSprite(SpriteRenderer spr){
        // Get Index and add rendorObject
        int index = this.numSprites;

        // [0, 1, 2, 3, 4, 5]
        this.sprites[index] = spr;
        this.numSprites++;

        // Add the properties to local vertices array
        loadVertexProperties(index);

        if (numSprites >= this.maxBatchSize){
            this.hasRoom = false;
        }
    }

    public void render(){

        // For Now, We Will Rebuffer All Data Every Frame
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferSubData(GL_ARRAY_BUFFER, 0, vertices);

        // Use Shader
        shader.use();
        shader.uploadMat4f("uProjection", Window.getScene().camera().getProjectionMatrix());
        shader.uploadMat4f("uView", Window.getScene().camera().getViewMatrix());

        glBindVertexArray(vaoID);
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, this.numSprites * 6, GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);

        shader.detach();
    }

    private void loadVertexProperties(int index){
        SpriteRenderer sprite = this.sprites[index];

        // Find offset within array (4 vertices per sprites)
        int offset = index * 4 * VERTEX_SIZE;

        // float float      float float float float float
        Vector4f color = sprite.getColor();

        // Add vertices with the appropiate properties

        // *    *
        // *    *

        float xAdd = 1.0f;
        float yAdd = 1.0f;
        for (int i = 0; i < 4; i++){
            if (i == 1){
                yAdd = 0.0f;
            } else if (i == 2) {
                xAdd = 0.0f;
            } else if (i == 3) {
                yAdd = 1.0f;
            }

            // Load Positions
            vertices[offset] = sprite.gameObject.transform.position.x + (xAdd * sprite.gameObject.transform.scale.x);
            vertices[offset = 1] = sprite.gameObject.transform.position.y + (yAdd * sprite.gameObject.transform.scale.y);

            // Load Color
            vertices[offset + 2] = color.x;
            vertices[offset + 3] = color.y;
            vertices[offset + 4] = color.z;
            vertices[offset + 5] = color.w;

            offset += VERTEX_SIZE;

        }

    }

    private int[] generateIndices(){
        // 6 Indices per quad (3 per triangle_
        int[] elements = new int[6 * maxBatchSize];
        for (int i = 0; i < maxBatchSize; i++){
            loadElementIndices(elements, i);
        }
        return elements;
    }

    private void loadElementIndices(int[] elements, int index){
        int offsetArrayIndex = 6 * index;
        int offset = 4 * index;

        // 3, 2, 0, 0, 2, 1         7, 6, 4, 4, 6, 5
        // Triangle 1
        elements[offsetArrayIndex] = offset + 3;
        elements[offsetArrayIndex + 1] = offset + 2;
        elements[offsetArrayIndex + 2] = offset + 0;

        // Triangle 2
        elements[offsetArrayIndex + 3] = offset + 0;
        elements[offsetArrayIndex + 4] = offset + 2;
        elements[offsetArrayIndex + 5] = offset + 1;
    }

    private boolean hasRoom(){
        return this.hasRoom;
    }}


# LOG ERROR (Software used: Intellij Idea)

> Task :Main.main() FAILED
Hello LWJGL 3.3.3+5!
ERROR: 'assets/shaders/default.glsl'
	Vertex Shader Compilation Failed
ERROR: 0:12: 'uProjection' : undeclared identifier 


Exception in thread "main" java.lang.AssertionError: 
	at renderer.Shader.compile(Shader.java:82)
	at renderer.RenderBatch.<init>(RenderBatch.java:40)
	at renderer.Renderer.add(Renderer.java:35)
	at renderer.Renderer.add(Renderer.java:20)
	at jade.Scene.start(Scene.java:26)
	at jade.Window.changeScene(Window.java:49)
	at jade.Window.init(Window.java:143)
	at jade.Window.run(Window.java:77)
	at Main.main(Main.java:7)

'assets/shaders/default.glsl'

0:12: 'uProjection' : undeclared identifier

Execution failed for task ':Main.main()'.
> Process 'command 'E:\JAVA COMPILER\bin\java.exe'' finished with non-zero exit value 1

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.
Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.
You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.
For more on this, please refer to https://docs.gradle.org/8.2/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.
BUILD FAILED in 911ms
2 actionable tasks: 1 executed, 1 up-to-date

### Descriptions
My Program just got the Assertion Error, Undeclared identifier, and cannot detect the assets. i just confused with my error and already try to solved it on 2 days but i still didn't found what the solution, maybe u guys can help me to solve my problem, thanks.

Based on the log error, Maybe the problem is in Shader class or RenderBatch class or Renderer class or Scene class or Window class or on the build gradle or on the glsl default shader assets. I think the default.glsl file is not readed by the code because it maybe takes more initialization or something maybe?

MY CODE DOCUMENTATIONS: [GitHub](https://github.com/gerrardgs/Java-Heritage/tree/main/Java-Project/Projects)

Full Code Documentations: [GitHub](https://github.com/codingminecraft/MarioYoutube/tree/master)

SOURCE: [FreeCodeCampYouTube](https://youtu.be/025QFeZfeyM?feature=shared)

#### Tags: #gradle #java #glsl #lwjgl #opengl
