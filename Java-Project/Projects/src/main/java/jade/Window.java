package jade;

import jade.util.Time;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.Checks.check;
import static org.lwjgl.system.JNI.invokePPP;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

    private int width, height;
    private String title;
    private long glfwWindow;

    public float r, g, b, a;
    private boolean fadeToBlack = false;

    private static Window window = null;

    private static Scene currentScene;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Mario's Parkour Heritage ~ 2D Game";
        r = 1;
        g = 1;
        b = 1;
        a = 1;
    }

    public static void changeScene(int newScene){
        switch (newScene){
            case 0:
                currentScene = new LevelEditorScene();
                currentScene.init();
                currentScene.start();
                break;
            case 1:
                currentScene = new LevelScene();
                currentScene.init();
                currentScene.start();
                break;
            default:
                assert false : "Unknow Scene '" + newScene + "'";
                break;
        }
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }
        return Window.window;
    }

    public static Scene getScene(){
        return getWindow().currentScene;
    }

    public void run() {

        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();

        initGLFW();

        // Free The Memory
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // Terminated GLFW and the error free calls backs
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();

        if (!glfwInit()){
            throw new IllegalStateException("Unable To Initialize GLFW");
        }
    }

    private void initGLFW() {
        GLFWErrorCallback.createPrint(System.err).set();
    }

    public void init() {

        // Error Callback
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable To Initialize GLFW.");
        }

        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        // Create Window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if (glfwWindow == NULL) {
            throw new IllegalStateException("Failed To Create the GLFW Window.");
        }

        // Initialize the callback
        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);

        // Create OpenGL Context Current
        glfwMakeContextCurrent(glfwWindow);

        // Enable V-Sync
        glfwSwapInterval(1);

        // Make Window Visible
        glfwShowWindow(glfwWindow);

        // Critical Line For LWJGL Interoperation With GLFW
        // OpenGL Context Or Any Context Managed Externally
        // LWJGL Detects Current Context In Current Thread
        // Create GLCapabilities Instance And Makes OpenGL
        // Binding Available
        GL.createCapabilities();

        Window.changeScene(0);
    }

    public void loop() {

        float beginTime = Time.getTime();
        float endTime;
        float dt = -1.0f;

        while (!glfwWindowShouldClose(glfwWindow)) {
            // Poll Events
            glfwPollEvents();

            glClearColor(r, g, b, a);
            glClear(GL_COLOR_BUFFER_BIT);

            if (dt >= 0){
                currentScene.update(dt);
            }

//            if (fadeToBlack){
//                r = Math.max(r - 0.01f, 0);
//                g = Math.max(g - 0.01f, 0);
//                b = Math.max(b - 0.01f, 0);
//            }
//
//            if (KeyListener.isKeyPressed(GLFW_KEY_SPACE)){
//                fadeToBlack = true;
//            }

            glfwSwapBuffers(glfwWindow);

            endTime = Time.getTime();
            dt = endTime - beginTime;
            beginTime = endTime;
        }

        // Destroy the window and terminate GLFW when the loop exits
        glfwDestroyWindow(glfwWindow);
        glfwTerminate();
    }

//    public void cleanup() {
//        // Additional cleanup logic
//    }

    public static void glfwFreeCallbacks(@NativeType("GLFWwindow *") long window) {
        if (Checks.CHECKS) {
            check(window);
        }

        for (long callback : new long[] {
                org.lwjgl.glfw.GLFW.Functions.SetWindowPosCallback,
                GLFW.Functions.SetWindowSizeCallback,
                GLFW.Functions.SetWindowCloseCallback,
                GLFW.Functions.SetWindowRefreshCallback,
                GLFW.Functions.SetWindowFocusCallback,
                GLFW.Functions.SetWindowIconifyCallback,
                GLFW.Functions.SetWindowMaximizeCallback,
                GLFW.Functions.SetFramebufferSizeCallback,
                GLFW.Functions.SetWindowContentScaleCallback,
                GLFW.Functions.SetKeyCallback,
                GLFW.Functions.SetCharCallback,
                GLFW.Functions.SetCharModsCallback,
                GLFW.Functions.SetMouseButtonCallback,
                GLFW.Functions.SetCursorPosCallback,
                GLFW.Functions.SetCursorEnterCallback,
                GLFW.Functions.SetScrollCallback,
                GLFW.Functions.SetDropCallback
        }) {
            long prevCB = invokePPP(window, NULL, callback);
            if (prevCB != NULL) {
                Callback.free(prevCB);
            }
        }
    }
}
